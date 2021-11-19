package com.example.garticmemeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class ParametreActivity extends AppCompatActivity {

    private Bundle data = new Bundle();
    private int nbjoueur = 1;
    private SeekBar seekbar;
    private TextView Nbjoueurs;
    private int idjoueur = 0;
    private int idjoueur2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_parametre);

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
                nbjoueur = seekbar.getProgress();
                EditText editText = (EditText) findViewById(R.id.EditTheme);
                String theme = editText.getText().toString();

                data.putString("THEME", theme);
                data.putInt("IDJOUEUR", idjoueur);
                data.putInt("IDJOUEUR2", idjoueur2);
                data.putInt("NBJOUEUR", nbjoueur);
                intent.putExtras(data);
                startActivity(intent);
            }
        });
    }
}