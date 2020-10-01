package tut.hoa.es;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.refresh.RefreshRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import tut.hoa.es.es.IbmsDoc;
import tut.hoa.es.es.IbmsDocBuilder;
import tut.hoa.es.ibms.AresMessageExchange;
import tut.hoa.es.ibms.CreateOrUpdateTitle;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Base64;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.elasticsearch.client.RequestOptions.DEFAULT;
import static org.elasticsearch.common.xcontent.XContentType.JSON;

/**
 * Hello world!
 */
public class App {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final XmlMapper xmlMapper = new XmlMapper();
    private static RestHighLevelClient esClient;

    public static void main(String[] args) throws IOException {
        Instant start = Instant.now();
        esClient = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200, "http")));
        xmlMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);

        final String cwLog = "Z:\\CW\\V2\\1600781143000";

        CloudWatchQueryResult events = objectMapper.readValue(new File(cwLog), CloudWatchQueryResult.class);
        List<IbmsDoc> docs = events.getEvents()
                .parallelStream()
                .filter(cloudWatchEvent -> cloudWatchEvent.message.contains("AresMessageExchange"))
                .map(App::toDoc)
                .collect(toList());

        index(docs);
        Instant end = Instant.now();

        System.out.println(Duration.between(start, end).getSeconds());

    }

    static IbmsDoc toDoc(CloudWatchEvent event) {
        try {
            String xml = extractEvent(event.getMessage());
            AresMessageExchange ph = xmlMapper.readValue(xml, AresMessageExchange.class);

            CreateOrUpdateTitle createOrUpdateTitle = ph.getActions().getCreateOrUpdateTitle();
            return IbmsDocBuilder.anIbmsDoc()
                    .withTxMedia(createOrUpdateTitle.getTxMediaId())
                    .withProgTitle(createOrUpdateTitle.getProgTitle())
                    .withSourceMediaId(createOrUpdateTitle.getSourceMediaId())
                    .withSourceSystem(createOrUpdateTitle.getSourceSystem())
                    .withIbmsTitleId(createOrUpdateTitle.getIbmsTitleId())
                    .withBase64Xml(Base64.getEncoder().encodeToString(xml.getBytes()))
                    .withTimeStamp(event.getTimestamp())
                    .withType("placeHolder")
                    .build();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

//    static void indexAsync(List<IbmsDoc> docs) throws IOException {
//        ActionListener listener = new ActionListener<IndexResponse>() {
//            @Override
//            public void onResponse(IndexResponse indexResponse) {}
//
//            @Override
//            public void onFailure(Exception e) { e.printStackTrace();}
//        };
//        String index = String.valueOf(Instant.now().toEpochMilli());
//        CreateIndexRequest request = new CreateIndexRequest(index);
//        esClient.indices().create(request, DEFAULT);
//        docs.parallelStream()
//                .forEach(doc -> {
//                    try {
//                        IndexRequest indexRequest = new IndexRequest(index)
//                                .id(String.valueOf(doc.getTimeStamp()))
//                                .source(objectMapper.writeValueAsString(doc), JSON);
//                        esClient.indexAsync(indexRequest, DEFAULT, listener);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                });
//
//    }

    static void index(List<IbmsDoc> docs) throws IOException {
        String index = String.valueOf(Instant.now().toEpochMilli());
        CreateIndexRequest request = new CreateIndexRequest(index);
        esClient.indices().create(request, DEFAULT);
        docs.parallelStream()
                .forEach(doc -> {
                    try {
                        IndexRequest indexRequest = new IndexRequest(index)
                                .id(String.valueOf(doc.getTimeStamp()))
                                .source(objectMapper.writeValueAsString(doc), JSON);
                        esClient.index(indexRequest, DEFAULT);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
        esClient.indices().refresh(new RefreshRequest(index), DEFAULT);
    }

    static String extractEvent(String message) {
        int start = message.indexOf("<AresMessageExchange");
        int end = message.indexOf("</AresMessageExchange>") + "</AresMessageExchange>".length();
        return message.substring(start, end).replaceAll("\\\\\"", "\"");
    }
}
