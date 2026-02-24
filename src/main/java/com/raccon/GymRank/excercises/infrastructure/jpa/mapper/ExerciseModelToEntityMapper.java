package com.raccon.GymRank.excercises.infrastructure.jpa.mapper;

import com.raccon.GymRank.excercises.domain.model.Exercise;
import com.raccon.GymRank.excercises.infrastructure.jpa.ExerciseEntity;

public class ExerciseModelToEntityMapper {

    public static ExerciseEntity toEntity(Exercise model) {
        return new ExerciseEntity(
                model.name(),
                model.description(),
                model.group(),
                model.category(),
                model.image()
        );
    }

    public static Exercise toModel(ExerciseEntity entity) {
        return new Exercise(
                entity.getName(),
                entity.getDescription(),
                entity.getMuscleGroup(),
                entity.getExerciseCategory(),
                entity.getImage()
        );
    }
}
