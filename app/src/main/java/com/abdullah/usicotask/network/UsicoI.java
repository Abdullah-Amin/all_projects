package com.abdullah.usicotask.network;

import com.abdullah.usicotask.model.requests.LoginData;
import com.abdullah.usicotask.model.requests.RegisterRequest;
import com.abdullah.usicotask.model.responses.LoginResponse;
import com.abdullah.usicotask.model.responses.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface UsicoI {

    @POST("register")
    Call<RegisterResponse> register(@Body RegisterRequest registerRequest);

    @POST("login")
    Call<LoginResponse> login(@Body LoginData loginData);

    @GET("profile")
    Call<LoginResponse> getData(@Header("Authorization") String token);
}
