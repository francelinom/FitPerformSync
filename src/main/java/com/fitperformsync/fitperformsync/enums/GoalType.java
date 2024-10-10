package com.fitperformsync.fitperformsync.enums;

public enum GoalType {
    WEIGHT_LOSS("Perda de Peso"),
    MUSCLE_GAIN("Ganho Muscular"),
    MAINTENANCE("Manutenção"),
    PERFORMANCE("Performance"),
    HEALTH("Saúde");

    private String description;

    GoalType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
