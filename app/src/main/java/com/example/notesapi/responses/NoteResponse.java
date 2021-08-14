package com.example.notesapi.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NoteResponse extends NotesResponse {

    @SerializedName("state")
    @Expose
    private boolean noteState;

    public boolean isNoteState() {
        return noteState;
    }

    public void setNoteState(boolean state) {
        this.noteState = state;
    }

    @Override
    public String toString() {
        return "NoteResponse{" +
                "state=" + noteState +
                '}';
    }
}
