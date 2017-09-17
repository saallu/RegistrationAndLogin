package com.salman.registrationsystem.Activity;

import android.content.Intent;
import android.icu.text.UnicodeSetSpanner;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.salman.registrationsystem.ModelClasses.LoginModelClass;
import com.salman.registrationsystem.ModelClasses.LoginResponseModel;
import com.salman.registrationsystem.Network.ApiCall;
import com.salman.registrationsystem.Network.RetrofitApiClient;
import com.salman.registrationsystem.R;

import javax.xml.transform.sax.SAXTransformerFactory;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    Button SignUp;
    Button SignIn;

    EditText email;
    EditText pass;

    String Password;

    String idData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Logger.addLogAdapter(new AndroidLogAdapter());

        SignUp = (Button) findViewById(R.id.signup);
        SignIn= (Button) findViewById(R.id.login);

        email= (EditText) findViewById(R.id.email);
        pass= (EditText) findViewById(R.id.password);


        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Registration.class);
                startActivity(intent);
            }
        });

        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Emaail = email.getText().toString();
                Password = pass.getText().toString();

                if (email.length() == 0 && pass.length() == 0){
                    Toast.makeText(getApplicationContext(),"Enter email and pass",Toast.LENGTH_LONG).show();
                }else {

                initialize(new LoginModelClass(Emaail,Password));
                }

            }
        });


    }

    private void initialize(LoginModelClass modelClass) {

        ApiCall apiCall= RetrofitApiClient.getClient().create(ApiCall.class);
        Call<LoginResponseModel> call=apiCall.logIn(modelClass);
        call.enqueue(new Callback<LoginResponseModel>() {
            @Override
            public void onResponse(Call<LoginResponseModel> call, Response<LoginResponseModel> response) {

                LoginResponseModel loginResponseModel = response.body();
                Logger.d(loginResponseModel.getMessage());
                String GUID = loginResponseModel.getUserGuid();

                Logger.d(GUID);



                Toast.makeText(getApplicationContext(),loginResponseModel.getMessage(),Toast.LENGTH_LONG).show();

                if(response.code()==200){

                   LoginResponseModel responseModel = response.body();
                    Toast.makeText(getApplicationContext(), responseModel.getMessage(), Toast.LENGTH_LONG).show();

                    if(responseModel.getSuccess()) { // user name and password is correct
                       // startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        Intent in=new Intent(MainActivity.this,ProfileActivity.class);

                        String ppp = pass.getText().toString();
                        String eemail = email.getText().toString();

                        //sending to profile activity
                        in.putExtra("PASS",ppp);
                        in.putExtra("EMAIL",eemail);
                        in.putExtra("SS",GUID);

                        startActivity(in);
                        finish(); // finish LoginActivity
                    }

                }

            }

            @Override
            public void onFailure(Call<LoginResponseModel> call, Throwable t) {
                Logger.d(t.getMessage());
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();


            }
        });

    }
}
