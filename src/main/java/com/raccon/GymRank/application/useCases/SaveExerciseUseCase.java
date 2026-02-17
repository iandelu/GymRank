package com.raccon.GymRank.application.useCases;

import com.raccon.GymRank.infrastructure.web.dto.ExerciseDTO;

import java.util.UUID;

public interface SaveExerciseUseCase {
    UUID saveExercise (ExerciseDTO dto);
}
