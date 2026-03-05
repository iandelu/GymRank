package com.raccon.GymRank.exercises.infrastructure.web;

import com.raccon.GymRank.exercises.application.ExerciseCreator;
import com.raccon.GymRank.exercises.application.ExerciseFinder;
import com.raccon.GymRank.exercises.application.dto.ExerciseDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/exercises")
@Tag(name = "Exercise", description = "This is the first version of exercise management API")
public class ExerciseController {

    ExerciseCreator creator;
    ExerciseFinder finder;

    public ExerciseController(ExerciseCreator creator, ExerciseFinder finder) {
        this.creator = creator;
        this.finder = finder;

    }

    @GetMapping("/{id}")
    public ResponseEntity<ExerciseDTO> getExercise(@PathVariable UUID id) {
            return ResponseEntity.ok(finder.findExerciseById(id));
    }

    @PostMapping
    public ResponseEntity<UUID> createExercise(@RequestBody ExerciseDTO dto){
            return ResponseEntity.ok(creator.create(dto));
    }

}
