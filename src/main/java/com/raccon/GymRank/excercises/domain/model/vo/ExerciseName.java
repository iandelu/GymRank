package com.raccon.GymRank.excercises.domain.model.vo;

import java.util.Objects;
import java.util.regex.Pattern;

public record ExerciseName(String name) {

    private static final Pattern CONTAINS_NUMBERS = Pattern.compile(".*[0-9].*");

    public ExerciseName {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name cant be empty or null");
        if (name.length() > 100) throw new IllegalArgumentException("Name too long");
        if (CONTAINS_NUMBERS.matcher(name).matches()) throw new IllegalArgumentException("Cannot contains numbers");
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ExerciseName(String name1))) return false;
        return Objects.equals(name, name1);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

}
