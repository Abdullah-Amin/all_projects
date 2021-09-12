package com.abdullah.usicotask.ui.register;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abdullah.usicotask.R;
import com.abdullah.usicotask.databinding.FragmentRegisterBinding;
import com.abdullah.usicotask.model.RetrofitClient;
import com.abdullah.usicotask.model.requests.RegisterRequest;
import com.abdullah.usicotask.model.responses.RegisterResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterFragment extends Fragment {

    FragmentRegisterBinding binding;
    NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setEmail(binding.fragmentRegisterEmailEt.getText().toString());
        registerRequest.setPassword(binding.fragmentRegisterPasswordEt.getText().toString());
        registerRequest.setName(binding.fragmentRegisterNameEt.getText().toString());
        registerRequest.setPhone(binding.fragmentRegisterPhoneEt.getText().toString());

        binding.fragmentRegisterRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetrofitClient.getClient().register(registerRequest)
                        .enqueue(new Callback<RegisterResponse>() {
                            @Override
                            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {

                                navController.navigate(R.id.action_registerFragment_to_profileFragment);
                            }

                            @Override
                            public void onFailure(Call<RegisterResponse> call, Throwable t) {

                            }
                        });
            }
        });



    }
}