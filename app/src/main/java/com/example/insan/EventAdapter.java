package com.example.insan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {

    Context context;
    ArrayList<EventData> eventDataArrayList;

    public EventAdapter(Context context, ArrayList<EventData> eventDataArrayList) {
        this.context = context;
        this.eventDataArrayList = eventDataArrayList;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.event_item, parent, false);
        EventViewHolder eventViewHolder = new EventViewHolder(view);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        EventData eventData = eventDataArrayList.get(position);

        holder.eventTextView.setText(eventData.getTextView_text());
        holder.eventButton.setText(eventData.getBtn_text());
    }

    @Override
    public int getItemCount() {
        return eventDataArrayList.size();
    }

    public class EventViewHolder extends RecyclerView.ViewHolder{
        Button eventButton;
        TextView eventTextView;
        public EventViewHolder(@NonNull View itemView) {
            super(itemView);
            eventButton = itemView.findViewById(R.id.event_btn);
            eventTextView = itemView.findViewById(R.id.event_txt);
        }
    }
}
