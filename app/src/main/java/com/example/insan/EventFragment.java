package com.example.insan;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class EventFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<EventData> eventDataArrayList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_event, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.event_recyclerView);
        EventAdapter eventAdapter = new EventAdapter(requireContext(), eventDataArrayList);
        recyclerView.setAdapter(eventAdapter);

        EventData data1 = new EventData("apply", "Queen");
        eventDataArrayList.add(data1);
        EventData data2 = new EventData("apply", "Marathon");
        eventDataArrayList.add(data2);
        EventData data3 = new EventData("apply", "Football");
        eventDataArrayList.add(data3);
        EventData data4 = new EventData("apply", "hell");
        eventDataArrayList.add(data4);
    }
}