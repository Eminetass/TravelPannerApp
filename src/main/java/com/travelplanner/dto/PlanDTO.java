package com.travelplanner.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanDTO {
    private Long id;
    private String city;
    private LocalDate startDate;
    private LocalDate endDate;
    private String note;

    // Getters ve Setters
}