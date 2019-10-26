package com.example.engineeringtutorseries;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class QuestionDetailActivity extends AppCompatActivity {

    private static final String TAG = "Description";
    private Context context;
    private WebView webView;
    private Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_detail);
        Toolbar toolbar = findViewById(R.id.toolbar32);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //      MobileAds.initialize(this,
        //            "ca-app-pub-7163440324211024~9762673368");

        //  mAdView = findViewById(R.id.adView);
        //AdRequest adRequest = new AdRequest.Builder().build();
        //mAdView.loadAd(adRequest);

        context = QuestionDetailActivity.this;
        webView = findViewById(R.id.webView32);
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
