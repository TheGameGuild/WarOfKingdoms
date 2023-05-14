package com.example.warofkingdoms;
import java.util.Timer;
import java.util.TimerTask;

public class Turn {
    private Player activePlayer;
    private Player inactivePlayer;
    private int turnNumber;
    private Timer timer;
    private int timerDuration;

    public Turn(Player activePlayer, Player inactivePlayer, int turnNumber) {
        this.activePlayer = activePlayer;
        this.inactivePlayer = inactivePlayer;
        this.turnNumber = turnNumber;
        this.timer = timer;
    }

    public Turn(int timerDuration) {
        this.timerDuration = timerDuration;
    }

    public void iniciar() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // When it runs to 0
                System.out.println("¡El tiempo del turno ha terminado!");
            }
        }, timerDuration * 1000);
    }
    public void detener() {
        if (timer != null) {
            timer.cancel();
        }
    }
    public static void main(String[] args) {
        Turn turn = new Turn(40); // Turn duration: 40 seconds
        turn.iniciar();

        // Waits 5 seconds and stops de counter
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        turn.detener();
    }

    public void playCard(Card card, int position) {
        if (activePlayer.playCard(card, position)) {
            // Card was played successfully
        } else {
            // Player cannot play the card
        }
    }

    public void attack(int attackerPosition, int defenderPosition) {
        activePlayer.attack(attackerPosition, inactivePlayer, defenderPosition);
    }

    public void endTurn() {
        activePlayer.endTurn();
        inactivePlayer.startTurn();
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    public Player getInactivePlayer() {
        return inactivePlayer;
    }

    public int getTurnNumber() {
        return turnNumber;
    }
}
