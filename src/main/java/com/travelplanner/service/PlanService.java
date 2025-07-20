package com.travelplanner.service;

import com.travelplanner.model.Plan;

import java.util.List;

public interface PlanService {
    Plan createPlan(Plan plan, Long userId);
    List<Plan> getPlansByUserId(Long userId);
    Plan savePlan(Plan plan);
    Plan updatePlan(Long id, Plan updatedPlan, Long userId);
    void deletePlan(Long id, Long userId);
}
