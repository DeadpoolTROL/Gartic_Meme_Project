package com.example.garticmemeproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ReglesActivity extends AppCompatActivity {

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //On enleve la barre horizontale en haut de l'écran
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); //On met en plein écran
        setContentView(R.layout.activity_pooltato); //affichage du layout nommé activity_pooltato

//Ici on affiche le layout activity_regles, lorsque le joueur appuie sur l'écran on passe a ParametreActivity
        ImageView layout = findViewById(R.id.touchregle);
        layout.setOnTouchListener((view, motionEvent) -> {
            Intent intent = new Intent(
                    ReglesActivity.this,
                    ParametreActivity.class
            );
            startActivity(intent);
            return false;
        });
    }
    
}