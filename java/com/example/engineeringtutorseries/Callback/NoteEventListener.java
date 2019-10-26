package com.example.engineeringtutorseries.Callback;

import com.example.engineeringtutorseries.Note;

import java.util.List;

public interface NoteEventListener {

    void onNoteClick(Note note);



    void onNoteLongClick(Note note);
}
