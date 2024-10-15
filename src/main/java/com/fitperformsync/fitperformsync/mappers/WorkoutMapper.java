package com.fitperformsync.fitperformsync.mappers;

import com.fitperformsync.fitperformsync.DTO.WorkoutDTO;
import com.fitperformsync.fitperformsync.entity.Workout;
import org.springframework.stereotype.Component;

@Component
public class WorkoutMapper {

    public WorkoutDTO toDTO(Workout workout) {
        if (workout == null) {
            return null;
        }

        WorkoutDTO workoutDTO = new WorkoutDTO();
        workoutDTO.setId(workout.getId());
        workoutDTO.setWorkoutType(workout.getWorkoutType());
        workoutDTO.setDuration((int) workout.getDuration());
        workoutDTO.setCaloriesBurned((int) workout.getCaloriesBurned());

        return workoutDTO;
    }

    public Workout toEntity(WorkoutDTO workoutDTO) {
        if (workoutDTO == null) {
            return null;
        }

        Workout workout = new Workout();
        workout.setId(workoutDTO.getId());
        workout.setWorkoutType(workoutDTO.getWorkoutType());
        workout.setDuration(workoutDTO.getDuration());
        workout.setCaloriesBurned(workoutDTO.getCaloriesBurned());

        return workout;
    }
}