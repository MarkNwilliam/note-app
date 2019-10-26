package com.example.engineeringtutorseries;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class Edit extends AppCompatActivity {

TextView Detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Detail = findViewById(R.id.detailsOfNote);

        Intent i = getIntent();
        long id = i.getLongExtra("ID",0);

      NoteDatabase db = new NoteDatabase(this);

       Note note =  db.getNote(id);

       getSupportActionBar().setTitle(note.getTitle());
Detail.setText(note.getContent());

      Toast.makeText(this, "ID ->" + id, Toast.LENGTH_SHORT).show();
       // Log.d("Inserted", "ID ->"+ ID);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
