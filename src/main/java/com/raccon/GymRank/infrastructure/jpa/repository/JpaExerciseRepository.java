package com.raccon.GymRank.infrastructure.jpa.repository;

import com.raccon.GymRank.domain.model.Exercise;
import com.raccon.GymRank.domain.repository.ExerciseRepository;
import com.raccon.GymRank.infrastructure.jpa.ExerciseEntity;
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

        ExerciseEntity entity = new ExerciseEntity(
            exercise.name(),
            exercise.description(),
            exercise.group(),
            exercise.category(),
            exercise.getImage()
        );
        repo.save(entity);
    }

    @Override
    public Optional<Exercise> findById(UUID id) {
        Optional<ExerciseEntity> entity = repo.findById(id);

        Exercise model = new Exercise(
                entity.get().getName(),
                entity.get().getDescription(),
                entity.get().getMuscleGroup(),
                entity.get().getExerciseCategory(),
                entity.get().getImage()
        );

        return Optional.of(model);
    }
}
