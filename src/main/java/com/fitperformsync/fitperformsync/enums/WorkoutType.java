package com.fitperformsync.fitperformsync.enums;

public enum WorkoutType {
    CARDIO("Cardio"),
    STRENGTH("Força"),
    FLEXIBILITY("Flexibilidade"),
    HIIT("Treino Intervalado de Alta Intensidade"),
    ENDURANCE("Resistência"),
    BALANCE("Equilíbrio");

    private String description;

    WorkoutType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
