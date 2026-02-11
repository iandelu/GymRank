package com.raccon.GymRank.infrastructure.web;

import com.raccon.GymRank.application.useCases.FetchExerciseUseCase;
import com.raccon.GymRank.application.useCases.SaveExerciseUseCase;
import com.raccon.GymRank.infrastructure.web.dto.ExerciseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/exercise")
public class ExerciseController {

    FetchExerciseUseCase fetchExerciseUseCase;
    SaveExerciseUseCase saveExerciseUseCase;

    public ExerciseController(FetchExerciseUseCase fetchExerciseUseCase, SaveExerciseUseCase saveExerciseUseCase) {
        this.fetchExerciseUseCase = fetchExerciseUseCase;
        this.saveExerciseUseCase = saveExerciseUseCase;

    }

    @GetMapping("/{id}")
    public ResponseEntity<ExerciseDTO> getExercise(@PathVariable UUID id) {
            return ResponseEntity.ok(fetchExerciseUseCase.fetchExerciseById(id));
    }

    @PostMapping
    public ResponseEntity<UUID> createExercise(@RequestBody ExerciseDTO dto){
            return ResponseEntity.ok(saveExerciseUseCase.saveExercise(dto));
    }

}
