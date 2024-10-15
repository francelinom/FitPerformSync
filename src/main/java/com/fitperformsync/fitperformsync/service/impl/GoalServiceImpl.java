package com.fitperformsync.fitperformsync.service.impl;

import com.fitperformsync.fitperformsync.DTO.GoalDTO;
import com.fitperformsync.fitperformsync.entity.Goal;
import com.fitperformsync.fitperformsync.mappers.GoalMapper;
import com.fitperformsync.fitperformsync.repository.GoalRepository;
import com.fitperformsync.fitperformsync.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GoalServiceImpl implements GoalService {

    @Autowired
    private GoalRepository goalRepository;

    @Autowired
    private GoalMapper goalMapper;

    @Override
    public List<GoalDTO> getAllGoals() {
        return goalRepository.findAll().stream()
                .map(goalMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<GoalDTO> getGoalById(Long id) {
        return goalRepository.findById(id).map(goalMapper::toDTO);
    }

    @Override
    public GoalDTO createGoal(GoalDTO goalDTO) {
        Goal goal = goalMapper.toEntity(goalDTO);
        Goal savedGoal = goalRepository.save(goal);
        return goalMapper.toDTO(savedGoal);
    }

    @Override
    public Optional<GoalDTO> updateGoal(Long id, GoalDTO goalDTO) {
        return goalRepository.findById(id).map(goal -> {
            goal.setGoalType(goalDTO.getGoalType());
//            goal.setTargetDate(goalDTO.getTargetDate());
//            goal.setTargetValue(goalDTO.getTargetValue());
            Goal updatedGoal = goalRepository.save(goal);
            return goalMapper.toDTO(updatedGoal);
        });
    }

    @Override
    public Optional<Void> deleteGoal(Long id) {
        return goalRepository.findById(id).map(goal -> {
            goalRepository.delete(goal);
            return null;
        });
    }
}
