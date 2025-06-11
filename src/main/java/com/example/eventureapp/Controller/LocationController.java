package com.example.eventureapp.Controller;

import com.example.eventureapp.DTO.LocationDTO;
import com.example.eventureapp.Mapper.LocationMapper;
import com.example.eventureapp.Model.Location;
import com.example.eventureapp.Service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/locations")
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public List<LocationDTO> hentAlle() {
        return locationService.hentAlleLocations().stream()
                .map(LocationMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public LocationDTO hentEn(@PathVariable int id) {
        Optional<Location> location = locationService.hentLocationVedId(id);
        return location.map(LocationMapper::toDTO).orElse(null);
    }

    @PostMapping
    public int lagLocation(@RequestBody LocationDTO dto) {
        Location location = LocationMapper.toEntity(dto);
        return locationService.lagNyLocation(location).getLocationId();
    }

    @PutMapping("/{id}")
    public boolean oppdater(@PathVariable int id, @RequestBody LocationDTO dto) {
        dto.setLocationId(id);
        Location location = LocationMapper.toEntity(dto);
        return locationService.oppdaterLocation(location);
    }

    @DeleteMapping("/{id}")
    public boolean slett(@PathVariable int id) {
        return locationService.slettLocation(id);
    }
}
