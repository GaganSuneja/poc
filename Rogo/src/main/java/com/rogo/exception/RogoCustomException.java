package com.rogo.exception;

import org.springframework.http.HttpStatus;

public class RogoCustomException extends  Exception {
    private HttpStatus status;
    private String message;

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public RogoCustomException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
