package com.raccon.GymRank.domain.model;


import com.raccon.GymRank.domain.model.vo.ExerciseDescription;
import com.raccon.GymRank.domain.model.vo.ExerciseName;

public class Exercise{
    private final ExerciseName name;
    private final ExerciseDescription description;
    private final MuscleGroup group;
    private final ExerciseCategory category;
    private final String image;

    public Exercise(String name, String description, String image, String group, String category) {
        this.name = new ExerciseName(name);
        this.description = new ExerciseDescription(description);
        this.group = MuscleGroup.valueOf(group); //he leido que valueOf es case sensitive son malas practicas en dominio pr si viene null
        this.category = ExerciseCategory.valueOf(category);
        this.image = image; //renta hacer image ValueObject por DDD?
    }

    public String name() {
        return name.name();
    } //me acabo de fijar que no entiendo por qué tenemos getters que me da la sensacion de estasr duplicados

    public String description() {
        return description.description();
    } //no tenemos el metodo .description en ExerciseDescription

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

