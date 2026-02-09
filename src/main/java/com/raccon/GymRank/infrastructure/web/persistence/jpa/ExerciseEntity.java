package com.raccon.GymRank.infrastructure.web.persistence.jpa;


/* duda: no sabía si podía llamar ExerciseEntity a la clase porque he visto que son malas prácticas pero al
querer separar jpa de dominio para aplicar ddd si se puede poner este cnombre a la clase no?*/

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class ExerciseEntity {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) //¿GenerationType.IDENTITY?
    private Long id;
    private String name;





  //había creido un constructor vacío pero he visto NoArgsConstructor de Lombok

}





