package com.example.engineeringtutorseries;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

public class introActivity extends AppCompatActivity {

    TextView text1,text2;
    ImageView image;

    private static int timeout = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text3);
        image = findViewById(R.id.image);

        Animation animation = AnimationUtils.loadAnimation(introActivity.this,R.anim.anim);
        image.startAnimation(animation);
        text2.startAnimation(animation);
        text1.startAnimation(animation);

Handler handler = new Handler();
handler.postDelayed(new Runnable() {
    @Override
    public void run() {

        Intent intent = new Intent(introActivity.this,MainActivity.class);
        startActivity(intent);
        finish();

    }
},timeout);
    }
}
