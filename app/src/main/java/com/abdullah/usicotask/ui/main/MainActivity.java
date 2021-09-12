package com.abdullah.usicotask.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.abdullah.usicotask.R;

public class MainActivity extends AppCompatActivity {

    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void saveData(Bundle bundle){
        this.bundle = bundle;
    }

    public Bundle getSavedData(){
        return bundle;
    }
}