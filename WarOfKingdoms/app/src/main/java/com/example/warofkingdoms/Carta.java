package com.example.warofkingdoms;

public class Carta {
    private String nombre;
    private int costoElixir;
    private int imageResource;
    private int poderAtaque;
    private int puntosVida;

    public Carta(String nombre, int costoElixir, int imageResource, int poderAtaque, int puntosVida) {
        this.nombre = nombre;
        this.imageResource = imageResource;
        this.costoElixir = costoElixir;
        this.poderAtaque = poderAtaque;
        this.puntosVida = puntosVida;
    }

    // Getters

    public String getNombre() {
        return nombre;
    }

    public int getImageResource() { return imageResource;}
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
        Carta dragon = new Carta("Dragón", 4, 4, 5, 8);

        System.out.println("Nombre: " + dragon.getNombre());
        System.out.println("Costo de Elixir: " + dragon.getCostoElixir());
        System.out.println("Poder de Ataque: " + dragon.getPoderAtaque());
        System.out.println("Puntos de Vida: " + dragon.getPuntosVida());


        Carta guerrero = new Carta("Guerrero", 3, 3, 4, 10);

        System.out.println("Nombre: " + guerrero.getNombre());
        System.out.println("Costo de Elixir: " + guerrero.getCostoElixir());
        System.out.println("Poder de Ataque: " + guerrero.getPoderAtaque());
        System.out.println("Puntos de Vida: " + guerrero.getPuntosVida());


        Carta tigre = new Carta("Tigre", 6, 6, 7, 6);

        System.out.println("Nombre: " + tigre.getNombre());
        System.out.println("Costo de Elixir: " + tigre.getCostoElixir());
        System.out.println("Poder de Ataque: " + tigre.getPoderAtaque());
        System.out.println("Puntos de Vida: " + tigre.getPuntosVida());

        Carta rey = new Carta("El Rey", 7, 7, 8,7 );

        System.out.println("Nombre: " + rey.getNombre());
        System.out.println("Costo de Elixir: " + rey.getCostoElixir());
        System.out.println("Poder de Ataque: " + rey.getPoderAtaque());
        System.out.println("Puntos de Vida: " + rey.getPuntosVida());

    }
}