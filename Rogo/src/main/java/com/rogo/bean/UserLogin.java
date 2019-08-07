package com.rogo.bean;

public class UserLogin {
    private String username;
    private String password;


    UserLogin(){}
    public String getUsername() {
        return username;
    }

    public UserLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
