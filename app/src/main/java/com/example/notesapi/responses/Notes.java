package com.example.notesapi.responses;

import com.google.gson.annotations.SerializedName;

public class Notes {

    @SerializedName("id")
    private int id;

    @SerializedName("body")
    private String body;

    @SerializedName("title")
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
