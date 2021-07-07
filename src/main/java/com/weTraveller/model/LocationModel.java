package com.weTraveller.model;


import com.weTraveller.entity.Location;

public class LocationModel {

    private long id;
    private String locationName;
    private String locationId;

    public LocationModel(){

    }

    public LocationModel(Location entity){
        this.setId(entity.getId());
        this.setLocationId(entity.getLocationId());
        this.setLocationName(entity.getLocationName());
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
