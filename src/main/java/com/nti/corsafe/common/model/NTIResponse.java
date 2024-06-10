package com.nti.corsafe.common.model;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class NTIResponse<T> {

    private String message;
    private T data;
    private HttpStatus status;

    public NTIResponse(HttpStatus status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public NTIResponse(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public NTIResponse(HttpStatus status, T data) {
        this.status = status;
        this.data = data;
    }

    public NTIResponse(HttpStatus status) {
        this.status = status;
    }
}
