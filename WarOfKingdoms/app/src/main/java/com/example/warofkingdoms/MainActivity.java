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
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.jugarbtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openjuego();
            }
        });
    }
    public void openjuego(){
        Intent intent = new Intent(this, juego.class);
        startActivity(intent);
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
