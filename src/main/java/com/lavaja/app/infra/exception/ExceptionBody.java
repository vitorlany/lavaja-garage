package com.lavaja.app.infra.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExceptionBody {

    private LocalDateTime dateTime;
    private String label;
    private String message;

    public ExceptionBody(String label, String message) {
        this.dateTime = LocalDateTime.now();
        this.label = label;
        this.message = message;
    }
}
