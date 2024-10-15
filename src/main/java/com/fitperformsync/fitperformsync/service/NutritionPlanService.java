package com.fitperformsync.fitperformsync.service;

import com.fitperformsync.fitperformsync.DTO.NutritionPlanDTO;

import java.util.List;
import java.util.Optional;

public interface NutritionPlanService {
    List<NutritionPlanDTO> getAllNutritionPlans();

    NutritionPlanDTO getNutritionPlanById(Long id);

    NutritionPlanDTO createNutritionPlan(NutritionPlanDTO nutritionPlanDTO);

    NutritionPlanDTO updateNutritionPlan(Long id, NutritionPlanDTO nutritionPlanDTO);

    Optional<Void> deleteNutritionPlan(Long id);
}
