package com.example.garticmemeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class EasterEggActivity extends AppCompatActivity {

    private MediaPlayer mp1 = null;
    private MediaPlayer mp2 = null;
    private Bundle data8;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //On enleve la barre horizontale en haut de l'écran
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); //On met en plein écran
        setContentView(R.layout.activity_easter_egg); //affichage du layout nommé activity_easter_egg

//______________________________Son__________________________________________________________________
//Dans cette partie, on créé deux Médiaplayer (ici, "anime_wow" et "bruh")
        mp1 = MediaPlayer.create(this, R.raw.anime_wow);
        mp2 = MediaPlayer.create(this, R.raw.bruh);

//______________________________Bundle (stockage des données)__________________________________________________________________
//Dans cette partie, on stock les données dans un bundle que l'on nomme data8
        data8 = getIntent().getExtras();

//______________________________retour à l'Activité précédente__________________________________________________________________
//Dans cette partie, on retourne à l'activité précédente lorsque l'on appuie sur le bouton nommé buttonsecret
//Dans notre cas, on passe à l'activité "FinActivité"
        Button bouton = findViewById(R.id.buttonsecret);
        bouton.setOnClickListener(v -> {
            Intent intent = new Intent(
                    EasterEggActivity.this,
                    FinActivity.class
            );
            intent.putExtras(data8);
            startActivity(intent);
        });

//______________________________Passage à l'activité suivante option 1__________________________________________________________________
//Dans cette partie, on passe à l'activité suivante lorsque l'on appuie sur le bouton nommé Pooltatopic
//Dans notre cas, on passe à l'activité "PooltatoActivity" ce qui nous fait afficher le profil de Florian
        ImageView layoutPooltato = findViewById(R.id.Pooltatopic);
        layoutPooltato.setOnTouchListener((view, motionEvent) -> {
            Intent intent = new Intent(
                    EasterEggActivity.this,
                    PooltatoActivity.class
            );
            intent.putExtras(data8);
            mp1.start(); //On lance le son du Médiaplayer mp1, c'est à dire le son "anime_wow"
            startActivity(intent);
            return false;
        });

//______________________________Passage à l'activité suivante option 2__________________________________________________________________
//Dans cette partie, on passe à l'activité suivante lorsque l'on appuie sur le bouton nommé JeanProfitepic
//Dans notre cas, on passe à l'activité "JeanProfiteActivity" ce qui nous fait afficher le profil de Benjamin
        ImageView layoutJeanProfite = findViewById(R.id.JeanProfitepic);
        layoutJeanProfite.setOnTouchListener((view, motionEvent) -> {
            Intent intent = new Intent(
                    EasterEggActivity.this,
                    JeanProfiteActivity.class
            );
            intent.putExtras(data8);
            mp2.start(); //On lance le son du Médiaplayer mp2, c'est à dire le son "bruh"
            startActivity(intent);
            return false;
        });
    }
}