package com.fitperformsync.fitperformsync.DTO;

import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
public class AdjustmentDTO {
    @NotNull
    private Long workoutId;

    @NotNull
    private Long nutritionPlanId;

    @NotNull
    private Double performanceScore; // Pontuação de desempenho do usuário
}
