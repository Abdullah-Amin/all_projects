package com.abdullah.usicotask.ui.profile;

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

import com.abdullah.usicotask.R;
import com.abdullah.usicotask.databinding.FragmentProfileBinding;

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

        Log.i(TAG, "onViewCreated: "+ getArguments().getBundle("name"));

        if(getArguments() != null){
            binding.fragmentLogoutEmailTv.setText(getArguments().getString("email"));
            binding.fragmentLogoutPhoneTv.setText(getArguments().getInt("phone"));
            binding.fragmentLogoutNameTv.setText(getArguments().getString("name"));
            binding.fragmentLogoutIdTv.setText(getArguments().getInt("id"));
        }

        binding.fragmentLogutLogoutBtn.setOnClickListener(v -> {
          navController.navigate(R.id.action_profileFragment_to_loginFragment);
        });
    }
}