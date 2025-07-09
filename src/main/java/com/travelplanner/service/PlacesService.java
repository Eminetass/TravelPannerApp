package com.travelplanner.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlacesService {

    @Value("${google.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public List<String> getPlaces(String city, String type) {
        List<String> results = new ArrayList<>();

        String url = UriComponentsBuilder.fromHttpUrl("https://maps.googleapis.com/maps/api/place/textsearch/json")
                .queryParam("query", type + " in " + city)
                .queryParam("key", apiKey)
                .build()
                .toUriString();

        String response = restTemplate.getForObject(url, String.class);
        JSONObject json = new JSONObject(response);
        JSONArray places = json.getJSONArray("results");

        for (int i = 0; i < Math.min(places.length(), 10); i++) {
            JSONObject place = places.getJSONObject(i);
            results.add(place.getString("name"));
        }

        return results;
    }
}
