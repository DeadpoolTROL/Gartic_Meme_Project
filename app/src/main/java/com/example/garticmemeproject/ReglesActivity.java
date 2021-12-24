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
        setContentView(R.layout.activity_regles); //affichage du layout nommé activity_regles

//______________________________Passage à l'activité suivante__________________________________________________________________
//Dans cette partie, on passe à l'activité suivante lorsque l'on appuie sur l'image nommée touchregle
//Dans notre cas, on passe à l'activité "ParametreActivity"
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