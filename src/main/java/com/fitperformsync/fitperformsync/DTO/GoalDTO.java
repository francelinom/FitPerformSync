package com.fitperformsync.fitperformsync.DTO;

import com.fitperformsync.fitperformsync.enums.GoalType;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

@Data
public class GoalDTO {
    private Long id;

    @NotNull
    private GoalType goalType;

    @NotNull
    private String description;

    @NotNull
    private LocalDate targetDate;

    private Long userId; // ID do usuário ao qual o objetivo está associado

}
