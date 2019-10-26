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
import com.example.engineeringtutorseries.Model.Constant;
import com.example.engineeringtutorseries.Model.Videos;

import java.util.ArrayList;

public class VideoActivity extends AppCompatActivity {

    private static final String TAG = "VideoActivity";
    private Context nContex;
    private ArrayList<String> titleList;
    private RecyclerView recyclerView;
    private ShareActionProvider mShareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

       Toolbar toolbar = findViewById(R.id.toolbar51);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("VIDEO TUTORIALS");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        nContex = VideoActivity.this;

        titleList = new ArrayList<>();
        titleList.add(Videos.TITLEA);
        titleList.add(Videos.TITLEB);
        titleList.add(Videos.TITLEC);
        titleList.add(Videos.TITLED);
        titleList.add(Videos.TITLEE);
        titleList.add(Videos.TITLEF);
        titleList.add(Videos.TITLEG);

        titleList.add(Videos.TITLEH);
        titleList.add(Videos.TITLEI);
        titleList.add(Videos.TITLEJ);
        titleList.add(Videos.TITLEK);
        titleList.add(Videos.TITLEL);
        titleList.add(Videos.TITLEM);
        titleList.add(Videos.TITLEN);
        titleList.add(Videos.TITLEO);
        titleList.add(Videos.TITLEP);


        recyclerView = findViewById(R.id.recyclerView2);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(nContex, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        VideoAdapter videoAdapter = new VideoAdapter(nContex, titleList, new TitleClickListener() {
            @Override
            public void onItemClick(View itemview, int position) {
                Toast.makeText(nContex, "WELCOME" + position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(VideoActivity.this, VideoDetailActivity.class);
                intent.putExtra("titles", titleList.get(position));
                startActivity(intent);

            }
        });
        recyclerView.setAdapter(videoAdapter);
    }

    public void Calculator(View view) {
    }
}
