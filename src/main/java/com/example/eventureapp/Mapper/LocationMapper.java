package com.example.eventureapp.Mapper;

import com.example.eventureapp.DTO.LocationDTO;
import com.example.eventureapp.Model.Location;

public class LocationMapper {

    public static LocationDTO toDTO(Location location) {
        LocationDTO dto = new LocationDTO();
        dto.setLocationId(location.getLocationId());
        dto.setLocationName(location.getLocationName());
        return dto;
    }

    public static Location toEntity(LocationDTO dto) {
        Location location = new Location();
        location.setLocationId(dto.getLocationId());
        location.setLocationName(dto.getLocationName());
        return location;
    }
}