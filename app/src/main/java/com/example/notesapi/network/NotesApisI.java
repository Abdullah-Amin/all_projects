package com.example.notesapi.network;

import com.example.notesapi.requests.NoteRequest;
import com.example.notesapi.requests.LoginRequest;
import com.example.notesapi.requests.RegisterRequest;
import com.example.notesapi.responses.NoteResponse;
import com.example.notesapi.responses.LoginResponse;
import com.example.notesapi.responses.NotesResponse;
import com.example.notesapi.responses.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface NotesApisI {

    @POST("public/api/register")
    Call<RegisterResponse> register(@Body RegisterRequest registerRequest);

    @POST("public/api/login")
    Call<LoginResponse> login(@Body LoginRequest loginRequest);

    @GET("public/api/notes")
    Call<NotesResponse> getNotes(@Header("Authorization") String token);

    @POST("public/api/notes/add")
    Call<NoteResponse> addNote(@Body NoteRequest noteRequest,
                               @Header("Authorization") String token);

//    @POST("public/api/notes/edit/{noteId}")
//    Call<NoteResponse> editNote(@Path ("noteId") int noteId,
//                                @Header("Authorization") String token,
//                                @Body NoteRequest noteRequest);
//
//    @GET("public/api/notes/edit/{noteId}")
//    Call<NoteResponse> deleteNote(@Path("noteId") int noteId,
//                                  @Header("Authorization") String token);
}
