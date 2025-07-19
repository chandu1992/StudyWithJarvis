package com.jarvisworkshop.StudyWithJarvis.utilities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

public class ResponseHandler<T> {

    private T data;
    private int statusCode;
    private String message;
    private LocalDateTime timestamp;

    public ResponseHandler(T data, int statusCode, String message, LocalDateTime date) {
        this.data = data;
        this.statusCode = statusCode;
        this.message = message;
        this.timestamp = date;
    }

    public T getData() {
        return data;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
