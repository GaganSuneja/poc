package com.rogo.responseClasses;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
@Scope("prototype")
public class ResponseMap {

    private Boolean error;
    private String errorMessage;
    private Boolean success;
    private String successMessage;
    private Map dataMap;
    public ResponseMap(){
        setSuccess(false);
        setSuccessMessage("");
        setError(false);
        setErrorMessage("");
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    private void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    private void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }

    public void setResponseSucess(String successMessage){
        setSuccess(true);
        setSuccessMessage(successMessage);
    }
    public void setResponseError(String errorMessage){
        setError(true);
        setErrorMessage(errorMessage);
    }
}


