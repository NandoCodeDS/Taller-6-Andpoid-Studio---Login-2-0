package com.pm.login_20.repository;

import com.pm.login_20.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiUser {

    @FormUrlEncoded
    @POST("login")
    Call<User>LOGIN_CALL(
            @Field("email") String email,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("validate_account")
    Call<User>VALIDATE_CALL(
            @Field("email") String email,
            @Field("code") String code
    );

    @FormUrlEncoded
    @POST("logout")
    Call<User>LOGOUT_CALL(
            @Field("token") String token
    );

    @FormUrlEncoded
    @POST("index")
    Call<User>INDEX_CALL(
            @Field("token") String token
    );

    @GET("persona/{id}")
    Call<User> FIND(@Path("id") String id
    );
}
