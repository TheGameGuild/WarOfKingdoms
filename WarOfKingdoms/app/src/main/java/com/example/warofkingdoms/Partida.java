package com.example.warofkingdoms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Partida extends AppCompatActivity {

    private List<Carta> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partida);

        LinearLayout linearLayout = findViewById(R.id.linearLayoutCards);

        //List of cards and stats
        itemList = new ArrayList<>();
        itemList.add(new Carta("Guerrero",  3, R.drawable.caballero,  4, 10));
        itemList.add(new Carta("Dragón", 5, R.drawable.dragon, 4, 5));
        itemList.add(new Carta("El Rey", 7, R.drawable.rey, 8, 7));
        itemList.add(new Carta("Tigre", 6, R.drawable.tigre, 7, 6));

        //Iteration in every ImageView inside LinearLayout and setup the OnClick method
        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            ImageView imageView = (ImageView) linearLayout.getChildAt(i);
            final int position = i;


            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Obtain selectioned card depending on position
                    Carta carta = itemList.get(position);


                    // Update the text inside the ImageView with the stats of the card
                    TextView statsTextView = findViewById(R.id.statsTextView);
                    statsTextView.setText("Coste de Elixir: " + carta.getCostoElixir() + ", Puntos de Vida: " + carta.getPuntosVida() + ", Poder de Ataque: " + carta.getPoderAtaque());
                    statsTextView.setVisibility(View.VISIBLE);

                }
            });
        }

    }
}