package com.raccon.GymRank.exercises.application;

import com.raccon.GymRank.exercises.application.dto.ExerciseDTO;
import com.raccon.GymRank.exercises.application.dto.ExerciseModelToDtoMapper;
import com.raccon.GymRank.exercises.domain.exception.ResourceNotFoundException;
import com.raccon.GymRank.exercises.domain.model.Exercise;
import com.raccon.GymRank.exercises.domain.repository.ExerciseRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ExerciseFinder {

    private final ExerciseRepository repo;

    public ExerciseFinder(ExerciseRepository repo) {
        this.repo = repo;
    }

    public ExerciseDTO findExerciseById(UUID id) {

        Optional<Exercise> exercise = repo.findById(id);

        return exercise
                .map(ExerciseModelToDtoMapper::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException("No such exercise in database for id : " + id));
    }

}
