package com.fitperformsync.fitperformsync.controllers;

import com.fitperformsync.fitperformsync.DTO.GoalDTO;
import com.fitperformsync.fitperformsync.exceptions.ResourceNotFoundException;
import com.fitperformsync.fitperformsync.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/goals")
public class GoalController {

    @Autowired
    private GoalService goalService;

    @GetMapping
    public List<GoalDTO> getAllGoals() {
        return goalService.getAllGoals();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GoalDTO> getGoalById(@PathVariable Long id) {
        return ResponseEntity.ok(goalService.getGoalById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Goal not found")));
    }

    @PostMapping
    public ResponseEntity<GoalDTO> createGoal(@RequestBody GoalDTO goalDTO) {
        return ResponseEntity.ok(goalService.createGoal(goalDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GoalDTO> updateGoal(@PathVariable Long id, @RequestBody GoalDTO goalDTO) {
        return ResponseEntity.ok(goalService.updateGoal(id, goalDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Goal not found")));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGoal(@PathVariable Long id) {
        goalService.deleteGoal(id)
                .orElseThrow(() -> new ResourceNotFoundException("Goal not found"));
        return ResponseEntity.noContent().build();
    }
}