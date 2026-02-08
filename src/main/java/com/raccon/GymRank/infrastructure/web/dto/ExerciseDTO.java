package com.raccon.GymRank.infrastructure.web.dto;

import java.util.UUID;

public record ExerciseDTO(
        UUID id,
        String name,
        String description,
        String muscleGroup,
        String exerciseCategory,
        String image
) {

    public static ExerciseDTO emptyExercise(){
        return new ExerciseDTO(
                UUID.randomUUID(),
                "Press Banca",
                "Consiste en tumbarse en un banco y levantar una barra, manteniendo los pies anclados, retracción escapular y codos a unos 45° para proteger los hombros",
                "CHEST",
                "MACHINE",
                "https://fitcron.com/exercise/press-banca-con-barra-pectoral/"
        );
    }
}
