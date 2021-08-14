package com.example.notesapi.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("state")
    @Expose
    private boolean state;

    @SerializedName("access_token")
    @Expose
    private String accessToken;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("user")
    @Expose
    private UserResponse user;

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserResponse getUser() {
        return user;
    }

    public void setUser(UserResponse user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "state=" + state +
                ", accessToken='" + accessToken + '\'' +
                ", message='" + message + '\'' +
                ", user=" + user +
                '}';
    }
}
