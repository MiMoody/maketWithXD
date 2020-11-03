package com.example.maketwithxd;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SecondFormActivity extends AppCompatActivity  {
    private static final int REQUEST_ID_IMAGE_CAPTURE = 1313;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_form);
        ImageView img_exit = (ImageView) findViewById(R.id.img_exit);
        img_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondFormActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        ImageView img_p = (ImageView) findViewById(R.id.img_picture);
        img_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_4 = new Intent(SecondFormActivity.this,FourthFormActivity.class);
                startActivity(intent_4);
            }
        });
        ImageView camera = (ImageView)findViewById(R.id.img_camera);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,REQUEST_ID_IMAGE_CAPTURE);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (REQUEST_ID_IMAGE_CAPTURE == requestCode) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
        }
    }



}