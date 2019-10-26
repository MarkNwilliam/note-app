package com.example.engineeringtutorseries;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class VideoDetailActivity extends AppCompatActivity {
    private static final String TAG = "Description";
    private Context context;
    private WebView webView;
    private Bundle extras;

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_detail);

        Toolbar toolbar = findViewById(R.id.toolbar42);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //      MobileAds.initialize(this,
        //            "ca-app-pub-7163440324211024~9762673368");

        //  mAdView = findViewById(R.id.adView);
        //AdRequest adRequest = new AdRequest.Builder().build();
        //mAdView.loadAd(adRequest);

        context = VideoDetailActivity.this;
        webView = findViewById(R.id.webView6);
        extras = getIntent().getExtras();

        if(extras!=null){
            String data = extras.getString("titles");

            Log.d(TAG, "onCreate the  data is" + data);
            String url = "file:///android_asset/"+data+".html";
            webView.loadUrl(url);
            WebSettings websettings = webView.getSettings();
            websettings.setBuiltInZoomControls(true);
            // websettings.setBuiltInZoomControls(false);




            toolbar.setTitle(data.replace("_",""));
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

        }
    }


    public void Calculator(View view) {
        startActivity(new Intent(getApplicationContext(),CalculatorActivity.class));
    }
}
