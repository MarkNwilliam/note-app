package com.example.engineeringtutorseries;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import com.example.engineeringtutorseries.Callback.NoteEventListener;

import java.util.List;


public class WriteNotesActivity extends AppCompatActivity {

    Toolbar toolbar;
    private static final String TAG ="WriteNotesActivity";
    Adapter adapter;
  List<Note> notes;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_notes);
        toolbar = findViewById(R.id.toolbar2);

        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Write Your Notes");


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NoteDatabase db = new NoteDatabase(this);

      notes =  db.getNotes();

        recyclerView = findViewById(R.id.setOfNotes);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        adapter = new Adapter(this,notes);

//this.adapter.setNoteClickListener(this);

      //  this.adapter.setListener(this);

        recyclerView.setAdapter(adapter);

    }

    public void addnote(View view) {

        startActivity(new Intent(getApplicationContext(),AddNoteActivity.class));


    }

    public void delete_note(View view) {

    }


}
