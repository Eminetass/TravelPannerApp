package com.travelplanner.controller;

import com.travelplanner.model.Plan;
import com.travelplanner.service.PlanService;
import com.travelplanner.util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plans")
public class PlanController {

    @Autowired
    private PlanService planService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping
    public ResponseEntity<Plan> createPlan(@RequestBody Plan plan, HttpServletRequest request) {
        Long userId = jwtUtil.extractUserIdFromRequest(request);
        return ResponseEntity.ok(planService.createPlan(plan, userId));
    }

    @GetMapping
    public ResponseEntity<List<Plan>> getPlans(HttpServletRequest request) {
        Long userId = jwtUtil.extractUserIdFromRequest(request);
        return ResponseEntity.ok(planService.getPlansByUserId(userId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plan> updatePlan(@PathVariable Long id, @RequestBody Plan plan, HttpServletRequest request) {
        Long userId = jwtUtil.extractUserIdFromRequest(request);
        return ResponseEntity.ok(planService.updatePlan(id, plan, userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlan(@PathVariable Long id, HttpServletRequest request) {
        Long userId = jwtUtil.extractUserIdFromRequest(request);
        planService.deletePlan(id, userId);
        return ResponseEntity.noContent().build();
    }
}
