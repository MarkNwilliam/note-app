package com.example.engineeringtutorseries;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Intro2Activity extends AppCompatActivity {

   ImageView userPhoto;
static int FReqcode = 1;
    static int REQUESCODE = 1;
    Uri pickedTmgurl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro2);

        userPhoto = findViewById(R.id.User_Image);

        userPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Build.VERSION.SDK_INT >= 22){
                    checkAskRequestForPermission();
                }
                else{
                    openGallery();
                }

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK && resultCode ==REQUESCODE && data != null){

            pickedTmgurl = data.getData();
            userPhoto.setImageURI(pickedTmgurl);


        }
    }



    private void checkAskRequestForPermission() {

        if(ContextCompat.checkSelfPermission(Intro2Activity.this,Manifest.permission.READ_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED)
        {
            if(ActivityCompat.shouldShowRequestPermissionRationale(Intro2Activity.this, Manifest.permission.READ_EXTERNAL_STORAGE)){
                Toast.makeText(Intro2Activity.this,"Please accept the required permissions",Toast.LENGTH_SHORT).show();
            }
            else{
                ActivityCompat.requestPermissions(Intro2Activity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},FReqcode);
            }
        }
        else

            openGallery();




    }
    private void openGallery() {
        Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
        galleryIntent.setType("Image/*");
        startActivityForResult(galleryIntent,REQUESCODE);

    }
}
