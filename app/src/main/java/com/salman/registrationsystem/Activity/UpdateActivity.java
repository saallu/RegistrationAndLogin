package com.salman.registrationsystem.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.orhanobut.logger.Logger;
import com.salman.registrationsystem.ModelClasses.AupdateProfileDataModel;
import com.salman.registrationsystem.ModelClasses.Authenticate;
import com.salman.registrationsystem.ModelClasses.AuthenticationModel;
import com.salman.registrationsystem.ModelClasses.ProfileModel;
import com.salman.registrationsystem.ModelClasses.RegResponseModel;
import com.salman.registrationsystem.Network.ApiCall;
import com.salman.registrationsystem.Network.RetrofitApiClient;
import com.salman.registrationsystem.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateActivity extends AppCompatActivity {

    EditText updateName;
    EditText updatePhone;
    EditText updateAddress;

    Button updateButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        updateName = (EditText) findViewById(R.id.updateName);
        updatePhone= (EditText) findViewById(R.id.updatePhone);
        updateAddress= (EditText) findViewById(R.id.updateAddress);
        updateButton= (Button) findViewById(R.id.updateButton);




        Intent ii = getIntent();
        String NAME = ii.getStringExtra("Name");
        String PHONE = ii.getStringExtra("Phone");
        String ADDRESS = ii.getStringExtra("Address");

        final String GUID = ii.getStringExtra("GUID");
        final  String PASSWORD = ii.getStringExtra("PASSWORD");
        final String EMAIL = ii.getStringExtra("EEEMAIL");


        updateName.setText(NAME);
        updateName.setSelection(updateName.getText().length());
        updatePhone.setText(PHONE);
        updateAddress.setText(ADDRESS);

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name=updateName.getText().toString();
                String phone = updatePhone.getText().toString();
                String address = updateAddress.getText().toString();

                AuthenticationModel authenticationModel=new AuthenticationModel(EMAIL,PASSWORD,GUID);
                AupdateProfileDataModel aupdateProfileDataModel=new AupdateProfileDataModel(name,phone,address);

                Authenticate authenticate=new Authenticate(aupdateProfileDataModel,authenticationModel);

                updateYourData(authenticate);

            }
        });




    }


    public void updateYourData(Authenticate authenticate){

        ApiCall apiCall= RetrofitApiClient.getClient().create(ApiCall.class);
        Call<RegResponseModel> call=apiCall.updateData(authenticate);
        call.enqueue(new Callback<RegResponseModel>() {
            @Override
            public void onResponse(Call<RegResponseModel> call, Response<RegResponseModel> response) {

              //  Authenticate a=response.body();
                RegResponseModel responseModel = response.body();

                Toast.makeText(getApplicationContext(),""+responseModel.getMessage(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<RegResponseModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();


            }
        });

    }

}
