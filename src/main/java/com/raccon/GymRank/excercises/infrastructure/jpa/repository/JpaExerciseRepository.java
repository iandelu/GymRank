package com.raccon.GymRank.excercises.infrastructure.jpa.repository;

import com.raccon.GymRank.excercises.domain.model.Exercise;
import com.raccon.GymRank.excercises.domain.repository.ExerciseRepository;
import com.raccon.GymRank.excercises.infrastructure.jpa.ExerciseEntity;
import com.raccon.GymRank.excercises.infrastructure.jpa.mapper.ExerciseModelToEntityMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class JpaExerciseRepository implements ExerciseRepository {

    private final SpringDataExerciseRepository repo;

    public JpaExerciseRepository(SpringDataExerciseRepository repo) {
        this.repo = repo;
    }


    @Override
    public UUID save(Exercise exercise) {
        ExerciseEntity entity = ExerciseModelToEntityMapper.toEntity(exercise);
        return repo.save(entity).getId();
    }

    @Override
    public Optional<Exercise> findById(UUID id) {
        Optional<ExerciseEntity> entity = repo.findById(id);
        return entity.map(ExerciseModelToEntityMapper::toModel);
    }
}
