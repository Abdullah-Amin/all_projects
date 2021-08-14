package com.example.notesapi.requests;

import com.google.gson.annotations.SerializedName;

public class NoteRequest {

    @SerializedName("title")
    private String title;

    @SerializedName("body")
    private String body;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "NoteRequest{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
