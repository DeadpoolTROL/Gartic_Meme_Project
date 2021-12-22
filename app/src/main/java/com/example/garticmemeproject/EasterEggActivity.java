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
    Button bouton;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_easter_egg);
        mp1 = MediaPlayer.create(this, R.raw.anime_wow);
        mp2 = MediaPlayer.create(this, R.raw.bruh);
        data8 = getIntent().getExtras();

        bouton = findViewById(R.id.buttonsecret);
        bouton.setOnClickListener(v -> {
            Intent intent = new Intent(
                    EasterEggActivity.this,
                    FinActivity.class
            );
            intent.putExtras(data8);
            startActivity(intent);
        });

        ImageView layoutPooltato = findViewById(R.id.Pooltatopic);
        layoutPooltato.setOnTouchListener((view, motionEvent) -> {
            Intent intent = new Intent(
                    EasterEggActivity.this,
                    PooltatoActivity.class
            );
            intent.putExtras(data8);
            mp1.start();
            startActivity(intent);
            return false;
        });

        ImageView layoutJeanProfite = findViewById(R.id.JeanProfitepic);
        layoutJeanProfite.setOnTouchListener((view, motionEvent) -> {
            Intent intent = new Intent(
                    EasterEggActivity.this,
                    JeanProfiteActivity.class
            );
            intent.putExtras(data8);
            mp2.start();
            startActivity(intent);
            return false;
        });
    }
}