package com.weTraveller.entity;



import com.weTraveller.entity.common.CommonColumn;
import com.weTraveller.model.LocationModel;

import javax.persistence.*;

@Entity
@Table(name = "location" )
public class Location extends CommonColumn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "location_id", length = 50)
    private String locationId;

    @Column(name = "location_name", length = 250)
    private String locationName;



    public Location(){

    }

    public Location setLocation(LocationModel model){
        this.setId(model.getId());
        this.setLocationId(model.getLocationId());
        this.setLocationName(model.getLocationName());
        return this;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }
}
