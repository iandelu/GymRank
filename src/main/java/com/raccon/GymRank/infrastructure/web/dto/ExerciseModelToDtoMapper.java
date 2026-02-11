package com.raccon.GymRank.infrastructure.web.dto;

import com.raccon.GymRank.domain.model.Exercise;

public class ExerciseModelToDtoMapper {

    public static ExerciseDTO toDTO (Exercise model){
        return new ExerciseDTO(
                model.name(),
                model.description(),
                model.group(),
                model.category(),
                model.image()
        );
    }

    public static Exercise toModel (ExerciseDTO dto){
        return new Exercise(
                dto.name(),
                dto.description(),
                dto.muscleGroup(),
                dto.exerciseCategory(),
                dto.image()
        );
    }

}
