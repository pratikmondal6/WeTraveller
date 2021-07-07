package com.weTraveller.entity;



import com.weTraveller.entity.common.CommonColumn;
import com.weTraveller.model.PostModel;

import javax.persistence.*;

@Entity
@Table(name = "post" )
public class Post extends CommonColumn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "post_description", length = 500)
    private String postDescription;

    @Column(name = "privacy_id", length = 10)
    private String privacyId;

    @Column(name = "location_id", length = 10)
    private String locationId;




    public Post(){

    }

    public Post setPost(PostModel postModel){
        this.setId(postModel.getId());
        this.setPostDescription(postModel.getPostDescription());
        this.setPrivacyId(postModel.getPrivacyId());
        this.setLocationId(postModel.getLocationId());
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
