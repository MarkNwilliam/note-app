package com.example.engineeringtutorseries;

import java.util.List;

public class Note  {
    private long id;
    private String title;
    private String content;
    private String date;
    private String time;
    private String category;

    Note() {
    }

    Note( String title, String content, String date, String time, String category) {

        this.title = title;
        this.content = content;
        this.date = date;
        this.time = time;
        this.category = category;
    }


    Note(long id, String title, String content, String date, String time, String category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.time = time;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}















































