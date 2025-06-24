package com.travelplanner.controller;

import com.travelplanner.dto.PlanDTO;
import com.travelplanner.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plans")
public class PlanController {

    @Autowired
    private PlanService planService;

    @PostMapping
    public PlanDTO createPlan(@RequestBody PlanDTO planDTO) {
        return planService.createPlan(planDTO);
    }

    @GetMapping
    public List<PlanDTO> getAllPlans() {
        return planService.getAllPlans();
    }

    @GetMapping("/{id}")
    public PlanDTO getPlanById(@PathVariable Long id) {
        return planService.getPlanById(id);
    }

    @PutMapping("/{id}")
    public PlanDTO updatePlan(@PathVariable Long id, @RequestBody PlanDTO planDTO) {
        return planService.updatePlan(id, planDTO);
    }

    @DeleteMapping("/{id}")
    public void deletePlan(@PathVariable Long id) {
        planService.deletePlan(id);
    }
}
