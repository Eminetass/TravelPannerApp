package com.travelplanner; 

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication 
@EnableCaching 
public class TravelPlannerApp {

    public static void main(String[] args) {
        SpringApplication.run(TravelPlannerApp.class, args);
    }

}
