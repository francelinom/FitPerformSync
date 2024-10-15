package com.fitperformsync.fitperformsync.service;

import com.fitperformsync.fitperformsync.DTO.WorkoutDTO;

import java.util.List;
import java.util.Optional;

public interface WorkoutService {

    List<WorkoutDTO> getAllWorkouts();

    Optional<WorkoutDTO> getWorkoutById(Long id);

    WorkoutDTO createWorkout(WorkoutDTO workoutDTO);

    Optional<WorkoutDTO> updateWorkout(Long id, WorkoutDTO workoutDTO);

    Optional<Void> deleteWorkout(Long id);
}
