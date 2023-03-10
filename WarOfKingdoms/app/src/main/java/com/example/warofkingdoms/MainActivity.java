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

/**
 * In the gameView class, we are going to create a surface view that will be used to create the loop for the game, so it runs through.
 */
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

/**
 * In the attackMechanic class, we are going to create a surface view that will be used to create the attack mechanic, to make the cards deal damage.
 */
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
                System.out.println("??Ataque cr??tico! Se infligi?? " + damage + " puntos de da??o.");
            } else {
                System.out.println("??El ataque acert??! Se infligi?? " + damage + " puntos de da??o.");
            }
        } else {
            System.out.println("??El ataque fall??!");
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

/**
 * In the turn class, we are going to create a surface view that will be used to create the turn of a game.
 */
class turn extends AppCompatActivity {
    private Turn turn;
    private Player player1;
    private Player player2;
    private int turnNumber = 1;

    public void Turn(Player player1, Player player2, int turnNumber) {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the players
        player1 = new Player("Player 1");
        player2 = new Player("Player 2");

        // Initialize the turn
        turn = new Turn(player1, player2, turnNumber);
    }

    public void playCard(Card card, int position) {
        // Call the playCard method of the Turn object
        turn.playCard(card, position);
    }

    public void attack(int attackerPosition, int defenderPosition) {
        // Call the attack method of the Turn object
        turn.attack(attackerPosition, defenderPosition);
    }

    public void endTurn() {
        // Call the endTurn method of the Turn object
        turn.endTurn();
        turnNumber++;
        turn = new Turn(player2, player1, turnNumber);
    }
}


