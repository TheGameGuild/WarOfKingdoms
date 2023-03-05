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


    com.example.warofkingdoms.manaSystem manaSystem = new manaSystem(10, 2);
}
class gameView extends SurfaceView implements Runnable {
    private Thread thread;
    private boolean isPlaying;
    private SurfaceHolder surfaceHolder;
    private Paint paint;

    public gameView(Context context) {
        super(context);
        surfaceHolder = getHolder();
        paint = new Paint();
    }

    @Override
    public void run() {
        while (isPlaying) {
            if (!surfaceHolder.getSurface().isValid())
                continue;

            Canvas canvas = surfaceHolder.lockCanvas();
            canvas.drawColor(Color.WHITE);
            paint.setColor(Color.BLACK);
            paint.setTextSize(50);
            canvas.drawText("Hello World", 100, 100, paint);
            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }

    public void resume() {
        isPlaying = true;
        thread = new Thread(this);
        thread.start();
    }

    public void pause() {
        isPlaying = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class attackMechanic extends AppCompatActivity {
    public attackMechanic(int i, int i1, int i2) {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        attackMechanic swordAttack = new attackMechanic(10, 20, 80);
        boolean isHit = swordAttack.isHit();
        boolean isCritical = swordAttack.isCriticalHit();
        int damage = swordAttack.calculateDamage(isCritical);

        if (isHit) {
            if (isCritical) {
                System.out.println("¡Ataque crítico! Se infligió " + damage + " puntos de daño.");
            } else {
                System.out.println("¡El ataque acertó! Se infligió " + damage + " puntos de daño.");
            }
        } else {
            System.out.println("¡El ataque falló!");
        }
    }

    private int calculateDamage(boolean isCritical) {
        return calculateDamage(isCritical);
    }

    private boolean isCriticalHit() {
        return isCriticalHit();
    }

    private boolean isHit() {
        return isHit();
    }
   
}

class manaSystem extends AppCompatActivity {
    public manaSystem(int i, int i1) {
    }
}

