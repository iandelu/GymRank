package com.raccon.GymRank.application.service;

import com.raccon.GymRank.application.useCases.FetchExercise;
import com.raccon.GymRank.domain.exception.ResourceNotFoundException;
import com.raccon.GymRank.domain.model.Exercise;
import com.raccon.GymRank.domain.repository.ExerciseRepository;
import com.raccon.GymRank.infrastructure.web.dto.ExerciseDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ExerciseService implements FetchExercise {

    private final ExerciseRepository repo;

    public ExerciseService(ExerciseRepository repo) {
        this.repo = repo;
    }


    @Override
    public ExerciseDTO fetchExerciseById(UUID id) {

        Optional<Exercise> exercise = repo.findById(id);

        if (exercise.isEmpty()) throw new ResourceNotFoundException("No such exercise in database for id : " + id);
        return ExerciseDTO.emptyExercise();
    }

}
