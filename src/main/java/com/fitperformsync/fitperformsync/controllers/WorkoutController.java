package com.fitperformsync.fitperformsync.controllers;

import com.fitperformsync.fitperformsync.DTO.WorkoutDTO;
import com.fitperformsync.fitperformsync.exceptions.ResourceNotFoundException;
import com.fitperformsync.fitperformsync.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workouts")
public class WorkoutController {

    @Autowired
    private WorkoutService workoutService;

    @GetMapping
    public List<WorkoutDTO> getAllWorkouts() {
        return workoutService.getAllWorkouts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkoutDTO> getWorkoutById(@PathVariable Long id) {
        return ResponseEntity.ok(workoutService.getWorkoutById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Workout not found")));
    }

    @PostMapping
    public ResponseEntity<WorkoutDTO> createWorkout(@RequestBody WorkoutDTO workoutDTO) {
        return ResponseEntity.ok(workoutService.createWorkout(workoutDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkoutDTO> updateWorkout(@PathVariable Long id, @RequestBody WorkoutDTO workoutDTO) {
        return ResponseEntity.ok(workoutService.updateWorkout(id, workoutDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Workout not found")));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkout(@PathVariable Long id) {
        workoutService.deleteWorkout(id)
                .orElseThrow(() -> new ResourceNotFoundException("Workout not found"));
        return ResponseEntity.noContent().build();
    }
}
