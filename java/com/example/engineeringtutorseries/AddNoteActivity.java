package com.example.engineeringtutorseries;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Calendar;
public class AddNoteActivity extends AppCompatActivity {
    EditText noteTitle, noteDetails, noteCategory;
    Toolbar toolbar;
    String todaysdate;
    String CurrentTime;
    Calendar c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        noteDetails = findViewById(R.id.notes);
        noteTitle = findViewById(R.id.title);
        noteCategory = findViewById(R.id.Category);
        toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("New Note");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        noteTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length()!=0){
                    getSupportActionBar().setTitle(charSequence);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        c = Calendar.getInstance();
        todaysdate = c.get(Calendar.YEAR)+"/"+(c.get(Calendar.MONTH)+1)+"/"+c.get(Calendar.DAY_OF_MONTH);
        CurrentTime = pad(c.get(Calendar.HOUR))+"/"+pad(c.get(Calendar.MINUTE))+"/"+pad(c.get(Calendar.SECOND));
        Log.d("Calender", "Date and Time: "+ todaysdate + " and " + CurrentTime);
    }
    private String pad(int s) {
        if(s < 10)
            return "0"+s;
            return  String.valueOf(s);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.addnote,menu);
        return true; }
        @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.save){
            Note note = new Note(noteTitle.getText().toString(),noteDetails.getText().toString(),todaysdate,CurrentTime,noteCategory.getText().toString());
           NoteDatabase db = new NoteDatabase(this);

            db.addNote(note);
            Toast.makeText(this, "You have saved ", Toast.LENGTH_SHORT).show();
            goToMain();
        }
        if(item.getItemId() == R.id.delete){

            Toast.makeText(this, "Note not saved ", Toast.LENGTH_SHORT).show();
            onBackPressed();

        }
        return super.onOptionsItemSelected(item);
    }
    public void goToMain(){
        startActivity(new Intent(getApplicationContext(),WriteNotesActivity.class));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void Calculator(View view) {

        startActivity(new Intent(getApplicationContext(),CalculatorActivity.class));
    }
}