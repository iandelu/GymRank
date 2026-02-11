package com.raccon.GymRank.infrastructure.jpa;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Entity
@NoArgsConstructor
@Getter
public class ExerciseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;
    private String description;
    private String muscleGroup;
    private String exerciseCategory;
    private String image;

    public ExerciseEntity(String name, String description, String muscleGroup, String exerciseCategory, String image ) {
        this.name = name;
        this.description = description;
        this.muscleGroup = muscleGroup;
        this.exerciseCategory = exerciseCategory;
        this.image = image;
    }
}





