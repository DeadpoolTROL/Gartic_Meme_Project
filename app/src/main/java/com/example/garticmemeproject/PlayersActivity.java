package com.example.garticmemeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class PlayersActivity extends AppCompatActivity {

    private int idjoueur;
    public static final String EXTRA_MESSAGE2 = "";
    public static final String EXTRA_PROFIL = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_players);

        Button bouton;
        bouton = (Button) findViewById(R.id.buttonjoueur);
        Bundle bundle = getIntent().getExtras();
        String theme = bundle.getString(ParametreActivity.EXTRA_MESSAGE);
        idjoueur = bundle.getInt(ParametreActivity.EXTRA_JOUEUR,0);

        ImageView imgView = (ImageView) findViewById(R.id.logo4);
        String imgName = "profil" + idjoueur;
        int id = getResources().getIdentifier(imgName, "drawable", getPackageName());
        imgView.setImageResource(id);

        bouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        PlayersActivity.this,
                        CreationmemeActivity.class
                );
                intent.putExtra(EXTRA_MESSAGE2, theme);
                intent.putExtra(EXTRA_PROFIL, idjoueur);
                startActivity(intent);
            }
        });
    }}