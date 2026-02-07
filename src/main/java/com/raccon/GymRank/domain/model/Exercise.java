package com.raccon.GymRank.domain.model;

import com.raccon.GymRank.domain.model.vo.ExerciseDescription;
import com.raccon.GymRank.domain.model.vo.ExerciseName;

public record Exercise(
        ExerciseName name,
        ExerciseDescription description,
        String image,
        MuscleGroup group,
        ExerciseCategory category
) {
}

