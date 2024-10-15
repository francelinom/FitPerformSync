package com.fitperformsync.fitperformsync.service.impl;

import com.fitperformsync.fitperformsync.DTO.NutritionPlanDTO;
import com.fitperformsync.fitperformsync.entity.NutritionPlan;
import com.fitperformsync.fitperformsync.mappers.NutritionPlanMapper;
import com.fitperformsync.fitperformsync.repository.NutritionPlanRepository;
import com.fitperformsync.fitperformsync.service.NutritionPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NutritionPlanServiceImpl implements NutritionPlanService {

    @Autowired
    private NutritionPlanRepository nutritionPlanRepository;

    @Autowired
    private NutritionPlanMapper nutritionPlanMapper;

    @Override
    public List<NutritionPlanDTO> getAllNutritionPlans() {
        return nutritionPlanRepository.findAll().stream()
                .map(nutritionPlanMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public NutritionPlanDTO createNutritionPlan(NutritionPlanDTO nutritionPlanDTO) {
        NutritionPlan nutritionPlan = nutritionPlanMapper.toEntity(nutritionPlanDTO);
        NutritionPlan savedNutritionPlan = nutritionPlanRepository.save(nutritionPlan);
        return nutritionPlanMapper.toDTO(savedNutritionPlan);
    }

    @Override
    public NutritionPlanDTO updateNutritionPlan(Long id, NutritionPlanDTO nutritionPlanDTO) {
        return nutritionPlanRepository.findById(id).map(nutritionPlan -> {
            nutritionPlan.setProteins(nutritionPlanDTO.getProteins());
            nutritionPlan.setFats(nutritionPlanDTO.getFats());
            NutritionPlan updatedNutritionPlan = nutritionPlanRepository.save(nutritionPlan);
            return nutritionPlanMapper.toDTO(updatedNutritionPlan);
        }).orElse(null);
    }

    @Override
    public Optional<Void> deleteNutritionPlan(Long id) {
        nutritionPlanRepository.deleteById(id);
        return Optional.empty();
    }

    @Override
    public NutritionPlanDTO getNutritionPlanById(Long id) {
        return nutritionPlanRepository.findById(id).map(nutritionPlanMapper::toDTO).orElse(null);
    }
}