package com.example.notesapi.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NotesResponse {

    @SerializedName("state")
    @Expose
    private boolean state;

    @SerializedName("notes")
    @Expose
    private List<Notes> noteDetailResponseList;

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public List<Notes> getNoteDetailResponseList() {
        return noteDetailResponseList;
    }

    public void setNoteDetailResponseList(List<Notes> notesList) {
        this.noteDetailResponseList = notesList;
    }
}
