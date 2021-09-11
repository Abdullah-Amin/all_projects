package com.abdullah.usicotask.ui.login;

import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.abdullah.usicotask.model.RetrofitClient;
import com.abdullah.usicotask.model.requests.LoginRequest;
import com.abdullah.usicotask.model.responses.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends ViewModel {

    MutableLiveData<LoginResponse> loginRequestMutableLiveData = new MutableLiveData<>();

    public void login(){

        RetrofitClient.getClient().login(new LoginRequest()).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                if(response.isSuccessful()){
                    loginRequestMutableLiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
            }
        });
    }
}
