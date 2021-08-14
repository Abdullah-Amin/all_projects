package com.example.notesapi.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.notesapi.R;
import com.example.notesapi.network.NotesApisI;
import com.example.notesapi.requests.NoteRequest;
import com.example.notesapi.requests.LoginRequest;
import com.example.notesapi.requests.RegisterRequest;
import com.example.notesapi.responses.NoteResponse;
import com.example.notesapi.responses.LoginResponse;
import com.example.notesapi.responses.Notes;
import com.example.notesapi.responses.NotesResponse;
import com.example.notesapi.responses.RegisterResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    NotesApisI notesApisI;

    RecyclerView noteRecyclerView;

    List<Notes> notesList = new ArrayList<>();

    NotesAdapter notesAdapter;

    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noteRecyclerView = findViewById(R.id.main_recycler_view);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://notes.amirmohammed.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        notesApisI = retrofit.create(NotesApisI.class);

        token = getIntent().getStringExtra("token");

        //login();

        getNotes();

        notesAdapter = new NotesAdapter(notesList);
        noteRecyclerView.setAdapter(notesAdapter);
        notesAdapter.notifyDataSetChanged();

    }

    void login(){
//        String email = editTextEmail.getText().toString().trim();
//        String password = editTextPassword.getText().toString().trim();

//        if(email.isEmpty() || password.isEmpty()){
//            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
//            return;
//        }

//        LoginRequest loginRequest = new LoginRequest();
//        loginRequest.setEmail("a@a.a");
//        loginRequest.setPassword("a");
//
//        notesApisI.login(loginRequest).enqueue(new Callback<LoginResponse>() {
//            @Override
//            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
//                if(response.body().isState()){
//                    Log.i(TAG, "onResponse: logged in "+ response.body().getMessage());
//                    token = "Bearer " + response.body().getAccessToken();
//                }
//                else{
//                    Log.i(TAG, "onResponse: could not login");
//                }
//            }
//
//            @Override
//            public void onFailure(Call<LoginResponse> call, Throwable t) {
//                Log.i(TAG, "onFailure: "+ t.getLocalizedMessage());
//            }
//        });
    }

