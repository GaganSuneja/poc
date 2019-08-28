package com.rogo.Utils.responseMessages;

public enum ErrorMessages {
    Q_NOT_FOUND("QUESTION TYPE NOT FOUND"),
    Q_TYPE_NOT_FOUND("QUESTION TYPE NOT FOUND");
    private final String message;

    private ErrorMessages(String message){
        this.message = message;
    }
    public String message(){
        return  message;
    }
}
