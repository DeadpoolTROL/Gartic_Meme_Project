package com.example.garticmemeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class CurlyActivity extends AppCompatActivity {

    private Bundle dataCurly;
    private ImageView Layout;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_curly); //affichage du layout nommé activity_curly

//______________________________Son__________________________________________________________________
//Dans cette partie, on joue le son selectionné (ici, le son qui s'appel "ta_pas_damis_prend_un_curly_flo")
        MediaPlayer mp = MediaPlayer.create(this, R.raw.ta_pas_damis_prend_un_curly_flo);
        mp.start();

//______________________________Bundle (stockage des données)__________________________________________________________________
//Dans cette partie, on stock les données dans un bundle que l'on nomme dataCurly
        dataCurly = getIntent().getExtras();

//______________________________Passage à l'activité suivante__________________________________________________________________
//Dans cette partie, on passe à l'activité suivante lorsque l'on appuie sur l'image nommée Curly
//Dans notre cas, on passe à l'activité "PlayersActivity"
        Layout = findViewById(R.id.Curly);
        Layout.setOnTouchListener((view, motionEvent) -> {
            Intent intent = new Intent(
                    CurlyActivity.this,
                    PlayersActivity.class
            );
            intent.putExtras(dataCurly);
            startActivity(intent);
            return false;
        });
    }
}