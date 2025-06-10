// Testet og implementert i stil med Sahil
package com.example.eventureapp.Service;

import com.example.eventureapp.Model.Location;
import com.example.eventureapp.Repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    private final LocationRepository locationRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> hentAlleLocations() {
        return (List<Location>) locationRepository.findAll();
    }

    public Optional<Location> hentLocationVedId(int id) {
        return locationRepository.findById(id);
    }

    public Location lagNyLocation(Location location) {
        return locationRepository.save(location);
    }

    public boolean oppdaterLocation(Location location) {
        if (locationRepository.existsById(location.getLocationId())) {
            locationRepository.save(location);
            return true;
        }
        return false;
    }

    public boolean slettLocation(int id) {
        if (locationRepository.existsById(id)) {
            locationRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
