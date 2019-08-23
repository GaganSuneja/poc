package com.rogo.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rogo.responseClasses.ResponseMap;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

public class ApiError extends ResponseMap {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String debugMessage;
    private List<ApiSubError> subErrors;

    private ApiError() {
        timestamp = LocalDateTime.now();
    }

    public ApiError(HttpStatus status) {
        this();
        super.setStatus(status);
    }

    public HttpStatus getStatus() {
        return super.getStatus();
    }

    public void setStatus(HttpStatus status) {
        super.setStatus(status);
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return super.getMessage();
    }

    public void setMessage(String message) {
        super.setMessage(message);
    }

    public String getDebugMessage() {
        return debugMessage;
    }

    public void setDebugMessage(String debugMessage) {
        this.debugMessage = debugMessage;
    }

    public List<ApiSubError> getSubErrors() {
        return subErrors;
    }

    public void setSubErrors(List<ApiSubError> subErrors) {
        this.subErrors = subErrors;
    }

    ApiError(HttpStatus status, Throwable ex) {
        this();
        super.setStatus(status);
        super.setMessage("Unexpected error");
        this.debugMessage = ex.getLocalizedMessage();
    }

    ApiError(HttpStatus status, String message, Throwable ex) {
        this();
        super.setStatus(status);
        super.setMessage(message);
        this.debugMessage = ex.getLocalizedMessage();
    }
}
