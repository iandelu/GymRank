package com.raccon.GymRank.infrastructure.web;

import com.raccon.GymRank.application.service.ExerciseService;
import com.raccon.GymRank.application.useCases.FetchExercise;
import com.raccon.GymRank.infrastructure.web.dto.ExerciseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/exercise")
public class ExerciseController {

    FetchExercise fetchExercise;

    public ExerciseController(ExerciseService fetchExercise) {
        this.fetchExercise = fetchExercise;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExerciseDTO> getExercise(@PathVariable UUID id) {
            return ResponseEntity.ok(fetchExercise.fetchExerciseById(id));
    }
}
