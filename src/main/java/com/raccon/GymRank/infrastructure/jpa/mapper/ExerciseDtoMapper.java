package com.raccon.GymRank.infrastructure.jpa.mapper;

import com.raccon.GymRank.domain.model.Exercise;
import com.raccon.GymRank.domain.model.ExerciseCategory;
import com.raccon.GymRank.domain.model.MuscleGroup;
import com.raccon.GymRank.domain.model.vo.ExerciseDescription;
import com.raccon.GymRank.domain.model.vo.ExerciseName;
import com.raccon.GymRank.infrastructure.jpa.ExerciseEntity;
import com.raccon.GymRank.infrastructure.web.dto.ExerciseDTO;

import java.util.UUID;

public class ExerciseDtoMapper {

    //domain (Exercise) -> DTO (ExerciseDTO)
    public static ExerciseDTO toDTO (Exercise model){
        return new ExerciseDTO(
                UUID.randomUUID(),
                model.name(),
                model.description(),
                model.group(),
                model.category(),
                model.getImage()
        );
    }

    //DTO (ExerciseDTO) -> domain (Exercise)
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
