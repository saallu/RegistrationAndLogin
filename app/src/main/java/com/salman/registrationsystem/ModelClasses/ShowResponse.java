package com.salman.registrationsystem.ModelClasses;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Salman on 9/13/2017.
 */

public class ShowResponse {


    @SerializedName("success")
    String success;

    @SerializedName("message")
    String message;

    @SerializedName("userGuid")
    String userGuid;

    @SerializedName("profile")
    ProfileModel profileModel;

    public ShowResponse() {
    }

    public ShowResponse(String success, String message, String userGuid, ProfileModel profileModel) {
        this.success = success;
        this.message = message;
        this.userGuid = userGuid;
        this.profileModel = profileModel;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
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

    public ProfileModel getProfileModel() {
        return profileModel;
    }

    public void setProfileModel(ProfileModel profileModel) {
        this.profileModel = profileModel;
    }
}
