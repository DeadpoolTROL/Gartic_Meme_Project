package com.example.garticmemeproject;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ResultatTableauActivity extends AppCompatActivity {

    private MediaPlayer mp = null;
    private Bundle data6;
    private ArrayList listeNom = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //On enleve la barre horizontale en haut de l'écran
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); //On met en plein écran
        setContentView(R.layout.activity_resultat_tableau); //affichage du layout nommé activity_pooltato
//______________________________Son__________________________________________________________________
//On crée un MédiaPlayer mp pour jouer le son "celebration" puis on démare ce lecteur
        mp = MediaPlayer.create(this, R.raw.celebration);
        mp.start();

//Dans cette partie on récupère le classement des joueurs avec le bundle data6
//afin d'afficher le score des joueurs trié
        data6 = getIntent().getExtras();
        int nbjoueur = data6.getInt("NBJOUEUR");
        int i;
        for (i =1; i <=nbjoueur; i++){
            listeNom.add(data6.getString("NOM"+ i));
        }
        ListView listView = findViewById(R.id.listView);
        ArrayAdapter adapter = new ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1,
            listeNom
        );
        listView.setAdapter(adapter);
//Lorsque le joueur appui sur le bouton retour on retourne a FinActivity en passant le bundle
//On arrete aussi le média player
        Button bouton = findViewById(R.id.ButtonRetour);
        bouton.setOnClickListener(v -> {
            mp.stop();
            Intent intent = new Intent(
                    ResultatTableauActivity.this,
                    FinActivity.class
            );
            intent.putExtras(data6);
            startActivity(intent);
        });
    }

    //Si le joueur appuie sur la touche retour d'android on stop aussi le média player
    @Override
    public void onBackPressed() {
        mp.stop();
        super.onBackPressed();
    }
}