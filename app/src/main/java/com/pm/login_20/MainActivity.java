package com.pm.login_20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.pm.login_20.Clientes.ApiCliente;
import com.pm.login_20.InterfacesRepos.ApiLogin;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "Bienvenidos a Sci High";

    private static final String TAG = "MainActivity";
    private static final String TAG2 = "Logueado";
    ApiLogin apiLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiLogin = ApiCliente.getCliente().create(ApiLogin.class);
    }

    public void GET_UserById(View view) {
        Call<List<Login>> loginCall = apiLogin.getLogin();
        loginCall.enqueue(new Callback<List<Login>>() {
            @Override
            public void onResponse(Call<List<Login>> call, Response<List<Login>> response) {
                Log.e(TAG, "on response: " + response.body());
            }

            @Override
            public void onFailure(Call<List<Login>> call, Throwable t) {
                Log.e(TAG,"on failure: "+t.getLocalizedMessage());
            }
        });
    }
    /*public void GET_UserById(View view) {
        Call<Login> loginCall = apiLogin.getLoginOne(3);
        loginCall.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                Log.e(TAG, "on response: "+response.body());
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                Log.e(TAG,"on failure: "+t.getLocalizedMessage());
            }
        });
    }*/
}