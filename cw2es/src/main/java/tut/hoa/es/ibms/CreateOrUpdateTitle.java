package tut.hoa.es.ibms;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateOrUpdateTitle {
    @JacksonXmlProperty(localName="ibms_title_id", isAttribute=true)
    String ibmsTitleId;
    @JacksonXmlProperty(localName="source_media_id", isAttribute=true)
    String sourceMediaId;
    @JacksonXmlProperty(localName="source_system", isAttribute=true)
    String sourceSystem;
    @JacksonXmlProperty(localName="tx_media_id", isAttribute=true)
    String txMediaId;
    @JacksonXmlProperty(localName="Program_Title")
    String progTitle;

    public String getIbmsTitleId() {
        return ibmsTitleId;
    }
    public void setIbmsTitleId(String ibmsTitleId) {
        this.ibmsTitleId = ibmsTitleId;
    }

    public String getSourceMediaId() {
        return sourceMediaId;
    }

    public void setSourceMediaId(String sourceMediaId) {
        this.sourceMediaId = sourceMediaId;
    }

    public String getSourceSystem() {
        return sourceSystem;
    }

    public void setSourceSystem(String sourceSystem) {
        this.sourceSystem = sourceSystem;
    }

    public String getTxMediaId() {
        return txMediaId;
    }

    public void setTxMediaId(String txMediaId) {
        this.txMediaId = txMediaId;
    }

    public String getProgTitle() {
        return progTitle;
    }

    public void setProgTitle(String progTitle) {
        this.progTitle = progTitle;
    }
}
