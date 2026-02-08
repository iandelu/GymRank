package com.raccon.GymRank.application.service;

import com.raccon.GymRank.application.useCases.FetchExercise;
import com.raccon.GymRank.infrastructure.web.dto.ExerciseDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ExerciseService implements FetchExercise {

    @Override
    public ExerciseDTO fetchExerciseById(UUID id) {
        return ExerciseDTO.emptyExercise();
    }

}
