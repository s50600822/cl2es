package tut.hoa.es;


public class CloudWatchEvent {
    //{"logStreamName": "2020/06/16/[$LATEST]9aa15e9ab65a4ba9b0f0a28ea73704c0", "timestamp": 1592280441786, "message": "{\"name\":\"orchestration-publisher\",\"hostname\":\"169.254.249.21\",\"pid\":8,\"awsRequestId\":\"e6080f8f-c028-4c5d-a2aa-59e538fedd5e\",\"functionName\":\"orchestration-publisher-production\",\"action\":\"OrchestrationPublisher\",\"userId\":null,\"id\":\"production.ibms.aresrightplaceholder-e0a8d1a0-af86-11ea-92be-5bfaf74023c7\",\"level\":30,\"topic\":\"production.ibms.aresrightplaceholder\",\"body\":\"<AresMessageExchange xmlns=\\\"http://foxtel.com.au/schemas/Ares/Messages/1/0\\\" messageID=\\\"20200616140721\\\" senderID=\\\"FOXTEL\\\"><Actions><CreateOrUpdateTitle content_type=\\\"TV_EPS\\\" ibms_title_id=\\\"9670582\\\" ibms_version_id=\\\"9996394\\\" source_media_id=\\\"MD125670\\\" source_system=\\\"MAM\\\" tx_media_id=\\\"TX146616\\\"><Program_Title>Single Parents</Program_Title><Distributor name=\\\"20th Century Fox\\\" reportingcode=\\\"FOX\\\"/><Production_Year>2019</Production_Year><Episode_Title>Look, This Is Obviously A Sexy Situation</Episode_Title><Season_No>2</Season_No><Episode_No>20</Episode_No><Estimated_Duration>P0DT0H41M11.000S</Estimated_Duration><Season_Name>Single Parents</Season_Name><Genre>Entertainment:Comedy</Genre></CreateOrUpdateTitle></Actions></AresMessageExchange>\",\"headers\":{\"Accept-Encoding\":\"gzip\",\"Akamai-Origin-Hop\":\"2\",\"Authorization\":\"Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Ik56aEJPVFJHT0RjNE1FUkRSRFJEUTBVd1FrVkdNRGt4TVVVNVF6RTRRa0UzTkVVMk1rVkRRZyJ9.eyJpc3MiOiJodHRwczovL2F1dGguc3RyZWFtb3Rpb24uY29tLmF1LyIsInN1YiI6IlZvUmRDRVZIZkRiclgxUWZLR1ZkbEx5Qzl4N29lWUw2QGNsaWVudHMiLCJhdWQiOiJldmVudHMuc3RyZWFtb3Rpb24uY29tLmF1IiwiaWF0IjoxNTkyMjMwMjAwLCJleHAiOjE1OTIzMTY2MDAsImF6cCI6IlZvUmRDRVZIZkRiclgxUWZLR1ZkbEx5Qzl4N29lWUw2Iiwic2NvcGUiOiJwdWJsaXNoOmZveHRlbCIsImd0eSI6ImNsaWVudC1jcmVkZW50aWFscyJ9.AGd92dLHZYMISyeabSbftz62_fA7wqQJz7fvDm1wxOZj-OwWLvy9FRbaCWB49mpCWwGapAgi-sYc9p0wmgRO6wge-AVdmP5EaW9ajqGexbc7wIn43fs0CHp6vIoLL_h4SyCoCn1XjfgNL1f6QL9ES5gIV8XUfz9DWtUSg_9ICe1kBNPhGB3v7NYSjX9imYE3zHoeF3SJU_mMyE1Fw5_NxayGUAw40kacmbEHENz4F9JY789VpEEWKtAvOZtp2oAulJBBMv0b1eo-QvLkBW9vT12vbeV70SHdOuZ_LucSl7YzNIUNi9e71WURpQnCTEKs_8qYPS1QfJS-Qv6wSxE-tQ\",\"Cache-Control\":\"max-age=30\",\"Content-Type\":\"application/xml\",\"Cookie\":\"$Version=0; $Path=/; $Domain=.streamotion.com.au\",\"Host\":\"videoevents.platform.streamotion-platform-prod.com.au\",\"True-Client-IP\":\"203.17.26.193\",\"User-Agent\":\"Jakarta Commons-HttpClient/3.1\",\"Via\":\"1.1 v1-akamaitech.net(ghost) (AkamaiGHost), 1.1 akamai.net(ghost) (AkamaiGHost)\",\"X-Akamai-CONFIG-LOG-DETAIL\":\"true\",\"X-Amzn-Trace-Id\":\"Root=1-5ee84579-bb6f427509b8bc93270ba41f\",\"X-Forwarded-For\":\"203.17.26.193, 60.254.143.110, 23.1.240.77\",\"X-Forwarded-Port\":\"443\",\"X-Forwarded-Proto\":\"https\"},\"msg\":\"\",\"time\":\"2020-06-16T04:07:21.786Z\",\"v\":0}\n", "ingestionTime": 1592280450809, "eventId": "35509040416873358895779317646722047454272522636684623874"}
    String logStreamName;
    long timestamp;
    String message;
    long ingestionTime;
    String eventId;

    public String getLogStreamName() {
        return logStreamName;
    }

    public void setLogStreamName(String logStreamName) {
        this.logStreamName = logStreamName;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getIngestionTime() {
        return ingestionTime;
    }

    public void setIngestionTime(long ingestionTime) {
        this.ingestionTime = ingestionTime;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    @Override
    public String toString() {
        return "CloudWatchEvent{" +
                "logStreamName='" + logStreamName + '\'' +
                ", timestamp=" + timestamp +
                ", message='" + message + '\'' +
                ", ingestionTime=" + ingestionTime +
                ", eventId='" + eventId + '\'' +
                '}';
    }
}
