package com.raccon.GymRank.application.service;

import com.raccon.GymRank.application.useCases.FetchExercise;
import com.raccon.GymRank.domain.exception.ResourceNotFoundException;
import com.raccon.GymRank.infrastructure.web.dto.ExerciseDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ExerciseService implements FetchExercise {

    @Override
    public ExerciseDTO fetchExerciseById(UUID id) {
        if (id.equals(UUID.fromString("ee750fa6-f006-46d9-b276-e35674ca1c71"))) throw new ResourceNotFoundException("No such exercise in database for id : " + id);
        return ExerciseDTO.emptyExercise();
    }

}
