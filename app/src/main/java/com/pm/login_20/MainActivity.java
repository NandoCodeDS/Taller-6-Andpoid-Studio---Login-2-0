package com.pm.login_20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.pm.login_20.repository.ApiUser;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "Bienvenidos a Sci High";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_login =findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            EditText userTV= findViewById(R.id.editTextTextPersonName);
            EditText passTV = findViewById(R.id.editTextTextPassword);
            HttpLoggingInterceptor loggin = new HttpLoggingInterceptor();
            @Override
            public void onClick(View view) {
                String email = userTV.getText().toString().trim();
                String password = passTV.getText().toString().trim();

                loggin.setLevel(HttpLoggingInterceptor.Level.BODY);

                OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
                httpClient.addInterceptor(loggin);

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://localhost:5432/postgres/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(httpClient.build())
                        .build();
                ApiUser login =retrofit.create(ApiUser.class);
                Call<User> call =login.LOGIN_CALL(email, password);
                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if (response.isSuccessful() && response.body() !=null){
                            userTV.getText().clear();
                            passTV.getText().clear();
                            String tokenInter=response.body().getToken();

                            Intent intent =new Intent(MainActivity.this,Logueado.class);
                            intent.putExtra("token",tokenInter);
                            startActivity(intent);
                            
                        }else if(response.code()==401){
                            Toast.makeText(MainActivity.this, "Correo invalido", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(MainActivity.this,ValidateAccount.class));
                            finish();
                        }else{
                            Toast.makeText(MainActivity.this, "Error en login/Password", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Se produjo un Error, intentelo de nuevo", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }
    /*
    public void sendMessage(View view) {
        String us = userTV.getText().toString();
        String ps = passTV.getText().toString();


        if(us.equals("Orlando") && ps.equals("123")){
            Intent intent = new Intent(this, DisplayMessageActivity.class);
            EditText editText = (EditText) userTV;
            String message = editText.getText().toString()+" Bienvenido";
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }else{
            Toast.makeText(this,"Usuario/Contraseña Incorrecto",Toast.LENGTH_LONG).show();
        }
        userTV.setText("");
        passTV.setText("");
    }*/
}