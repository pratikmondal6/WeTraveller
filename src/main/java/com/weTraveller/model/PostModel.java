package com.weTraveller.model;


import com.weTraveller.entity.Post;

public class PostModel {

    private long id;
    private String postDescription;
    private String privacyId;
    private String locationId;


    public PostModel(){

    }

    public PostModel(Post entity){
        this.setId(entity.getId());
        this.setPostDescription(entity.getPostDescription());
        this.setPrivacyId(entity.getPrivacyId());
        this.setLocationId(entity.getLocationId());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPostDescription() {
        return postDescription;
    }

    public void setPostDescription(String postDescription) {
        this.postDescription = postDescription;
    }

    public String getPrivacyId() {
        return privacyId;
    }

    public void setPrivacyId(String privacyId) {
        this.privacyId = privacyId;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }
}
