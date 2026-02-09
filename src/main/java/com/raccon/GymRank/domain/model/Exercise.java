package com.raccon.GymRank.domain.model;


import com.raccon.GymRank.domain.model.vo.ExerciseDescription;
import com.raccon.GymRank.domain.model.vo.ExerciseName;

public class Exercise{
    private final ExerciseName name;
    private final ExerciseDescription description;
    private final String image;
    private final MuscleGroup group;
    private final ExerciseCategory category;

    public Exercise(String name, String description, String image, String group, String category) {
        this.name = new ExerciseName(name);
        this.description = new ExerciseDescription(description);
        this.image = image;
        this.group = MuscleGroup.valueOf(group);
        this.category = ExerciseCategory.valueOf(category);
    }

    public String name() {
        return name.name();
    }

    public String description() {
        return description.description();
    }

    public ExerciseName getName() {
        return name;
    }

    public ExerciseDescription getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public MuscleGroup getGroup() {
        return group;
    }

    public ExerciseCategory getCategory() {
        return category;
    }

    public String group() {
        return group.toString();
    }

    public String category() {
        return category.toString();
    }
}

