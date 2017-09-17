package com.salman.registrationsystem.ModelClasses;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Salman on 9/14/2017.
 */

public class AuthenticationModel {
    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String password;
    @SerializedName("userGuid")
    private String userGuid;


    public AuthenticationModel() {
    }


    public AuthenticationModel(String email, String password, String userGuid) {
        super();
        this.email = email;
        this.password = password;
        this.userGuid = userGuid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserGuid() {
        return userGuid;
    }

    public void setUserGuid(String userGuid) {
        this.userGuid = userGuid;
    }
}
