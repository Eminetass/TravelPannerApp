package com.travelplanner.util;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GoogleMapsUtil {

    private final String API_KEY = "AIzaSyBRfaCz9jLbrBLE3EQD5DTo_x-X7PekJsE"; // .env'den alınmalı (→ daha sonra `@Value` ile dışarı alınabilir)

    public String searchPlaces(String city, String type) {
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format(
                "https://maps.googleapis.com/maps/api/place/textsearch/json?query=%s+%s&key=%s",
                city, type, API_KEY
        );
        return restTemplate.getForObject(url, String.class);
    }
}
