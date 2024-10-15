package com.fitperformsync.fitperformsync.DTO;

import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
public class NutritionPlanDTO {
    private Long id;

    @NotNull
    private Integer dailyCalories;

    @NotNull
    private Integer carbohydrates; // Quantidade de carboidratos em gramas

    @NotNull
    private Integer proteins; // Quantidade de proteínas em gramas

    @NotNull
    private Integer fats; // Quantidade de gorduras em gramas

    private Long userId; // ID do usuário associado ao plano de nutrição
}
