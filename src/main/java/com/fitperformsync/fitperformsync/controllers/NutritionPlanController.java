package com.fitperformsync.fitperformsync.controllers;

import com.fitperformsync.fitperformsync.DTO.NutritionPlanDTO;
import com.fitperformsync.fitperformsync.exceptions.ResourceNotFoundException;
import com.fitperformsync.fitperformsync.service.NutritionPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nutrition-plans")
public class NutritionPlanController {

    @Autowired
    private NutritionPlanService nutritionPlanService;

    @GetMapping
    public List<NutritionPlanDTO> getAllNutritionPlans() {
        return nutritionPlanService.getAllNutritionPlans();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NutritionPlanDTO> getNutritionPlanById(@PathVariable Long id) {
        return ResponseEntity.ok(nutritionPlanService.getNutritionPlanById(id));
    }

    @PostMapping
    public ResponseEntity<NutritionPlanDTO> createNutritionPlan(@RequestBody NutritionPlanDTO nutritionPlanDTO) {
        return ResponseEntity.ok(nutritionPlanService.createNutritionPlan(nutritionPlanDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NutritionPlanDTO> updateNutritionPlan(@PathVariable Long id, @RequestBody NutritionPlanDTO nutritionPlanDTO) {
        return ResponseEntity.ok(nutritionPlanService.updateNutritionPlan(id, nutritionPlanDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNutritionPlan(@PathVariable Long id) {
        nutritionPlanService.deleteNutritionPlan(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nutrition Plan not found"));
        return ResponseEntity.noContent().build();
    }
}