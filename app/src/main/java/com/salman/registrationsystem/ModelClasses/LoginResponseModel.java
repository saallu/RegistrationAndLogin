package com.salman.registrationsystem.ModelClasses;

public class LoginResponseModel {

    private Boolean success;
    private String message;
    private String userGuid;


    public LoginResponseModel() {
    }


    public LoginResponseModel(Boolean success, String message, String userGuid) {
        super();
        this.success = success;
        this.message = message;
        this.userGuid = userGuid;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserGuid() {
        return userGuid;
    }

    public void setUserGuid(String userGuid) {
        this.userGuid = userGuid;
    }

}