//    private void editNote() {
//        notesApisI.editNote(28, token, noteRequestMethod("ahmed", "saber")).enqueue(new Callback<NoteResponse>() {
//            @Override
//            public void onResponse(Call<NoteResponse> call, Response<NoteResponse> response) {
////                assert response.body() != null;
//                if(response.body().isState()){
//                    Log.i(TAG, "onResponse: note edited "+ response.body().toString());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<NoteResponse> call, Throwable t) {
//                Log.i(TAG, "onFailure: "+ t.getLocalizedMessage());
//            }
//        });
//    }

    private void addNotes() {
        NoteRequest noteRequest = new NoteRequest();
        noteRequest.setTitle("abdullah");
        noteRequest.setBody("Abdullah Amin Saber");
        notesApisI.addNote(noteRequest, token).enqueue(new Callback<NoteResponse>() {
            @Override
            public void onResponse(Call<NoteResponse> call, Response<NoteResponse> response) {
                if(response.body().isState()){
                    Log.i(TAG, "onResponse: note added "+response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<NoteResponse> call, Throwable t) {
                Log.i(TAG, "onFailure: "+ t.getLocalizedMessage());
            }
        });
    }

    //"eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiMWVkMzVmZWQ2ZTI4NTU0YzA0NjlkYzhlNWNlMTc2Mzg4YmIxN2Y1MmJjMTAwZmY0ZGViMTMyMDhiNmM3NzZkMzZiM2U1ODA1YmFhNzgzNjYiLCJpYXQiOiIxNjEzNDIzNzg1LjQwNDQ4OSIsIm5iZiI6IjE2MTM0MjM3ODUuNDA0NDk0IiwiZXhwIjoiMTY0NDk1OTc4NS40MDA4MzYiLCJzdWIiOiIyNCIsInNjb3BlcyI6W119.kGPwgmUTcNuF9oxyJBt0uO_ARWxww9sxqIdkkVnWeiwANTMI1YVVVcV62SzIy3orl6IbJlqy8V8W_mUqNBfyAkXX5zSllTiAuCY8LJ1BaVHkyoJa0eK8eT_VmY8keeTtAiLVNpLcR7M_Nb22Rh3Kz1MVHwCDyFSMcj8DdwP11qtSqupCyTaavZ2b2eYbaz7h8NrshDzlgR69YDqNaqkA4YTSSjHFusiwlX86VVEqYK4AXkTZpsnGZ2Pc2Z-zGsZXuMdUF3UE8R0coXj-KlapZrRSfXTd9tTLGfk5ROsYrbpMNHmxJ_WuYjhRgEyrBlM5bNoGrRJXWjXTY-WIktiL8CQWISjk-mGi6Xro7XJvv3Cdq6miCMCBOKzSPs9noWuSGiXjFlxnPjQidJFP2ffU5iF_UKp7WNU560-dCQ-5qVqsxVNcPaPaqHq27NxybS1hRRCbFMR93bCCr8j_ALyi2QuS3Lsp-84luewut2g-yMIrDOpDCEqErj4Lxn0iYsaPFIdSQRBYOKIO-41YKK5f9dyQRV6sNgmaWvIU4M4rlWKPtiZ5qVV4MWAnGNUnRelmHXFWycNZgdRlK_qf8oG7XQVnupRXHE1BTQbkz-FWwkUIz1HcUVIIVAyOvxMc3N1HuqTFHYPOyBxubWxCQt3e7qClyIDABFi9q3-wSp1bc0k"

    private void getNotes() {
        notesApisI.getNotes(token)
                .enqueue(new Callback<NotesResponse>() {
            @Override
            public void onResponse(Call<NotesResponse> call, Response<NotesResponse> response) {
                Log.i(TAG, "onResponse: "+ response.body().isState());
                if(response.body().isState()){

                    notesList = response.body().getNoteDetailResponseList();

                    Log.i(TAG, "onResponse: "+notesList);
                    Log.i(TAG, "onResponse: "+ response.body().getNoteDetailResponseList().size());
                    Log.i(TAG, "onResponse: "+ response.body().getNoteDetailResponseList().toString());
                }
            }

            @Override
            public void onFailure(Call<NotesResponse> call, Throwable t) {
                Log.i(TAG, "onFailure: "+ t.getLocalizedMessage());
            }
        });
    }

    private NoteRequest noteRequestMethod(String title, String body){
        NoteRequest noteRequest = new NoteRequest();
        noteRequest.setTitle(title);
        noteRequest.setBody(body);
        return  noteRequest;
    }

    public void addNotes(View view) {

        AddNoteDialogFragment addNoteDialogFragment = new AddNoteDialogFragment(addI);
        getSupportFragmentManager().beginTransaction().add(addNoteDialogFragment, "addDialogFragment").commit();
    }

    AddI addI = new AddI() {
        @Override
        public void onAdd(Notes notes) {
            NoteRequest noteRequest = new NoteRequest();
            noteRequest.setTitle(notes.getTitle());
            noteRequest.setBody(notes.getBody());
            notesApisI.addNote(noteRequest, token).enqueue(new Callback<NoteResponse>() {
                @Override
                public void onResponse(Call<NoteResponse> call, Response<NoteResponse> response) {
                    if(response.body().isNoteState()){
                        Log.i(TAG, "onResponse: note added "+response.body().toString());

                        notesList.clear();
                        NoteResponse noteResponse = response.body();
                        notesList = noteResponse.getNoteDetailResponseList();

                        Log.i(TAG, "onResponse: "+notesList);
                        Log.i(TAG, "onResponse: "+ response.body().getNoteDetailResponseList().size());

                        //getNotes();
                    }
                }

                @Override
                public void onFailure(Call<NoteResponse> call, Throwable t) {
                    Log.i(TAG, "onFailure: "+ t.getLocalizedMessage());
                }
            });
        }
    };
}