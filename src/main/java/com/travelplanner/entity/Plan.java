package com.travelplanner.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "plans")
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;
    private LocalDate startDate;
    private LocalDate endDate;
    private String note;

    // Getters ve Setters
}
