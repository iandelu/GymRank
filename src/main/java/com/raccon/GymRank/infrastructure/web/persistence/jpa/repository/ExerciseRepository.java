package com.raccon.GymRank.infrastructure.web.persistence.jpa.repository;

import com.raccon.GymRank.infrastructure.web.dto.ExerciseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends CrudRepository<ExerciseDTO, Long>{

}
