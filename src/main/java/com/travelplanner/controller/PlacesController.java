package com.travelplanner.controller;

import com.travelplanner.service.PlacesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/places")
public class PlacesController {

    @Autowired
    private PlacesService placesService;

    @GetMapping
    public ResponseEntity<List<String>> getPlaces(
            @RequestParam String city,
            @RequestParam(defaultValue = "tourist attractions") String type
    ) {
        List<String> places = placesService.getPlaces(city, type);
        return ResponseEntity.ok(places);
    }
}

