package com.nti.corsafe.common.model;

import lombok.Data;

@Data
public class NTIResponse<T> {

    private String message;
    private T data;
    private int status;

    public NTIResponse(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
