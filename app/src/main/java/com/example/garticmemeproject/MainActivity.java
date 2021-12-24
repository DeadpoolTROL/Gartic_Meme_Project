package com.example.garticmemeproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mp = null;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //On enleve la barre horizontale en haut de l'écran
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); //On met en plein écran
        setContentView(R.layout.activity_main); //affichage du layout nommé activity_main

//______________________________Son__________________________________________________________________
//Dans cette partie, on crée le Médiaplayer okay_lets_go
        mp = MediaPlayer.create(this, R.raw.okay_lets_go);

//______________________________Passage à l'activité suivante__________________________________________________________________
//Dans cette partie, on passe à l'activité suivante lorsque l'on appuie sur l'image nommée logo1
//Dans notre cas, on passe à l'activité "ReglesActivity"
        ImageView layout = findViewById(R.id.logo1);
        layout.setOnTouchListener((view, motionEvent) -> {
            Intent intent = new Intent(
                    MainActivity.this,
                    ReglesActivity.class
            );
            mp.start(); //On lance le son du Médiaplayer mp, c'est à dire le son "okay_lets_go"
            startActivity(intent);
            return false;
        });
    }
}