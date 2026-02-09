package com.raccon.GymRank.infrastructure.web.persistence.jpa.repository;

import com.raccon.GymRank.infrastructure.web.persistence.jpa.ExerciseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpringDataExerciseRepository extends JpaRepository<ExerciseEntity, UUID>{

}
