package com.rogo.responseClasses;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

public class ResponseMap {

    private String message;
    private HttpStatus status;


    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public ResponseMap(){
        setMessage("");
    }

    public String getMessage() {
        return message;
    }

    public  void setMessage(String successMessage) {
        this.message = successMessage;
    }

}


