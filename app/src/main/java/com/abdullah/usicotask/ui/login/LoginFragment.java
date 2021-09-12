package com.abdullah.usicotask.ui.login;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abdullah.usicotask.R;
import com.abdullah.usicotask.databinding.FragmentLoginBinding;
import com.abdullah.usicotask.model.RetrofitClient;
import com.abdullah.usicotask.model.requests.LoginRequest;
import com.abdullah.usicotask.model.responses.LoginResponse;
import com.abdullah.usicotask.network.UsicoI;
import com.abdullah.usicotask.ui.main.MainActivity;
import com.abdullah.usicotask.ui.profile.ProfileFragment;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginFragment extends Fragment {

    FragmentLoginBinding binding;
    NavController navController;
    LoginRequest loginRequest;

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

        navController = Navigation.findNavController(view);

        binding.fragmentLoginSigninBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loginRequest = new LoginRequest();
                loginRequest.setEmail(binding.fragmentLoginEmailEt.getText().toString());
                loginRequest.setPassword(binding.fragmentLoginPasswordEt.getText().toString());

                RetrofitClient.getClient().login(loginRequest)
                        .enqueue(new Callback<LoginResponse>() {
                            @Override
                            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                                if(response.isSuccessful()){
                                    Bundle bundle = new Bundle();
                                    bundle.putString("email", response.body().getLoginRequest().getEmail());
                                    bundle.putInt("id", response.body().getLoginRequest().getId());
                                    bundle.putInt("phone", response.body().getLoginRequest().getPhone());
                                    bundle.putString("name", response.body().getLoginRequest().getName());
                                    MainActivity mainActivity = (MainActivity)getActivity();
                                    mainActivity.saveData(bundle);
                                }
                                else Log.i(TAG, "onResponse: -------------");

                            }

                            @Override
                            public void onFailure(Call<LoginResponse> call, Throwable t) {

                            }
                        });

                Log.i(TAG, "onClick: "+ loginRequest.getEmail() + "----"+ loginRequest.getPassword());
                navController.navigate(R.id.action_loginFragment_to_profileFragment);


            }
        });

        binding.fragmentLoginSignupTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                navController.navigate(R.id.action_loginFragment_to_registerFragment);
            }
        });
    }
}