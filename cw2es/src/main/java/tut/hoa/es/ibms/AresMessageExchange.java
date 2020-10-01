package tut.hoa.es.ibms;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AresMessageExchange {
    @JacksonXmlProperty(localName = "Actions")
    Actions actions;
    @JacksonXmlProperty(localName = "messageID", isAttribute = true)
    String messageID;

    public Actions getActions() {
        return actions;
    }

    public void setActions(Actions actions) {
        this.actions = actions;
    }

    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }
}
