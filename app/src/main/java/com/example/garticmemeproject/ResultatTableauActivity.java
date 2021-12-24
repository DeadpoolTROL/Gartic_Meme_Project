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
        setContentView(R.layout.activity_resultat_tableau); //affichage du layout nommé activity_resultat_tableau

//______________________________Son__________________________________________________________________
//On crée un MédiaPlayer mp pour jouer le son "celebration" puis on démarre ce lecteur
        mp = MediaPlayer.create(this, R.raw.celebration);
        mp.start();

//______________________________Bundle (Récupération des données)__________________________________________________________________
//Dans cette partie, on récupère les données que l'on stock dans un bundle que l'on nomme data6
        data6 = getIntent().getExtras();

//______________________________Remplissage du tableau__________________________________________________________________
//Dans cette partie, on récupère les noms des joueurs et on rempli le tableau
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

//______________________________Passage à l'activité suivante__________________________________________________________________
//Dans cette partie, on passe à l'activité suivante lorsque l'on appuie sur le bouton nommé ButtonRetour
//Dans notre cas, on passe à l'activité "FinActivity"
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