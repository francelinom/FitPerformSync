package com.fitperformsync.fitperformsync.DTO;

import com.fitperformsync.fitperformsync.enums.WorkoutType;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
public class WorkoutDTO {
    private Long id;

    @NotNull
    private WorkoutType workoutType;

    @NotNull
    private Integer duration; // Duração em minutos

    @NotNull
    private Integer caloriesBurned; // Calorias queimadas no treino

    private Long userId; // ID do usuário
}
