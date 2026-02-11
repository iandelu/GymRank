package com.raccon.GymRank.domain.repository;

import com.raccon.GymRank.domain.model.Exercise;

import java.util.Optional;
import java.util.UUID;

public interface ExerciseRepository {
    UUID save(Exercise exercise);
    Optional<Exercise> findById(UUID id);
}
