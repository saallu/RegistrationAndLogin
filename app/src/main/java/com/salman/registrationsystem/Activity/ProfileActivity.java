package com.salman.registrationsystem.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.salman.registrationsystem.ModelClasses.LoginResponseModel;
import com.salman.registrationsystem.ModelClasses.ShowResponse;

import com.salman.registrationsystem.Network.ApiCall;
import com.salman.registrationsystem.Network.RetrofitApiClient;
import com.salman.registrationsystem.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static com.salman.registrationsystem.R.id.add;
import static com.salman.registrationsystem.R.id.nameTextView;

public class ProfileActivity extends AppCompatActivity {

    TextView name;
    TextView email;
    TextView phone;
    TextView address;

    Button update;

    //saving in this shit
    String guid;
    String pass;
    String email_passing;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Logger.addLogAdapter(new AndroidLogAdapter());

        name= (TextView) findViewById(R.id.nameTextView);
        email =  (TextView) findViewById(R.id.emaiTextView);
        phone =  (TextView) findViewById(R.id.phoneTextView);
        address= (TextView) findViewById(R.id.addressTextView);
        update = (Button) findViewById(R.id.update);



        //Catching data from main activity
        Intent in = getIntent();
        String id = in.getStringExtra("SS");
        String passs = in.getStringExtra("PASS");
        String pass_emal = in.getStringExtra("EMAIL");
        Logger.d(id);
        guid = id;
        pass = passs;
        email_passing = pass_emal;

        Initailize(guid);

    }

    private void Initailize(String userGuid) {

        ApiCall api=RetrofitApiClient.getClient().create(ApiCall.class);
        Call<ShowResponse> call=api.getData(userGuid);
        call.enqueue(new Callback<ShowResponse>() {
            @Override
            public void onResponse(Call<ShowResponse> call, Response<ShowResponse> response) {

             //   Toast.makeText(getApplicationContext(),""+response.code(),Toast.LENGTH_SHORT).show();
                if (response.code() == 200){
                    ShowResponse showResponse=response.body();
                    final String Name = showResponse.getProfileModel().getName();
                    name.setText(Name);
                    String Email= showResponse.getProfileModel().getEmail();
                    email.setText(Email);
                    final String Phone = showResponse.getProfileModel().getPhone();
                    phone.setText(Phone);
                    final String Address = showResponse.getProfileModel().getAddress();
                    address.setText(Address);

                    update.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent i = new Intent(ProfileActivity.this,UpdateActivity.class);
                            i.putExtra("Name",Name);
                            i.putExtra("Phone",Phone);
                            i.putExtra("Address",Address);

                            //sending to update activity
                            i.putExtra("EEEMAIL",email_passing);
                            i.putExtra("GUID",guid);
                            i.putExtra("PASSWORD",pass);
                            startActivity(i);
                        }
                    });


                }else {
                    Toast.makeText(getApplicationContext(),""+response.body(),Toast.LENGTH_LONG).show();

                }

            }

            @Override
            public void onFailure(Call<ShowResponse> call, Throwable t) {

                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();

            }
        });

    }
}
