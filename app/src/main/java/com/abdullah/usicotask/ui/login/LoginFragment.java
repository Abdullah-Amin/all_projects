package com.abdullah.usicotask.ui.login;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.abdullah.usicotask.R;
import com.abdullah.usicotask.databinding.FragmentLoginBinding;
import com.abdullah.usicotask.model.RetrofitClient;
import com.abdullah.usicotask.model.requests.LoginData;
import com.abdullah.usicotask.model.responses.DData;
import com.abdullah.usicotask.model.responses.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginFragment extends Fragment {

    FragmentLoginBinding binding;
    NavController navController;
    LoginData loginData;
    public static String token;

    private static final String TAG = "LoginFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loginData = new LoginData();
        loginData.setEmail(binding.fragmentLoginEmailEt.getText().toString());
        loginData.setPassword(binding.fragmentLoginPasswordEt.getText().toString());

        RetrofitClient.getClient().login(loginData)
                .enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        Toast.makeText(getActivity(), response.body().getMessage() , Toast.LENGTH_SHORT).show();

                        if(response.body().getStatus()){
                            DData DData = response.body().getDData();
                            token = DData.getToken();
                            navController = Navigation.findNavController(view);

                            binding.fragmentLoginSigninBtn.setOnClickListener(v-> {
                                Log.i(TAG, "onResponse: "+ response.body().toString());
                                navController.navigate(R.id.action_loginFragment_to_profileFragment);

                            });
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        Log.i(TAG, "onFailure: -------------");
                    }
                });
    }
}

