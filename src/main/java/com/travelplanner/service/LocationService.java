package com.travelplanner.service;

import com.travelplanner.dto.LocationDTO;
import com.travelplanner.model.Location;

import java.util.List;

public interface LocationService {
    LocationDTO createLocation(LocationDTO dto);
    LocationDTO getLocationById(Long id);
    List<Location> getAllLocations();
    LocationDTO updateLocation(Long id, LocationDTO dto);
    void deleteLocation(Long id);
}
