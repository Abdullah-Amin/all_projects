package com.example.notesapi.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegisterResponse {

    @SerializedName("state")
    @Expose
    private boolean state;

    @SerializedName("errors")
    @Expose
    private String errors;

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "RegisterResponse{" +
                "state=" + state +
                ", errors='" + errors + '\'' +
                '}';
    }
}
