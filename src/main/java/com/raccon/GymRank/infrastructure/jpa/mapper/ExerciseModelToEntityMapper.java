package com.raccon.GymRank.infrastructure.jpa.mapper;

import com.raccon.GymRank.domain.model.Exercise;
import com.raccon.GymRank.infrastructure.jpa.ExerciseEntity;

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
           new ExerciseName(entity.getName()),
           new ExerciseDescription(entity.getDescription()),
           entity.getImage(),
           MuscleGroup.valueOf(entity.getMuscleGroup().toUpperCase()),
           ExerciseCategory.valueOf(entity.getExerciseCategory().toUpperCase())

                //no se esta mal porque creo que la clase Exercise está mal
        );
    }

}
