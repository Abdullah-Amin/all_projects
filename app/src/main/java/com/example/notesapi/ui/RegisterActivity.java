package com.example.notesapi.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.notesapi.R;
import com.example.notesapi.network.NotesApisI;
import com.example.notesapi.requests.RegisterRequest;
import com.example.notesapi.responses.RegisterResponse;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity {

    private static final String TAG = "RegisterActivity";

    NotesApisI notesApisI;

    String token;

    private TextInputLayout editTextName, editTextEmail;

    TextInputLayout editTextPassword, editTextConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextName = findViewById(R.id.register_et_name);
        editTextEmail = findViewById(R.id.register_et_email);
        editTextPassword = findViewById(R.id.register_et_password);
        editTextConfirmPassword = findViewById(R.id.register_et_confirm_password);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://notes.amirmohammed.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        notesApisI = retrofit.create(NotesApisI.class);
    }

    public void Register(View view) {

        String name = editTextName.getEditText().getText().toString();
        String email = editTextEmail.getEditText().getText().toString();
        String password  = editTextPassword.getEditText().getText().toString().trim();
        String confirmPassword = editTextConfirmPassword.getEditText().getText().toString().trim();

        if(name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()){
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setName(name);
        registerRequest.setEmail(email);
        registerRequest.setPassword(password);
        registerRequest.setConfirmPassword(confirmPassword);

        Log.i(TAG, "Register: "+ registerRequest.toString());

        notesApisI.register(registerRequest).enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if(response.body().isState()){
                    Log.i(TAG, "onResponse: account created");
                    startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                    finish();
                }
                else{
                    Log.i(TAG, "onResponse: failed to create account "+ response.body().getErrors());

                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                String error = t.getLocalizedMessage();
                Log.i(TAG, "onFailure: "+ error);
            }
        });
    }
}