package com.raccon.GymRank.excercises.application;

import com.raccon.GymRank.excercises.application.dto.ExerciseDTO;
import com.raccon.GymRank.excercises.application.dto.ExerciseModelToDtoMapper;
import com.raccon.GymRank.excercises.domain.model.Exercise;
import com.raccon.GymRank.excercises.domain.repository.ExerciseRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ExerciseCreator {

    private final ExerciseRepository repo;

    public ExerciseCreator(ExerciseRepository repo) {
        this.repo = repo;
    }

    public UUID create(ExerciseDTO dto) {

        try {
            Exercise exercise = ExerciseModelToDtoMapper.toModel(dto);
            return repo.save(exercise);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }
}
