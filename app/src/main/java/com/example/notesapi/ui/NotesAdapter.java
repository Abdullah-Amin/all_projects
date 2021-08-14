package com.example.notesapi.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notesapi.R;
import com.example.notesapi.responses.Notes;
import com.google.android.material.button.MaterialButton;

import java.util.Calendar;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesHolder> {

    List<Notes> notesList;

    public NotesAdapter(List<Notes> notesList) {
        this.notesList = notesList;
    }

    @NonNull
    @Override
    public NotesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NotesHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NotesHolder holder, int position) {
        Notes notes = notesList.get(position);

        holder.titleTV.setText(notes.getTitle());
        holder.descriptionTV.setText(notes.getBody());
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    public class NotesHolder extends RecyclerView.ViewHolder{

        TextView titleTV, descriptionTV, createdAtTV;
        MaterialButton updateBtn, deleteBtn;

        public NotesHolder(@NonNull View itemView) {
            super(itemView);

            titleTV = itemView.findViewById(R.id.item_note_title);
            descriptionTV = itemView.findViewById(R.id.item_note_description);
            createdAtTV = itemView.findViewById(R.id.item_note_create_at);

            updateBtn = itemView.findViewById(R.id.item_note_btn_update);
            deleteBtn = itemView.findViewById(R.id.item_note_btn_delete);
        }
    }
}

