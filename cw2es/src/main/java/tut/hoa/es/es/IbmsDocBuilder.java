package tut.hoa.es.es;

public final class IbmsDocBuilder {
    String type;
    long timeStamp;
    String base64Xml;
    String sourceMediaId;
    String ibmsTitleId;
    String sourceSystem;
    String progTitle;
    String txMediaId;

    private IbmsDocBuilder() {
    }

    public static IbmsDocBuilder anIbmsDoc() {
        return new IbmsDocBuilder();
    }

    public IbmsDocBuilder withType(String type) {
        this.type = type;
        return this;
    }

    public IbmsDocBuilder withTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
        return this;
    }

    public IbmsDocBuilder withBase64Xml(String base64Xml) {
        this.base64Xml = base64Xml;
        return this;
    }

    public IbmsDocBuilder withSourceMediaId(String sourceMediaId) {
        this.sourceMediaId = sourceMediaId;
        return this;
    }

    public IbmsDocBuilder withIbmsTitleId(String ibmsTitleId) {
        this.ibmsTitleId = ibmsTitleId;
        return this;
    }

    public IbmsDocBuilder withSourceSystem(String sourceSystem) {
        this.sourceSystem = sourceSystem;
        return this;
    }

    public IbmsDocBuilder withProgTitle(String progTitle) {
        this.progTitle = progTitle;
        return this;
    }

    public IbmsDocBuilder withTxMedia(String txId){
        this.txMediaId = txId;
        return this;
    }

    public IbmsDoc build() {
        IbmsDoc ibmsDoc = new IbmsDoc();
        ibmsDoc.setType(type);
        ibmsDoc.setTimeStamp(timeStamp);
        ibmsDoc.setBase64Xml(base64Xml);
        ibmsDoc.setSourceMediaId(sourceMediaId);
        ibmsDoc.setIbmsTitleId(ibmsTitleId);
        ibmsDoc.setSourceSystem(sourceSystem);
        ibmsDoc.setProgTitle(progTitle);
        ibmsDoc.setTxMediaId(txMediaId);
        return ibmsDoc;
    }
}
