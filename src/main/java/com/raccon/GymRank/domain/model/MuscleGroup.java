package com.raccon.GymRank.domain.model;

public enum MuscleGroup {
    CHEST,
    BACK,
    SHOULDER,
    LEGS,
    ARMS,
    CARDIO,
    CORE,
    FULL_BODY,
    OTHER,
    DEFAULT;

    static MuscleGroup fromValue(String value){
        if (value == null) return MuscleGroup.DEFAULT;
        return valueOf(value);
    }
}
