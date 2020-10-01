package tut.hoa.es.ibms;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Actions {
    @JacksonXmlProperty(localName = "CreateOrUpdateTitle")
    CreateOrUpdateTitle createOrUpdateTitle;

    public CreateOrUpdateTitle getCreateOrUpdateTitle() {
        return createOrUpdateTitle;
    }

    public void setCreateOrUpdateTitle(CreateOrUpdateTitle createOrUpdateTitle) {
        this.createOrUpdateTitle = createOrUpdateTitle;
    }
}
