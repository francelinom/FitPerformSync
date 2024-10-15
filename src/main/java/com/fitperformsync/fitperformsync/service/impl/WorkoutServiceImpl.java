package com.fitperformsync.fitperformsync.service.impl;

import com.fitperformsync.fitperformsync.DTO.WorkoutDTO;
import com.fitperformsync.fitperformsync.entity.Workout;
import com.fitperformsync.fitperformsync.mappers.WorkoutMapper;
import com.fitperformsync.fitperformsync.repository.WorkoutRepository;
import com.fitperformsync.fitperformsync.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WorkoutServiceImpl implements WorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;

    @Autowired
    private WorkoutMapper workoutMapper;

    @Override
    public List<WorkoutDTO> getAllWorkouts() {
        return workoutRepository.findAll().stream()
                .map(workoutMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<WorkoutDTO> getWorkoutById(Long id) {
        return workoutRepository.findById(id).map(workoutMapper::toDTO);
    }

    @Override
    public WorkoutDTO createWorkout(WorkoutDTO workoutDTO) {
        Workout workout = workoutMapper.toEntity(workoutDTO);
        Workout savedWorkout = workoutRepository.save(workout);
        return workoutMapper.toDTO(savedWorkout);
    }

    @Override
    public Optional<WorkoutDTO> updateWorkout(Long id, WorkoutDTO workoutDTO) {
        return workoutRepository.findById(id).map(workout -> {
            workout.setWorkoutType(workoutDTO.getWorkoutType());
            workout.setDuration(workoutDTO.getDuration());
            workout.setCaloriesBurned(workoutDTO.getCaloriesBurned());
            Workout updatedWorkout = workoutRepository.save(workout);
            return workoutMapper.toDTO(updatedWorkout);
        });
    }

    @Override
    public Optional<Void> deleteWorkout(Long id) {
        return workoutRepository.findById(id).map(workout -> {
            workoutRepository.delete(workout);
            return null;
        });
    }
}
