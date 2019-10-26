package com.example.engineeringtutorseries;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ShareActionProvider;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.engineeringtutorseries.Interface.TitleClickListener;
import com.example.engineeringtutorseries.Model.Constant;

import java.util.ArrayList;

public class TitleActivity extends AppCompatActivity {

    Toolbar toolbar;
    private static final String TAG = "MainActivity";
    private Context nContex;
    private ArrayList<String> titleList;
    private RecyclerView recyclerView;
    private ShareActionProvider mShareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);
        toolbar = findViewById(R.id.toolbar4);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("LECTURE NOTES");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        nContex = TitleActivity.this;

        titleList = new ArrayList<>();
        titleList.add(Constant.TITLEA);
        titleList.add(Constant.TITLEB);
        titleList.add(Constant.TITLEC);
        titleList.add(Constant.TITLED);
        titleList.add(Constant.TITLEE);
        titleList.add(Constant.TITLEF);
        titleList.add(Constant.TITLEG);

        titleList.add(Constant.TITLEH);
        titleList.add(Constant.TITLEI);
        titleList.add(Constant.TITLEJ);
        titleList.add(Constant.TITLEK);
        titleList.add(Constant.TITLEL);
        titleList.add(Constant.TITLEM);
        titleList.add(Constant.TITLEN);
        titleList.add(Constant.TITLEO);
        titleList.add(Constant.TITLEP);


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(nContex, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        TitleAdapter titleAdapter = new TitleAdapter(nContex, titleList, new TitleClickListener() {
            @Override
            public void onItemClick(View itemview, int position) {
                Toast.makeText(nContex, "WELCOME" + position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(TitleActivity.this, LectureNotesActivity.class);
                intent.putExtra("titles", titleList.get(position));
                startActivity(intent);

            }
        });
        recyclerView.setAdapter(titleAdapter);
    }



}
