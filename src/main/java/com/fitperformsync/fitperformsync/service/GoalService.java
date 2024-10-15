package com.fitperformsync.fitperformsync.service;

import com.fitperformsync.fitperformsync.DTO.GoalDTO;

import java.util.List;
import java.util.Optional;

public interface GoalService {

    List<GoalDTO> getAllGoals();

    Optional<GoalDTO> getGoalById(Long id);

    GoalDTO createGoal(GoalDTO goalDTO);

    Optional<GoalDTO> updateGoal(Long id, GoalDTO goalDTO);

    Optional<Void> deleteGoal(Long id);
}