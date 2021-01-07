package com.builder.yiban;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.FileNotFoundException;

public class ShowActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_activity);
        ImageView  show_image= findViewById(R.id.show_image);
        try {
            show_image.setImageBitmap(BitmapFactory.decodeStream(openFileInput("xg.jpg")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
