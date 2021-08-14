package com.example.notesapi.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.notesapi.R;
import com.example.notesapi.responses.Notes;
import com.google.android.material.button.MaterialButton;

public class AddNoteDialogFragment extends DialogFragment {

    AddI addI;

    public AddNoteDialogFragment(AddI addI) {
        this.addI = addI;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_note_dialog, container, false);
    }

    EditText titleET, descriptionET;
    MaterialButton addBtn, cancelBtn;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        titleET = view.findViewById(R.id.title_note_dialog_et);
        descriptionET = view.findViewById(R.id.description_note_dialog_et);
        addBtn = view.findViewById(R.id.add_note_dialog_btn);
        cancelBtn = view.findViewById(R.id.cancel_note_dialog_btn);

        String title = titleET.getText().toString();
        String description = descriptionET.getText().toString();

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Notes notes = new Notes();
                notes.setTitle(title);
                notes.setBody(description);

               addI.onAdd(notes);
               dismiss();
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }
}