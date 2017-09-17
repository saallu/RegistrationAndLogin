package com.salman.registrationsystem.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.salman.registrationsystem.ModelClasses.RegModelClass;
import com.salman.registrationsystem.ModelClasses.RegResponseModel;
import com.salman.registrationsystem.Network.ApiCall;
import com.salman.registrationsystem.Network.RetrofitApiClient;
import com.salman.registrationsystem.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Registration extends AppCompatActivity {

    EditText name;
    EditText email;
    EditText password;
    EditText phone;
    EditText address;

    Button signupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        name= (EditText) findViewById(R.id.name);
        email= (EditText) findViewById(R.id.emailRegistration);
        password= (EditText) findViewById(R.id.passwordRegistration);
        phone= (EditText) findViewById(R.id.phone);
        address= (EditText) findViewById(R.id.address);
        Logger.addLogAdapter(new AndroidLogAdapter());

        signupButton= (Button) findViewById(R.id.signmeUp);


        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Name = name.getText().toString();
                String Email = email.getText().toString();
                String Password = password.getText().toString();
                String Phone = phone.getText().toString();
                String Address = address.getText().toString();

                initializeAll(new RegModelClass(Name,Email,Password,Phone,Address));
            }
        });

    }

    private void initializeAll(RegModelClass modelClass) {
        ApiCall apiCall = RetrofitApiClient.getClient().create(ApiCall.class);
        Call<RegResponseModel> call = apiCall.postAll(modelClass);
        call.enqueue(new Callback<RegResponseModel>() {
            @Override
            public void onResponse(Call<RegResponseModel> call, Response<RegResponseModel> response) {

                RegResponseModel responseModel=response.body();
                Logger.d(responseModel.getMessage());
                Toast.makeText(getApplicationContext(),"success"+responseModel.getMessage(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<RegResponseModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"failed "+t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
