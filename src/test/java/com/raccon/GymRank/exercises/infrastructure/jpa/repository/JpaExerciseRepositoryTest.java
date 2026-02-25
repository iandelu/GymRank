package com.raccon.GymRank.exercises.infrastructure.jpa.repository;

import com.raccon.GymRank.excercises.domain.model.Exercise;
import com.raccon.GymRank.excercises.infrastructure.jpa.ExerciseEntity;
import com.raccon.GymRank.excercises.infrastructure.jpa.repository.JpaExerciseRepository;
import com.raccon.GymRank.excercises.infrastructure.jpa.repository.SpringDataExerciseRepository;
import com.raccon.GymRank.excercises.infrastructure.web.dto.ExerciseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

//test tonto porque no probamos JPA ni la integracion con la BD entonces no probamos infraestructura como tal creo
//solo probamos que la clase llame a .save y findById y que el mapper devuelve lo esperado
public class JpaExerciseRepositoryTest {

    private SpringDataExerciseRepository repo;

    private JpaExerciseRepository jpaExerciseRepository;

    @BeforeEach
    void init (){
        repo = mock(SpringDataExerciseRepository.class);
        jpaExerciseRepository = new JpaExerciseRepository(repo);
    }

    @Test
    void shouldSaveAndReturnId(){
       Exercise exercise = new Exercise(
               "SQUAD",
               "SQUAD DESCRIPTION HERE",
               "LEGS",
               "BARBELL",
               "IMAGE"
       );

       UUID expectedUuid = UUID.fromString("fab232c8-0a93-4d6c-bbdf-d7e0a2fb33f9");

       ExerciseEntity savedEntity = mock(ExerciseEntity.class);
       when(savedEntity.getId()).thenReturn(expectedUuid);
       when(repo.save(any(ExerciseEntity.class))).thenReturn(savedEntity);

       UUID result = jpaExerciseRepository.save(exercise);

       assertEquals(expectedUuid, result);
       verify(repo).save(any(ExerciseEntity.class));









    }

}
