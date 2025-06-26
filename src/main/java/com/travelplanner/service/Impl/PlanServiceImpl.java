package com.travelplanner.service.Impl;

import com.travelplanner.dto.PlanDTO;
import com.travelplanner.model.Plan;
import com.travelplanner.repository.PlanRepository;
import com.travelplanner.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanRepository planRepository;

    private PlanDTO mapToDTO(Plan plan) {
        PlanDTO dto = new PlanDTO();
        dto.setId(plan.getId());
        dto.setCity(plan.getCity());
        dto.setStartDate(plan.getStartDate());
        dto.setEndDate(plan.getEndDate());
        dto.setNote(plan.getNote());
        return dto;
    }

    private Plan mapToEntity(PlanDTO dto) {
        Plan plan = new Plan();
        plan.setCity(dto.getCity());
        plan.setStartDate(dto.getStartDate());
        plan.setEndDate(dto.getEndDate());
        plan.setNote(dto.getNote());
        return plan;
    }

    @Override
    public PlanDTO createPlan(PlanDTO planDTO) {
        Plan saved = planRepository.save(mapToEntity(planDTO));
        return mapToDTO(saved);
    }

    @Override
    public List<PlanDTO> getAllPlans() {
        return planRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PlanDTO getPlanById(Long id) {
        return planRepository.findById(id)
                .map(this::mapToDTO)
                .orElse(null);
    }

    @Override
    public PlanDTO updatePlan(Long id, PlanDTO planDTO) {
        return planRepository.findById(id).map(plan -> {
            plan.setCity(planDTO.getCity());
            plan.setStartDate(planDTO.getStartDate());
            plan.setEndDate(planDTO.getEndDate());
            plan.setNote(planDTO.getNote());
            return mapToDTO(planRepository.save(plan));
        }).orElse(null);
    }

    @Override
    public void deletePlan(Long id) {
        planRepository.deleteById(id);
    }
}
