package com.travelplanner.controller;

import com.travelplanner.dto.LocationDTO;
import com.travelplanner.model.Location;
import com.travelplanner.service.LocationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public List<Location> getAll() {
        return locationService.getAllLocations();
    }

    @GetMapping("/{id}")
    public LocationDTO getById(@PathVariable Long id) {
        return locationService.getLocationById(id); // Eğer zaten throw ediyorsa, orElseThrow gerekmez.
    }

    @PostMapping
    public LocationDTO create(@RequestBody LocationDTO locationDTO) {
        return locationService.createLocation(locationDTO);
    }

    @PutMapping("/{id}")
    public LocationDTO update(@PathVariable Long id, @RequestBody LocationDTO dto) {
        return locationService.updateLocation(id, dto);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        locationService.deleteLocation(id);
    }
}
