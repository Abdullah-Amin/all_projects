package com.abdullah.usicotask.network;

import com.abdullah.usicotask.model.requests.LoginRequest;
import com.abdullah.usicotask.model.responses.LoginResponse;
import com.abdullah.usicotask.model.requests.RegisterRequest;
import com.abdullah.usicotask.model.responses.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UsicoI {

    @POST("register")
    Call<RegisterResponse> register(@Body RegisterRequest registerRequest);

    @POST("login")
    Call<LoginResponse> login(@Body LoginRequest loginRequest);
}
