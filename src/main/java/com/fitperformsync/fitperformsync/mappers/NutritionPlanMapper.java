package com.fitperformsync.fitperformsync.mappers;

import com.fitperformsync.fitperformsync.DTO.NutritionPlanDTO;
import com.fitperformsync.fitperformsync.entity.NutritionPlan;
import org.springframework.stereotype.Component;

@Component
public class NutritionPlanMapper {

    public NutritionPlanDTO toDTO(NutritionPlan nutritionPlan) {
        if (nutritionPlan == null) {
            return null;
        }

        NutritionPlanDTO nutritionPlanDTO = new NutritionPlanDTO();
        nutritionPlanDTO.setId(nutritionPlan.getId());
        nutritionPlanDTO.setDailyCalories((int) nutritionPlan.getCaloriesPerDay());
        nutritionPlanDTO.setFats((int) nutritionPlan.getFats());
        nutritionPlanDTO.setProteins((int) nutritionPlan.getProteins());

        return nutritionPlanDTO;
    }

    public NutritionPlan toEntity(NutritionPlanDTO nutritionPlanDTO) {
        if (nutritionPlanDTO == null) {
            return null;
        }

        NutritionPlan nutritionPlan = new NutritionPlan();
        nutritionPlan.setId(nutritionPlanDTO.getId());
        nutritionPlan.setCaloriesPerDay(nutritionPlanDTO.getDailyCalories());
        nutritionPlan.setFats(nutritionPlanDTO.getFats());
        nutritionPlan.setProteins(nutritionPlanDTO.getProteins());

        return nutritionPlan;
    }
}