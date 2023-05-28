package com.example.warofkingdoms;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class ColectionFragment extends Fragment {
    CardView dragon;
    CardView tigre;
    CardView asesino;
    CardView rey;
    CardView caballero;
    CardView arquero;


    //@Override
    //protected void onCreate(Bundle savedInstanceState){
        //super.onCreate(savedInstanceState);
        //setContentView(R.layout.fragment_colection);

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_colection, container, false);
        Button btnjugar = getActivity().findViewById(R.id.btn_jugar);
        btnjugar.setVisibility(View.GONE);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_colection, container, false);

    }
    }


//}
