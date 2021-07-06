package com.example.weTraveller.model;

import com.example.weTraveller.entity.Post;

public class PostModel {

    private long id;
    private String postDescription;

    public PostModel(){

    }

    public PostModel(Post entity){
        this.setId(entity.getId());
        this.setPostDescription(entity.getPostDescription());
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
}
