package com.abdullah.usicotask.ui.register;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.abdullah.usicotask.model.RetrofitClient;
import com.abdullah.usicotask.model.requests.RegisterRequest;
import com.abdullah.usicotask.model.responses.RegisterResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterViewModel extends ViewModel {

    MutableLiveData<RegisterResponse> registerResponseMutableLiveData = new MutableLiveData<>();

    public void register(){

        RetrofitClient.getClient().register(new RegisterRequest())
                .enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                registerResponseMutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {

            }
        });
    }
}
