package com.raccon.GymRank.excercises.application.useCases;

import com.raccon.GymRank.excercises.application.dto.ExerciseDTO;

import java.util.UUID;

public interface FetchExerciseUseCase {

    ExerciseDTO fetchExerciseById(UUID id);
}
