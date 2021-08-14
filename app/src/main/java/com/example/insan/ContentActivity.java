package com.example.insan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class ContentActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;
//    RecyclerView recyclerView;
//    ArrayList<Data> dataArrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        //recyclerView = findViewById(R.id.recyclerView);
        frameLayout = findViewById(R.id.frame);

//        Adapter adapter = new Adapter(ContentActivity.this, dataArrayList);
//        recyclerView.setAdapter(adapter);

        Data data1 = new Data("drawing", "5 days", "enroll");
        Data data2 = new Data("icdl", "4 days", "enroll");
        Data data3 = new Data("handmade", "2 days", "enroll");

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        //getSupportFragmentManager().beginTransaction().replace(R.id.frame, new DevelopFragment()).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {

                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.develop:
                                DevelopFragment developFragment = new DevelopFragment();
                                bottomNavigationView.setElevation(3);
                                getSupportFragmentManager().beginTransaction().replace(R.id.frame, developFragment).commit();
                                break;
                            case R.id.chat:
                                getSupportFragmentManager().beginTransaction().replace(R.id.frame, new ChatFragment()).commit();
                                break;
                            case R.id.jobs:
                                getSupportFragmentManager().beginTransaction().replace(R.id.frame, new JobsFragment()).commit();
                                break;
                            case R.id.event:
                                getSupportFragmentManager().beginTransaction().replace(R.id.frame, new EventFragment()).commit();
                                break;
                            default:
                                getSupportFragmentManager().beginTransaction().replace(R.id.frame, new MoreFragment()).commit();
                                break;
                        }
                        return true;
                    }
                });
    }
}