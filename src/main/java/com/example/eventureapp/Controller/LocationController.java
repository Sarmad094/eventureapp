// Testet og implementert i stil med Sahil
package com.example.eventureapp.Controller;

import com.example.eventureapp.Model.Location;
import com.example.eventureapp.Service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/locations")
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public List<Location> hentAlle() {
        return locationService.hentAlleLocations();
    }

    @GetMapping("/{id}")
    public Location hentEn(@PathVariable int id) {
        Optional<Location> location = locationService.hentLocationVedId(id);
        return location.orElse(null);
    }

    @PostMapping
    public int lagLocation(@RequestBody Location location) {
        return locationService.lagNyLocation(location).getLocationId();
    }

    @PutMapping("/{id}")
    public boolean oppdater(@PathVariable int id, @RequestBody Location location) {
        location.setLocationId(id);
        return locationService.oppdaterLocation(location);
    }

    @DeleteMapping("/{id}")
    public boolean slett(@PathVariable int id) {
        return locationService.slettLocation(id);
    }
}
