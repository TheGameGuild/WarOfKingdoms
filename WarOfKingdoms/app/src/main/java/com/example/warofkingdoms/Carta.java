package com.example.warofkingdoms;

public class Carta {
    private String nombre;
    private int costoElixir;
    private int poderAtaque;
    private int puntosVida;

    public Carta(String nombre, int costoElixir, int poderAtaque, int puntosVida) {
        this.nombre = nombre;
        this.costoElixir = costoElixir;
        this.poderAtaque = poderAtaque;
        this.puntosVida = puntosVida;
    }

    // Getters

    public String getNombre() {
        return nombre;
    }

    public int getCostoElixir() {
        return costoElixir;
    }

    public int getPoderAtaque() {
        return poderAtaque;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public static void main(String[] args) {
        Carta dragon = new Carta("Dragón", 4, 5, 8);

        System.out.println("Nombre: " + dragon.getNombre());
        System.out.println("Costo de Elixir: " + dragon.getCostoElixir());
        System.out.println("Poder de Ataque: " + dragon.getPoderAtaque());
        System.out.println("Puntos de Vida: " + dragon.getPuntosVida());


        Carta caballero = new Carta("Caballero", 3, 4, 10);

        System.out.println("Nombre: " + caballero.getNombre());
        System.out.println("Costo de Elixir: " + caballero.getCostoElixir());
        System.out.println("Poder de Ataque: " + caballero.getPoderAtaque());
        System.out.println("Puntos de Vida: " + caballero.getPuntosVida());


        Carta lobo = new Carta("Lobo", 6, 7, 6);

        System.out.println("Nombre: " + lobo.getNombre());
        System.out.println("Costo de Elixir: " + lobo.getCostoElixir());
        System.out.println("Poder de Ataque: " + lobo.getPoderAtaque());
        System.out.println("Puntos de Vida: " + lobo.getPuntosVida());

    }
}

//Doubt: At the moment the system.out.printlns are for testing. Might need to use setters to implement the stats.