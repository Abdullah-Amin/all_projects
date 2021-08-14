package com.example.insan;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.util.ArrayList;

public class DevelopFragment extends Fragment {

    ArrayList<Data> dataArrayList = new ArrayList<>();
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_develop, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);

        Adapter adapter = new Adapter(requireContext(),dataArrayList);
        recyclerView.setAdapter(adapter);

        Data data1 = new Data("drawing", "5 days", "enroll");
        dataArrayList.add(data1);
        Data data2 = new Data("icdl", "4 days", "enroll");
        dataArrayList.add(data2);
        Data data3 = new Data("handmade", "2 days", "enroll");
        dataArrayList.add(data3);
    }
}