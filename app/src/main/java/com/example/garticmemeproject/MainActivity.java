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
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        mp = MediaPlayer.create(this, R.raw.okay_lets_go);
        ImageView layout = findViewById(R.id.logo1);
        layout.setOnTouchListener((view, motionEvent) -> {
            Intent intent = new Intent(
                    MainActivity.this,
                    ReglesActivity.class
            );
            mp.start();
            startActivity(intent);
            return false;
        });
    }
}