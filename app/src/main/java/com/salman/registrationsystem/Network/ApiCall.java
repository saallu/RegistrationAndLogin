package com.salman.registrationsystem.Network;

import com.salman.registrationsystem.ModelClasses.AupdateProfileDataModel;
import com.salman.registrationsystem.ModelClasses.Authenticate;
import com.salman.registrationsystem.ModelClasses.AuthenticationModel;
import com.salman.registrationsystem.ModelClasses.LoginModelClass;
import com.salman.registrationsystem.ModelClasses.LoginResponseModel;
import com.salman.registrationsystem.ModelClasses.RegModelClass;
import com.salman.registrationsystem.ModelClasses.RegResponseModel;
import com.salman.registrationsystem.ModelClasses.ShowResponse;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Url;



public interface ApiCall {

    @POST("user")
    Call<RegResponseModel> postAll(@Body RegModelClass modelClass);

    @POST("user/login")
    Call<LoginResponseModel> logIn(@Body LoginModelClass loginModelClass);

    @GET("user/{userGuid}")
    Call<ShowResponse> getData(@Path("userGuid") String userGuid);

    @PATCH("user")
    Call<RegResponseModel> updateData(@Body Authenticate authenticate);





}
