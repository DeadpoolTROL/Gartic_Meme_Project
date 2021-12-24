package com.example.garticmemeproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FinActivity extends AppCompatActivity {

    private MediaPlayer mp = null;
    private Bundle data5;
    private final Map<Integer, String> listeScore = new HashMap<>();

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //On enleve la barre horizontale en haut de l'écran
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); //On met en plein écran
        setContentView(R.layout.activity_fin); //affichage du layout nommé activity_fin

//Création du médiaplayer mp pour jouer le son metal_gear_solid_alert
        mp = MediaPlayer.create(this, R.raw.metal_gear_solid_alert);

//______________________________Bundle (Récupération des données)__________________________________________________________________
//Dans cette partie, on récupère les données que l'on stock dans un bundle que l'on nomme data5
        data5 = getIntent().getExtras();

//______________________________Classement des joueurs__________________________________________________________________
//Dans cette partie, on classe les joueurs en fonction de leur score afin d'afficher le podium
        int nbjoueur = data5.getInt("NBJOUEUR");

//Création d'un de la map contenant le score du joueur à son numéro associé
        int i;
        for (i =1; i <=nbjoueur; i++){
            listeScore.put(i, String.valueOf(data5.getInt("VALUEJ"+ i)));
        }

//Tri de la map selon le score et on récupère également l'ordre des indices
        Map<Integer, String> sortedListeScore = sortByValue(listeScore);
        Set<Integer> indexe = sortedListeScore.keySet();
        Object[] indice = indexe.toArray();

//Affichage du premier joueur (celui avec le meilleur score), on affiche son score ainsi que son image de profil
        ImageView imgView = findViewById(R.id.imageView1);
        String imgName = "profil" + indice[nbjoueur-1];
        int id = getResources().getIdentifier(imgName, "drawable", getPackageName());
        imgView.setImageResource(id);

        TextView score1 = findViewById(R.id.pts1);
        score1.setText(sortedListeScore.get(indice[nbjoueur-1])+"pts");

//Affichage du second joueur (celui avec le deuxième meilleur score), on affiche son score ainsi que son image de profil
        if (nbjoueur != 1){
            ImageView imgView2 = findViewById(R.id.imageView2);
            String imgName2 = "profil" + indice[nbjoueur-2];
            int id2 = getResources().getIdentifier(imgName2, "drawable", getPackageName());
            imgView2.setImageResource(id2);

            TextView score2 = findViewById(R.id.pts2);
            score2.setText(sortedListeScore.get(indice[nbjoueur-2])+"pts");

//Affichage du troisième joueur (celui avec le troisième meilleur score), on affiche son score ainsi que son image de profil
            if (nbjoueur != 1 && nbjoueur != 2){
                ImageView imgView3 = findViewById(R.id.imageView3);
                String imgName3 = "profil" + indice[nbjoueur-3];
                int id3 = getResources().getIdentifier(imgName3, "drawable", getPackageName());
                imgView3.setImageResource(id3);

                TextView score3 = findViewById(R.id.pts3);
                score3.setText(listeScore.get(indice[nbjoueur-3])+"pts");
            }
        }
//______________________________Boutons__________________________________________________________________
//Bouton permetant de relancer une partie, on revient ainsi à la définition des paramètres
        Button bouton = findViewById(R.id.buttonfin);
        bouton.setOnClickListener(v -> {
            Intent intent = new Intent(
                    FinActivity.this,
                    ParametreActivity.class
            );
            startActivity(intent);
        });

//Bouton permetant d'afficher tous les joueurs ayant participé à la partie
        ImageView layout = findViewById(R.id.podium);
        layout.setOnTouchListener((view, motionEvent) -> {
            Intent intent = new Intent(
                    FinActivity.this,
                    ResultatTableauActivity.class
            );
            intent.putExtras(data5);
            startActivity(intent);
            return false;
        });
//Bouton permetant d'acceder a l'EasterEgg (chut faut pas le dire)
        ImageView layout2 = findViewById(R.id.accessecret);
        layout2.setOnTouchListener((view, motionEvent) -> {
            Intent intent = new Intent(
                    FinActivity.this,
                    EasterEggActivity.class
            );
            mp.start();
            intent.putExtras(data5);
            startActivity(intent);
            return false;
        });
    }

//----------------------------------------Retour en arrière--------------------------------------------------------------------------
//Cette class nous permet d'empêcher de réaliser un retour en arrière
    @Override
    public void onBackPressed() {
    }

//----------------------------------------Tri de la map--------------------------------------------------------------------------
//Methode permetant de classer une map par la valeur
    public static <K extends Comparable,V extends Comparable> Map<K,V> sortByValue(Map<K,V> map) {
        List< Map.Entry<K,V> > entries = new LinkedList<>(map.entrySet());
        entries.sort(Map.Entry.comparingByValue());
        Map<K,V> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<K,V> entry: entries) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }
}