package com.raccon.GymRank.excercises.application.service;

import com.raccon.GymRank.excercises.application.useCases.FetchExerciseUseCase;
import com.raccon.GymRank.excercises.application.useCases.SaveExerciseUseCase;
import com.raccon.GymRank.excercises.domain.exception.ResourceNotFoundException;
import com.raccon.GymRank.excercises.domain.model.Exercise;
import com.raccon.GymRank.excercises.domain.repository.ExerciseRepository;
import com.raccon.GymRank.excercises.infrastructure.web.dto.ExerciseDTO;
import com.raccon.GymRank.excercises.infrastructure.web.dto.ExerciseModelToDtoMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ExerciseService implements FetchExerciseUseCase, SaveExerciseUseCase {

    private final ExerciseRepository repo;

    public ExerciseService(ExerciseRepository repo) {
        this.repo = repo;
    }


    @Override
    public ExerciseDTO fetchExerciseById(UUID id) {

        Optional<Exercise> exercise = repo.findById(id);

        return exercise
                .map(ExerciseModelToDtoMapper::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException("No such exercise in database for id : " + id));
    }

    @Override
    public UUID saveExercise(ExerciseDTO dto) {

        try {
            Exercise exercise = ExerciseModelToDtoMapper.toModel(dto);
            return repo.save(exercise);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }
}
