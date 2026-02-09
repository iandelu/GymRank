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

    public ExerciseEntity(String image, String exerciseCategory, String muscleGroup, String description, String name) {
        this.image = image;
        this.exerciseCategory = exerciseCategory;
        this.muscleGroup = muscleGroup;
        this.description = description;
        this.name = name;
    }
}





