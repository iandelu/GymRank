package com.raccon.GymRank.domain.model.vo;

import java.util.Objects;

public record ExerciseDescription (String description) {

    public ExerciseDescription {
        if (description == null || description.isBlank()) throw new IllegalArgumentException("Name cant be empty or null");
        if (description.length() > 300) throw new IllegalArgumentException("Description too long");
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ExerciseName(String name1))) return false;
        return Objects.equals(description, name1);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(description);
    }
}
