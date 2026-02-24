package com.raccon.GymRank.excercises.application.useCases;

import com.raccon.GymRank.excercises.infrastructure.web.dto.ExerciseDTO;

import java.util.UUID;

public interface SaveExerciseUseCase {
    UUID saveExercise (ExerciseDTO dto);
}
