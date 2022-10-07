package com.pm.login_20.InterfacesRepos;

import com.pm.login_20.Login;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface ApiLogin {

    @GET("/usuarios")
    Call<List<Login>> getLogin();

    @GET("usuarios/{id}")
    Call<Login> getLoginOne(@Path("id") int id);




}
