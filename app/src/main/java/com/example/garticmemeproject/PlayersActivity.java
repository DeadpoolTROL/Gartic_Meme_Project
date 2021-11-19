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

    private Bundle data2;
    private int idjoueur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_players);

        data2 = getIntent().getExtras();

        int idjoueur = data2.getInt("IDJOUEUR") + 1;

        Button bouton;
        bouton = (Button) findViewById(R.id.buttonjoueur);
        String theme = data2.getString("THEME");

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
                EditText editText = (EditText) findViewById(R.id.EditNom);
                String nom = editText.getText().toString();

                data2.putInt("IDJOUEUR",idjoueur);
                data2.putString("NOM"+idjoueur, nom);
                intent.putExtras(data2);
                startActivity(intent);
            }
        });
    }}