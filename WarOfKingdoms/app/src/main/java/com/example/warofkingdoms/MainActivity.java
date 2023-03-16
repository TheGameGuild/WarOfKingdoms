package com.example.warofkingdoms;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    Thread background = new Thread(() -> {
        try {
            // Thread sleeps
            Thread.sleep(4500);

            // After slpeeping redirect to home page
            Intent i = new Intent(MainActivity.this, HomePage.class);
            startActivity(i);

            // End activity
            finish();
        } catch (Exception e) {
            e.printStackTrace();
        }
    });


}