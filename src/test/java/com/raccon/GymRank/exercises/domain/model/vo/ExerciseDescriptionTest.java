package com.raccon.GymRank.exercises.domain.model.vo;

import com.raccon.GymRank.excercises.domain.model.vo.ExerciseDescription;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ExerciseDescriptionTest {

    @ParameterizedTest
    @MethodSource("provideInvalidDescriptions")
    void shouldThrowAnExceptionWhenDescriptionIsInvalid(String description){
        assertThrows(IllegalArgumentException.class, () -> new ExerciseDescription(description));
    }

    @Test
    void shouldCreateInstanceWhenDescriptionIsValid() {
        String validDesc = "Press de banca con mancuernas";
        ExerciseDescription exercise = new ExerciseDescription(validDesc);

        assertEquals(validDesc, exercise.description());
    }



    private static Stream<Arguments> provideInvalidDescriptions(){
        return Stream.of(
                Arguments.of((Object) null),
                Arguments.of(""),
                Arguments.of(" "),
                Arguments.of("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sagittis rutrum scelerisque. Pellentesque imperdiet eu justo eget porttitor. Aenean eget enim iaculis, tincidunt justo sit amet, mattis lorem. Nulla facilisi. Vestibulum mollis bibendum erat at vestibulum. Ut scelerisque imperdiet nisi ac sagittis. Praesent mattis tortor sed nulla elementum finibus. Fusce molestie massa a nisi semper consectetur. Vivamus ultrices tincidunt pretium. In sit amet gravida velit, ut lacinia justo. Ut vestibulum tortor vitae lacus egestas lacinia. Quisque lacinia eros justo, at convallis risus rutrum vel. Maecenas ac risus ultricies, sodales lorem vel, bibendum nibh. Vivamus convallis justo at ex ultrices elementum. Integer euismod at augue et ultrices. Cras semper egestas magna, sit amet commodo ipsum sagittis at. Vivamus placerat semper elit at rhoncus. Phasellus nec dolor a massa pellentesque pretium sit amet et purus. Integer eget cursus libero. Pellentesque et urna nunc. Nullam et enim id nibh aliquam euismod. Morbi ut quam sed lectus hendrerit ultrices vitae at felis. Aenean malesuada id nibh in eleifend. Integer malesuada ultricies quam, in efficitur mi posuere sit amet. Etiam sollicitudin faucibus nulla, sed lacinia nulla. Quisque id quam eget nisl sollicitudin eleifend. Vestibulum tempor dolor sit amet ante lacinia, eget suscipit urna imperdiet. Maecenas sit amet est tincidunt, commodo est vel, vulputate turpis. Nam ut nulla et nisi vestibulum faucibus. Sed sed ex congue, efficitur orci vel, accumsan diam. Cras commodo sed nunc ut posuere. Pellentesque bibendum massa eu ante interdum, et luctus odio venenatis. Nunc lacinia sapien pulvinar dui tincidunt, eget semper arcu sagittis. Duis facilisis mi id metus volutpat, ut elementum lorem sollicitudin. Phasellus ullamcorper sodales magna et scelerisque. Proin sem turpis, scelerisque et sodales et, egestas eu felis. In commodo cursus felis, id tempus purus rutrum quis. Fusce sit amet urna porta, luctus tellus eget, pharetra sem. Vivamus interdum lacus a lacu")
        );
    }

}