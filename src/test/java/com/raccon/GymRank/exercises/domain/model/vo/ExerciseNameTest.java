package com.raccon.GymRank.exercises.domain.model.vo;

import com.raccon.GymRank.excercises.domain.model.vo.ExerciseName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExerciseNameTest {

    @Test
    void shouldCreateInstanceWhenNameIsValid(){
        String validName = "Bench Press";

        ExerciseName exerciseName = new ExerciseName(validName);

        assertNotNull(exerciseName);
        assertEquals(validName, exerciseName.name());
    }

    @Test
    void shouldNotHaveAnyNumberInTheName(){
        String invalidName = "B3nch 0ress";

       IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new ExerciseName(invalidName));
       assertEquals("Cannot contains numbers", exception.getMessage());
    }


}