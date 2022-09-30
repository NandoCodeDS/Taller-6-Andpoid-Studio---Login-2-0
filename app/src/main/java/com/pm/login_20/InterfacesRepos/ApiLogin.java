package com.pm.login_20.InterfacesRepos;

import com.pm.login_20.Login;
import com.pm.login_20.User;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiLogin {

    @FormUrlEncoded
    @POST("login")
    Call<Login> LOGIN_CALL(
            @Field("email") String email,
            @Field("password") String password
    );

    @GET("login/{email}")
    Call<Login> FIND(@Path("email") String email
    );

    @DELETE("login/{email}")
    Call<Login> DELETE(@Path("email") String email
    );

    @FormUrlEncoded
    @POST("logout")
    Call<Login>LOGOUT_CALL(
            @Field("token") String token
    );


}
