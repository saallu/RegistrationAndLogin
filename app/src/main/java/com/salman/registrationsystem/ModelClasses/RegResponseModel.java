package com.salman.registrationsystem.ModelClasses;

import com.google.gson.annotations.SerializedName;

public class RegResponseModel {

    @SerializedName("success")
    private Boolean success;
    @SerializedName("message")
    private String message;


    public RegResponseModel() {
    }


    public RegResponseModel(Boolean success, String message) {
        super();
        this.success = success;
        this.message = message;
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

}