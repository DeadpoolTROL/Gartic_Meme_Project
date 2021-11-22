package com.example.garticmemeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class CurlyActivity extends AppCompatActivity {

    private MediaPlayer mp = null;
    private Bundle dataCurly;
    ImageView Layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curly);

        mp = MediaPlayer.create(this, R.raw.ta_pas_damis_prend_un_curly_flo);
        mp.start();
        dataCurly = getIntent().getExtras();

        Layout = findViewById(R.id.Curly);
        Layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Intent intent = new Intent(
                        CurlyActivity.this,
                        PlayersActivity.class
                );
                intent.putExtras(dataCurly);
                startActivity(intent);
                return false;
            }
        });
    }
}