package com.example.warofkingdoms;

public class AttackMechanic {
    private int baseDamage;
    private int criticalChance;
    private int accuracy;

    public AttackMechanic(int baseDamage, int criticalChance, int accuracy) {
        this.baseDamage = baseDamage;
        this.criticalChance = criticalChance;
        this.accuracy = accuracy;
    }

    public int calculateDamage(boolean isCritical) {
        int damage = baseDamage;
        if (isCritical) {
            damage *= 2; // Doble de daño en un golpe crítico
        }
        return damage;
    }

    public boolean isHit() {
        return (accuracy >= (int)(Math.random() * 100)); // Genera un número aleatorio entre 0 y 99
    }

    public boolean isCriticalHit() {
        return (criticalChance >= (int)(Math.random() * 100)); // Genera un número aleatorio entre 0 y 99
    }
}
