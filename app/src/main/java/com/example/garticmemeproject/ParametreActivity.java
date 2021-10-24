package com.example.garticmemeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class ParametreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametre);

        SeekBar seekbar;
        TextView Nbjoueurs;
        seekbar = (SeekBar)findViewById(R.id.seekBar);
        Nbjoueurs = (TextView)findViewById(R.id.nbjoueurtext);
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b)
            {
                Nbjoueurs.setText("Nombre de Joueurs : " + String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        Button bouton;
        bouton = (Button) findViewById(R.id.buttonsetting);
        bouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        ParametreActivity.this,
                        PlayersActivity.class
                );
                startActivity(intent);
            }
        });
    }
}