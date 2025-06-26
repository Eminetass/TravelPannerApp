package com.travelplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travelplanner.model.Plan;

public interface PlanRepository extends JpaRepository<Plan, Long> {
}
