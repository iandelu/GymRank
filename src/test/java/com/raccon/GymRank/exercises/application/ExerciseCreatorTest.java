package com.raccon.GymRank.exercises.application;

import com.raccon.GymRank.exercises.domain.repository.ExerciseRepository;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.mock;

class ExerciseCreatorTest {


    private ExerciseCreator creator;
    private ExerciseRepository repo;


    @BeforeEach
    void init(){
        repo = mock(ExerciseRepository.class);
        creator = new ExerciseCreator(repo);
    }
}