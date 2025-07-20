package com.travelplanner.service.impl;

import com.travelplanner.model.Plan;
import com.travelplanner.model.User;
import com.travelplanner.repository.PlanRepository;
import com.travelplanner.repository.UserRepository;
import com.travelplanner.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Plan createPlan(Plan plan, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        plan.setUser(user);
        return planRepository.save(plan);
    }

    @Override
    public List<Plan> getPlansByUserId(Long userId) {
        return planRepository.findByUserId(userId);
    }

    @Override
     public Plan savePlan(Plan plan) {
        return planRepository.save(plan);
    }

    @Override
    public Plan updatePlan(Long id, Plan updatedPlan, Long userId) {
        Plan existingPlan = planRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plan not found"));

        if (!existingPlan.getUser().getId().equals(userId)) {
            throw new RuntimeException("You are not authorized to update this plan.");
        }

        existingPlan.setCity(updatedPlan.getCity());
        existingPlan.setStartDate(updatedPlan.getStartDate());
        existingPlan.setEndDate(updatedPlan.getEndDate());
        return planRepository.save(existingPlan);
    }

    @Override
    public void deletePlan(Long id, Long userId) {
        Plan existingPlan = planRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plan not found"));

        if (!existingPlan.getUser().getId().equals(userId)) {
            throw new RuntimeException("You are not authorized to delete this plan.");
        }

        planRepository.delete(existingPlan);
    }
}
