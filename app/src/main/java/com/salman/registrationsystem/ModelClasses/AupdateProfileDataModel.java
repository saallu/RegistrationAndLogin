package com.salman.registrationsystem.ModelClasses;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Salman on 9/14/2017.
 */

public class AupdateProfileDataModel {

    @SerializedName("name")
    private String name;
    @SerializedName("phone")
    private String phone;
    @SerializedName("address")
    private String address;

    /**
     * No args constructor for use in serialization
     *
     */
    public AupdateProfileDataModel() {
    }

    /**
     *
     * @param phone
     * @param address
     * @param name
     */
    public AupdateProfileDataModel(String name, String phone, String address) {
        super();
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
