package com.rogo.bean;

public class UserType {
    private int userTypeId;
    private String userType;

    public UserType(){}

    public UserType(int userTypeId, String userType) {
        this.userTypeId = userTypeId;
        this.userType = userType;
    }

    public int getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(int userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "UserType{" +
                "userTypeId=" + userTypeId +
                ", userType='" + userType + '\'' +
                '}';
    }
}
