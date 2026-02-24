package com.raccon.GymRank.exercises.application.service;

import com.raccon.GymRank.excercises.application.service.ExerciseService;
import com.raccon.GymRank.excercises.domain.exception.ResourceNotFoundException;
import com.raccon.GymRank.excercises.domain.model.Exercise;
import com.raccon.GymRank.excercises.domain.repository.ExerciseRepository;
import com.raccon.GymRank.excercises.infrastructure.web.dto.ExerciseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class ExerciseServiceTest {

    private ExerciseRepository repo;
    private ExerciseService exerciseService;

    @BeforeEach
    void init(){
        repo = mock(ExerciseRepository.class);
        exerciseService = new ExerciseService(repo);
    }

    @Test
    void shouldFetchExerciseById(){
        Optional<Exercise> expectedDomain = Optional.of(new Exercise(
                "NAME",
                "DESC",
                "BACK",
                "BARBELL",
                "IMAGE"
        ));
        UUID uuid = UUID.fromString("878c9c05-15db-4a27-84be-2e7f3b9c7ea2");

        when(repo.findById(uuid)).thenReturn(expectedDomain);
        ExerciseDTO dto = exerciseService.fetchExerciseById(uuid);

        verify(repo).findById(uuid);
        assertEquals(dto.description(), expectedDomain.get().description());
        assertEquals(dto.name(), expectedDomain.get().name());
    }

    @Test
    void shouldThrowAnExceptionWhenFetchExerciseByIdAndRepoReturnEmpty(){
        UUID uuid = UUID.fromString("878c9c05-15db-4a27-84be-2e7f3b9c7ea2");

        when(repo.findById(uuid)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> exerciseService.fetchExerciseById(uuid));
    }
}