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

public class EasterEggActivity extends AppCompatActivity {

    //private Bundle data8;
    Button bouton;
    private ImageView LayoutPooltato;
    private ImageView LayoutJeanProfite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_easter_egg);

        //data8 = getIntent().getExtras();

        bouton = (Button) findViewById(R.id.buttonsecret);
        bouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        EasterEggActivity.this,
                        FinActivity.class
                );
                startActivity(intent);
            }
        });

        LayoutPooltato = findViewById(R.id.Pooltatopic);
        LayoutPooltato.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Intent intent = new Intent(
                        EasterEggActivity.this,
                        PooltatoActivity.class
                );
                //intent.putExtras(data8);
                startActivity(intent);
                return false;
            }
        });

        LayoutJeanProfite = findViewById(R.id.JeanProfitepic);
        LayoutJeanProfite.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Intent intent = new Intent(
                        EasterEggActivity.this,
                        JeanProfiteActivity.class
                );
                //intent.putExtras(data8);
                startActivity(intent);
                return false;
            }
        });
    }
}