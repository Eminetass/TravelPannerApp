package com.travelplanner.controller;

import com.travelplanner.service.GoogleMapsService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/maps")
public class GoogleMapsController {

    private final GoogleMapsService googleMapsService;

    public GoogleMapsController(GoogleMapsService googleMapsService) {
        this.googleMapsService = googleMapsService;
    }

    @GetMapping("/search")
    public Map searchPlaces(@RequestParam String query) {
        return googleMapsService.searchPlaces(query);
    }
}