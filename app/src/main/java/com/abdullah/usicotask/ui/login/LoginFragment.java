package com.abdullah.usicotask.ui.login;

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
import com.abdullah.usicotask.databinding.FragmentLoginBinding;
import com.abdullah.usicotask.model.requests.LoginRequest;

import java.util.Objects;

public class LoginFragment extends Fragment {

    FragmentLoginBinding binding;
    NavController navController;
    LoginViewModel viewModel;

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

        viewModel = new ViewModelProvider(requireActivity(), new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                return null;
            }
        }).get(LoginViewModel.class);

        LoginRequest loginRequest = new LoginRequest();

        loginRequest.setEmail(Objects.requireNonNull(binding.fragmentLoginEmailEt.getText()).toString());
        loginRequest.setPassword(Objects.requireNonNull(binding.fragmentLoginPasswordEt.getText()).toString());

        binding.fragmentLoginSigninBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.login();
            }
        });
    }
}