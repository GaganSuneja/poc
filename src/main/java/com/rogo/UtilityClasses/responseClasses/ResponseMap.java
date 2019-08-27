package com.rogo.UtilityClasses.responseClasses;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.HttpStatus;

public class ResponseMap {

    private String message;
    @JsonIgnore
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


