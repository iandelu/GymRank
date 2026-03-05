package com.raccon.GymRank.excercises.application;

import com.raccon.GymRank.excercises.application.dto.ExerciseDTO;
import com.raccon.GymRank.excercises.application.dto.ExerciseModelToDtoMapper;
import com.raccon.GymRank.excercises.domain.exception.ResourceNotFoundException;
import com.raccon.GymRank.excercises.domain.model.Exercise;
import com.raccon.GymRank.excercises.domain.repository.ExerciseRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ExerciseFinder {

    private final ExerciseRepository repo;

    public ExerciseFinder(ExerciseRepository repo) {
        this.repo = repo;
    }

    public ExerciseDTO findExercise(UUID id) {

        Optional<Exercise> exercise = repo.findById(id);

        return exercise
                .map(ExerciseModelToDtoMapper::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException("No such exercise in database for id : " + id));
    }

}
