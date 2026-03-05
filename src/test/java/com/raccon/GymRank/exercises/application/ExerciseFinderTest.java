package com.raccon.GymRank.exercises.application;

import com.raccon.GymRank.exercises.application.dto.ExerciseDTO;
import com.raccon.GymRank.exercises.domain.exception.ResourceNotFoundException;
import com.raccon.GymRank.exercises.domain.model.Exercise;
import com.raccon.GymRank.exercises.domain.repository.ExerciseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ExerciseFinderTest {

    private ExerciseRepository repo;
    private ExerciseFinder finder;

    @BeforeEach
    void init(){
        repo = mock(ExerciseRepository.class);
        finder = new ExerciseFinder(repo);
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
        ExerciseDTO dto = finder.findExerciseById(uuid);

        verify(repo).findById(uuid);
        assertEquals(dto.description(), expectedDomain.get().description());
        assertEquals(dto.name(), expectedDomain.get().name());
    }

    @Test
    void shouldThrowAnExceptionWhenFetchExerciseByIdAndRepoReturnEmpty(){
        UUID uuid = UUID.fromString("878c9c05-15db-4a27-84be-2e7f3b9c7ea2");

        when(repo.findById(uuid)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> finder.findExerciseById(uuid));
    }


}