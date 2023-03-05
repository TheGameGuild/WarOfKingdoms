package com.example.warofkingdoms;

public class ManaSystem {
    private int maxMana;
    private int currentMana;
    private int manaRegen;

    /**
     * Constructor for ManaSystem and implementation of the ManaSystem interface and mechanic.
     */
    public ManaSystem(int maxMana, int manaRegen) {
        this.maxMana = maxMana;
        this.currentMana = maxMana;
        this.manaRegen = manaRegen;
    }

    public boolean useMana(int manaCost) {
        if (currentMana >= manaCost) {
            currentMana -= manaCost;
            return true;
        }
        return false;
    }

    public void endTurn() {
        currentMana += manaRegen;
        if (currentMana > maxMana) {
            currentMana = maxMana;
        }
    }

    public int getCurrentMana() {
        return currentMana;
    }

    public int getMaxMana() {
        return maxMana;
    }
}

