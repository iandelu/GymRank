package com.raccon.GymRank.infrastructure.web.persistence.jpa;


/* duda: no sabía si podía llamar ExerciseEntity a la clase porque he visto que son malas prácticas pero al
querer separar jpa de dominio para aplicar ddd si se puede poner este cnombre a la clase no?*/

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Entity
@Table(name = "exercise")
@NoArgsConstructor
public class ExerciseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;

}





