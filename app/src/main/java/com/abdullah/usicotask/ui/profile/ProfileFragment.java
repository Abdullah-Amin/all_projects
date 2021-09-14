package com.abdullah.usicotask.ui.profile;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abdullah.usicotask.R;
import com.abdullah.usicotask.databinding.FragmentProfileBinding;
import com.abdullah.usicotask.model.RetrofitClient;
import com.abdullah.usicotask.model.responses.LoginResponse;
import com.abdullah.usicotask.ui.login.LoginFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileFragment extends Fragment {

    FragmentProfileBinding binding;
    NavController navController;

    private static final String TAG = "ProfileFragment";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

//        Log.i(TAG, "onViewCreated: "+ getArguments().getBundle("name"));

        RetrofitClient.getClient().getData(LoginFragment.token)
                .enqueue(new Callback<LoginResponse>() {

                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        if(response.isSuccessful()){

                            binding.fragmentLogoutNameTv.setText(response.body().getDData().getName());
                            binding.fragmentLogoutIdTv.setText(response.body().getDData().getId());
                            binding.fragmentLogoutPhoneTv.setText(response.body().getDData().getPhone());
                            binding.fragmentLogoutEmailTv.setText(response.body().getDData().getEmail());
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {

                    }
                });

        binding.fragmentLogutLogoutBtn.setOnClickListener(v -> {
          navController.navigate(R.id.action_profileFragment_to_loginFragment);
        });
    }
}