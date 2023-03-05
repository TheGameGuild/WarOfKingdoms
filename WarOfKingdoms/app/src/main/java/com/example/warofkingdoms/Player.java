package com.example.warofkingdoms;

public class Player {
    private int life;
    private int energy;

    public Player(int life, int energy) {
        this.life = life;
        this.energy = energy;
    }

    public Player(String s) {
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public boolean playCard(Card card, int position) {
        return playCard(card, position);
    }

    public void attack(int attackerPosition, Player inactivePlayer, int defenderPosition) {
        attack(attackerPosition, inactivePlayer, defenderPosition);
    }

    public void endTurn() {
        endTurn();
    }

    public void startTurn() {
        startTurn();
    }
}






