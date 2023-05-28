package com.example.warofkingdoms;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class ColectionFragment extends Fragment {
    CardView dragon;
    CardView tigre;
    CardView asesino;
    CardView rey;
    CardView caballero;
    CardView arquero;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_colection);
    }

}
