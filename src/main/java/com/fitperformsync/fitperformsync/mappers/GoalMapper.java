package com.fitperformsync.fitperformsync.mappers;

import com.fitperformsync.fitperformsync.DTO.GoalDTO;
import com.fitperformsync.fitperformsync.entity.Goal;
import org.springframework.stereotype.Component;

@Component
public class GoalMapper {

    public GoalDTO toDTO(Goal goal) {
        if (goal == null) {
            return null;
        }

        GoalDTO goalDTO = new GoalDTO();
        goalDTO.setId(goal.getId());
        goalDTO.setGoalType(goal.getGoalType());
        goalDTO.setDescription(goal.getGoalType().getDescription());
        goalDTO.setTargetDate(goal.getStartDate());

        return goalDTO;
    }

    public Goal toEntity(GoalDTO goalDTO) {
        if (goalDTO == null) {
            return null;
        }

        Goal goal = new Goal();
        goal.setId(goalDTO.getId());
        goal.setGoalType(goalDTO.getGoalType());
        goal.setStartDate(goalDTO.getTargetDate());

        return goal;
    }
}
