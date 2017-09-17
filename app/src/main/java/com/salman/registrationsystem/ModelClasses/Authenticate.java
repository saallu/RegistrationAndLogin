package com.salman.registrationsystem.ModelClasses;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Salman on 9/14/2017.
 */

public class Authenticate {

    @SerializedName("profileData")
    AupdateProfileDataModel aupdateProfileDataModel;
    @SerializedName("authentication")
    AuthenticationModel authenticationModel;

    public Authenticate() {
    }

    public Authenticate(AupdateProfileDataModel aupdateProfileDataModel, AuthenticationModel authenticationModel) {
        this.aupdateProfileDataModel = aupdateProfileDataModel;
        this.authenticationModel = authenticationModel;
    }

    public AupdateProfileDataModel getAupdateProfileDataModel() {
        return aupdateProfileDataModel;
    }

    public void setAupdateProfileDataModel(AupdateProfileDataModel aupdateProfileDataModel) {
        this.aupdateProfileDataModel = aupdateProfileDataModel;
    }

    public AuthenticationModel getAuthenticationModel() {
        return authenticationModel;
    }

    public void setAuthenticationModel(AuthenticationModel authenticationModel) {
        this.authenticationModel = authenticationModel;
    }
}
