package com.example.maketwithxd;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

public class FourthFormActivity extends AppCompatActivity {
    private static final int REQUEST_ID_IMAGE_CAPTURE = 1313;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_form);
        ImageView img_friend = (ImageView) findViewById(R.id.img_friend4);
        img_friend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FourthFormActivity.this,SecondFormActivity.class);
                startActivity(intent);
            }
        });
        ImageView img_exit = (ImageView) findViewById(R.id.img_exit4);
        img_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FourthFormActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        ImageView camera = (ImageView)findViewById(R.id.img_camera4);
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