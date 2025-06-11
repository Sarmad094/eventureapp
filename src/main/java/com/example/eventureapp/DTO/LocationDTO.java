package com.example.eventureapp.DTO;

public class LocationDTO {
    private Integer locationId;
    private String locationName;

    // Constructors
    public LocationDTO() {}

    public LocationDTO(Integer locationId, String locationName) {
        this.locationId = locationId;
        this.locationName = locationName;
    }

    // Getters and Setters
    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}