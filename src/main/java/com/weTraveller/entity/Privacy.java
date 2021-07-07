package com.weTraveller.entity;



import com.weTraveller.entity.common.CommonColumn;

import javax.persistence.*;

@Entity
@Table(name = "privacy" )
public class Privacy extends CommonColumn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "privacy_id", length = 50)
    private String privacyId;

    @Column(name = "privacy_name", length = 150)
    private String privacyName;


    public  Privacy(){

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
