// Bu dosya: com.travelplanner.service.impl.LocationServiceImpl.java
package com.travelplanner.service.Impl;

import com.travelplanner.dto.LocationDTO;
import com.travelplanner.model.Location;
import com.travelplanner.model.Plan;
import com.travelplanner.repository.LocationRepository;
import com.travelplanner.repository.PlanRepository;
import com.travelplanner.service.LocationService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;
    private final PlanRepository planRepository;

    public LocationServiceImpl(LocationRepository locationRepository, PlanRepository planRepository) {
        this.locationRepository = locationRepository;
        this.planRepository = planRepository;
    }

    @Override
    public LocationDTO createLocation(LocationDTO dto) {
        Location location = new Location();
        location.setName(dto.getName());
        location.setType(dto.getType());
        location.setCity(dto.getCity());
        location.setAddress(dto.getAddress());
        location.setLatitude(dto.getLatitude());
        location.setLongitude(dto.getLongitude());

        Optional<Plan> planOpt = planRepository.findById(dto.getPlanId());
        planOpt.ifPresent(location::setPlan);

        Location saved = locationRepository.save(location);
        dto.setId(saved.getId());
        return dto;
    }

    @Override
    public LocationDTO getLocationById(Long id) {
        Location location = locationRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Not found"));
        return convertToDTO(location);
    }

    @Override
    public List getAllLocations() {
        return locationRepository.findAll()
            .stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }

    @Override
    public LocationDTO updateLocation(Long id, LocationDTO dto) {
        Location location = locationRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Not found"));

        location.setName(dto.getName());
        location.setType(dto.getType());
        location.setCity(dto.getCity());
        location.setAddress(dto.getAddress());
        location.setLatitude(dto.getLatitude());
        location.setLongitude(dto.getLongitude());

        Location updated = locationRepository.save(location);
        return convertToDTO(updated);
    }

    @Override
    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }

    private LocationDTO convertToDTO(Location location) {
        LocationDTO dto = new LocationDTO();
        dto.setId(location.getId());
        dto.setName(location.getName());
        dto.setType(location.getType());
        dto.setCity(location.getCity());
        dto.setAddress(location.getAddress());
        dto.setLatitude(location.getLatitude());
        dto.setLongitude(location.getLongitude());
        if (location.getPlan() != null) {
            dto.setPlanId(location.getPlan().getId());
        }
        return dto;
    }
}
