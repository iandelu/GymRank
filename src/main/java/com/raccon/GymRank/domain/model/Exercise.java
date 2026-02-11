package com.raccon.GymRank.domain.model;


import com.raccon.GymRank.domain.model.vo.ExerciseDescription;
import com.raccon.GymRank.domain.model.vo.ExerciseName;

public class Exercise{
    private final ExerciseName name;
    private final ExerciseDescription description;
    private final MuscleGroup group;
    private final ExerciseCategory category;
    private final String image;

    public Exercise(String name, String description, String group, String category, String image) {
        this.name = new ExerciseName(name);
        this.description = new ExerciseDescription(description);
        this.group = MuscleGroup.fromValue(group);
        this.category = ExerciseCategory.valueOf(category);
        this.image = image;
    }

    public String name() {
        return name.name();
    }

    public String description() {
        return description.description();
    }

    public String image() {
        return image;
    }

    public String group() {
        return group.toString();
    }

    public String category() {
        return category.toString();
    }
}

