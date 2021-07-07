package com.weTraveller.model;

public class PrivacyModel {

    private long id;
    private String privacyName;
    private String privacyId;

    public PrivacyModel(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPrivacyName() {
        return privacyName;
    }

    public void setPrivacyName(String privacyName) {
        this.privacyName = privacyName;
    }

    public String getPrivacyId() {
        return privacyId;
    }

    public void setPrivacyId(String privacyId) {
        this.privacyId = privacyId;
    }
}
