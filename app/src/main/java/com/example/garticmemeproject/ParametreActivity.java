package com.example.garticmemeproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ParametreActivity extends AppCompatActivity {

    private final Bundle data = new Bundle();
    private int nbjoueur = 1;
    private SeekBar seekbar;
    private TextView Nbjoueurs;
    private final int idjoueur = 0;
    private final int idjoueur2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//On enleve la barre horizontale en haut de l'écran
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//On met en plein écran
        setContentView(R.layout.activity_parametre);//affichage du layout nommé activity_parametre

//______________________________Curseur nombre de joueurs__________________________________________________________________
//Dans cette partie on récupère le nombre de joueurs souhaiter par l'utilisateur a l'aide d'une seekbar et on actualise le texte a afficher
        seekbar = findViewById(R.id.seekBar);
        Nbjoueurs = findViewById(R.id.nbjoueurtext);

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b)
            {
                Nbjoueurs.setText("Nombre de Joueurs : " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
//______________________________Passage à l'activité suivante__________________________________________________________________
//Dans cette partie, on passe à l'activité suivante lorsque l'on appuie sur le bouton nommée buttoncreation
//Dans notre cas, on passe à l'activité "CurlyActivity" si il n'y a qu'un seul joueur qui joue.
//Pour tout autre nombre de joueur, on passe directement à l'activité "PlayersActivity"
        Button bouton;
        bouton = findViewById(R.id.buttonsetting);
        bouton.setOnClickListener(v -> {
            nbjoueur = seekbar.getProgress();
            EditText editText = findViewById(R.id.EditTheme);
            String theme = editText.getText().toString();
//On stock certaines informations dans le bundle comme le thème choisi ou le nombre de joueurs par exemple
            data.putString("THEME", theme);
            data.putInt("IDJOUEUR", idjoueur);
            data.putInt("IDJOUEUR2", idjoueur2);
            data.putInt("NBJOUEUR", nbjoueur);

            Intent intent;
            if (nbjoueur == 1){
                intent = new Intent(
                        ParametreActivity.this,
                        CurlyActivity.class
                );
            }
            else{
                intent = new Intent(
                        ParametreActivity.this,
                        PlayersActivity.class
                );
            }
            intent.putExtras(data);
            startActivity(intent);
        });
    }
}