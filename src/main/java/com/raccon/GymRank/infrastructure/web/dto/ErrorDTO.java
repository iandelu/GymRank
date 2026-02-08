package com.raccon.GymRank.infrastructure.web.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ErrorDTO{

    private final String message;
    private final String error;
    private final int status;
    private final LocalDateTime date;

    public ErrorDTO(String message, String error, int status) {
        this.message = message;
        this.error = error;
        this.status = status;
        this.date = LocalDateTime.now();
    }
}
