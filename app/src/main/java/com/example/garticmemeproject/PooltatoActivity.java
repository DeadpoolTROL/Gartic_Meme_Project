package com.example.garticmemeproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class PooltatoActivity extends AppCompatActivity {

    private Bundle data111;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //On enleve la barre horizontale en haut de l'écran
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); //On met en plein écran
        setContentView(R.layout.activity_pooltato); //affichage du layout nommé activity_pooltato

//______________________________Bundle (Récupération des données)__________________________________________________________________
//Dans cette partie, on récupère les données que l'on stock dans un bundle que l'on nomme data111
        data111 = getIntent().getExtras();

//______________________________Passage à l'activité suivante__________________________________________________________________
//Dans cette partie, on passe à l'activité suivante lorsque l'on appuie sur l'image nommée logo1
//Dans notre cas, on passe à l'activité "EasterEggActivity"
        ImageView layout = findViewById(R.id.logo1);
        layout.setOnTouchListener((view, motionEvent) -> {
            Intent intent = new Intent(
                    PooltatoActivity.this,
                    EasterEggActivity.class
            );
            intent.putExtras(data111);
            startActivity(intent);
            return false;
        });
    }
}