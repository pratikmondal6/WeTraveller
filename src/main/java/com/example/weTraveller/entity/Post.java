package com.example.weTraveller.entity;


import com.example.weTraveller.entity.common.CommonColumn;
import com.example.weTraveller.model.PostModel;

import javax.persistence.*;

@Entity
@Table(name = "post" )
public class Post extends CommonColumn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "post_description", length = 500)
    private String postDescription;


    public Post(){

    }

    public Post setPost(PostModel postModel){
        this.setId(postModel.getId());
        this.setPostDescription(postModel.getPostDescription());
        return this;
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
