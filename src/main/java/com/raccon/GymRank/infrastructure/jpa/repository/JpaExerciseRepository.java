package com.raccon.GymRank.infrastructure.jpa.repository;

import com.raccon.GymRank.domain.model.Exercise;
import com.raccon.GymRank.domain.repository.ExerciseRepository;
import com.raccon.GymRank.infrastructure.jpa.ExerciseEntity;
import com.raccon.GymRank.infrastructure.jpa.mapper.ExerciseModelToEntityMapper;
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
    public void save(Exercise exercise) {
        ExerciseEntity entity = ExerciseModelToEntityMapper.toEntity(exercise);
        repo.save(entity);
    }

    @Override
    public Optional<Exercise> findById(UUID id) {
        Optional<ExerciseEntity> entity = repo.findById(id);
        return entity.map(ExerciseModelToEntityMapper::toModel);
    }
}
