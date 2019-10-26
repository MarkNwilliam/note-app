package com.example.engineeringtutorseries;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ShareActionProvider;
import android.widget.Toast;

import com.example.engineeringtutorseries.Interface.TitleClickListener;
import com.example.engineeringtutorseries.Model.Questions;
import com.example.engineeringtutorseries.Model.Videos;

import java.util.ArrayList;

public class QuestionActivity extends AppCompatActivity {


    Toolbar toolbar;
    private static final String TAG = "MainActivity";
    private Context nContex;
    private ArrayList<String> titleList;
    private RecyclerView recyclerView;
    private ShareActionProvider mShareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        toolbar = findViewById(R.id.toolbar8);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("QUESTIONS");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nContex = QuestionActivity.this;

        titleList = new ArrayList<>();
        titleList.add(Questions.TITLEA);
        titleList.add(Questions.TITLEB);
        titleList.add(Questions.TITLEC);
        titleList.add(Questions.TITLED);
        titleList.add(Questions.TITLEE);
        titleList.add(Questions.TITLEF);
        titleList.add(Questions.TITLEG);

        titleList.add(Questions.TITLEH);
        titleList.add(Questions.TITLEI);
        titleList.add(Questions.TITLEJ);
        titleList.add(Questions.TITLEK);
        titleList.add(Questions.TITLEL);
        titleList.add(Questions.TITLEM);
        titleList.add(Questions.TITLEN);
        titleList.add(Questions.TITLEO);
        titleList.add(Questions.TITLEP);


        recyclerView = findViewById(R.id.recyclerView8);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(nContex, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        TitleAdapter titleAdapter = new TitleAdapter(nContex, titleList, new TitleClickListener() {
            @Override
            public void onItemClick(View itemview, int position) {
                Toast.makeText(nContex, "WELCOME" + position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(QuestionActivity.this,QuestionDetailActivity.class);
                intent.putExtra("titles", titleList.get(position));
                startActivity(intent);

            }
        });
        recyclerView.setAdapter(titleAdapter);
    }



}
