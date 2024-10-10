package com.fitperformsync.fitperformsync.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class NutritionPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double caloriesPerDay;

    private double carbs;

    private double proteins;

    private double fats;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
