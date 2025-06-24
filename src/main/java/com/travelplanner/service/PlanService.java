package com.travelplanner.service;

import com.travelplanner.dto.PlanDTO;
import java.util.List;

public interface PlanService {
    default PlanDTO createPlan() {
        return createPlan(null);
    }

    PlanDTO createPlan(PlanDTO planDTO);
    List<PlanDTO> getAllPlans();
    PlanDTO getPlanById(Long id);
    PlanDTO updatePlan(Long id, PlanDTO planDTO);
    void deletePlan(Long id);
}

