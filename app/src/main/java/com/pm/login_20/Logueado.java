package com.pm.login_20;

import android.content.Intent;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.pm.login_20.repository.ApiUser;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Logueado extends AppCompatActivity {
    TextView txtToken;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        txtToken=findViewById(R.id.textView);
        Bundle intet = getIntent().getExtras();
        String tokenI = intet.getString("token");

        txtToken.setText(tokenI);
        Button btnLogout=findViewById(R.id.btn_logout);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            HttpLoggingInterceptor loggin = new HttpLoggingInterceptor();
            @Override
            public void onClick(View view) {
                String token=tokenI;

                loggin.setLevel(HttpLoggingInterceptor.Level.BODY);
                OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
                httpClient.addInterceptor(loggin);
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://localhost:5432/postgres/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(httpClient.build())
                        .build();
                ApiUser logout = retrofit.create(ApiUser.class);
                Call<User> call = logout.LOGOUT_CALL(token);
                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if(response.isSuccessful()&&response.body()!=null){
                            Toast.makeText(Logueado.this,"La sesion se ha cerrado", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Logueado.this,MainActivity.class));
                            finish();
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(Logueado.this,"Hubo un error, intente de nuevo", Toast.LENGTH_LONG).show();

                    }
                });
            }
        });

    }
}
