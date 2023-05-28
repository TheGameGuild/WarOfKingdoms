package com.example.warofkingdoms;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Partida extends AppCompatActivity {

    private List<Carta> itemList;
    private TextView vidaEnemiga;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partida);
        vidaEnemiga = findViewById(R.id.vida_enemiga);

        LinearLayout linearLayout = findViewById(R.id.linearLayoutCards);

        //List of cards and stats
        itemList = new ArrayList<>();
        itemList.add(new Carta("Guerrero", 3, R.drawable.caballero, 4, 10));
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
                    showConfirmationDialog(position);
                    Carta carta = itemList.get(position);


                    // Update the text inside the ImageView with the stats of the card
                    TextView statsTextView = findViewById(R.id.statsTextView);
                    statsTextView.setText("Coste de Elixir: " + carta.getCostoElixir() + ", Puntos de Vida: " + carta.getPuntosVida() + ", Poder de Ataque: " + carta.getPoderAtaque());
                    statsTextView.setVisibility(View.VISIBLE);

                }
            });
        }

    }

    private void showConfirmationDialog(final int position) {
        Carta carta = itemList.get(position);

        //Create a AlertDialog.Builder to build the dialog box
        AlertDialog.Builder builder = new AlertDialog.Builder(Partida.this);
        builder.setTitle("Confirmación");
        builder.setMessage("¿Quiere usar esta carta?");

        // Config the Yes button
        builder.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Card action to be implemented
                int ataqueCarta = carta.getPoderAtaque();
                int numeroTextView = Integer.parseInt(vidaEnemiga.getText().toString());
                if (ataqueCarta > numeroTextView) {
                    showDialog("Has ganado");
                } else {
                    showDialog("Has perdido");
                }
            }

            private void showDialog(String message) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Partida.this);
                builder.setMessage(message)
                        .setCancelable(false)
                        .setPositiveButton("Volver al menú principal", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent = new Intent(Partida.this, MainActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                                startActivity(intent);
                                finish();

                            }
                        });

                AlertDialog alert = builder.create();
                alert.show();
            }
        });


        //Config the No button
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                //Cancel the action to be implemented
                Toast.makeText(Partida.this, "Acción Cancelada", Toast.LENGTH_SHORT).show();
            }
        });

        // Create and show the dialog box
        AlertDialog dialog = builder.create();
        dialog.show();

    }


}