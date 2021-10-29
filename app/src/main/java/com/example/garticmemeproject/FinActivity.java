package com.example.garticmemeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class FinActivity extends AppCompatActivity {

    ImageView Layout;
    ImageView Layout2;
    Button bouton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_fin);

        bouton = (Button) findViewById(R.id.buttonfin);
        bouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        FinActivity.this,
                        ParametreActivity.class
                );
                startActivity(intent);
            }
        });

        Layout = findViewById(R.id.podium);
        Layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Intent intent = new Intent(
                        FinActivity.this,
                        ResultatTableauActivity.class
                );
                startActivity(intent);
                return false;
            }
        });

        Layout2 = findViewById(R.id.accessecret);
        Layout2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Intent intent = new Intent(
                        FinActivity.this,
                        EasterEggActivity.class
                );
                startActivity(intent);
                return false;
            }
        });
    }
}