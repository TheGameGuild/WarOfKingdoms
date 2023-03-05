package com.example.warofkingdoms;

public class Turn {
    private Player activePlayer;
    private Player inactivePlayer;
    private int turnNumber;

    public Turn(Player activePlayer, Player inactivePlayer, int turnNumber) {
        this.activePlayer = activePlayer;
        this.inactivePlayer = inactivePlayer;
        this.turnNumber = turnNumber;
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
