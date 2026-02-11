package com.raccon.GymRank.infrastructure.jpa.mapper;

import com.raccon.GymRank.domain.model.Exercise;
import com.raccon.GymRank.domain.model.ExerciseCategory;
import com.raccon.GymRank.domain.model.MuscleGroup;
import com.raccon.GymRank.domain.model.vo.ExerciseDescription;
import com.raccon.GymRank.domain.model.vo.ExerciseName;
import com.raccon.GymRank.infrastructure.jpa.ExerciseEntity;

public class ExerciseMapper {

    //domain (Exercise) -> entity (ExerciseEntity)
    public static ExerciseEntity toEntity (Exercise model){
        return new ExerciseEntity(
                model.name(),
                model.description(),
                model.group(),
                model.category(),
                model.getImage()
        );
    }

    //entity (ExerciseEntity) -> domain (Exercise)
    public static Exercise toModel (ExerciseEntity entity){
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
