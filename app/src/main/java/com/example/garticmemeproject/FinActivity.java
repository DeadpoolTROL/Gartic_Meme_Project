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
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class FinActivity extends AppCompatActivity {

    private Bundle data5;
    private ImageView Layout;
    private ImageView Layout2;
    private Button bouton;
    ArrayList listeScore = new ArrayList();
    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_fin);

        data5 = getIntent().getExtras();

        int nbjoueur = data5.getInt("NBJOUEUR");

        for (i=1; i<=nbjoueur; i++){
            listeScore.add(data5.getInt("VALUEJ"+i));
        }
        Collections.sort(listeScore, Collections.reverseOrder());

        if (nbjoueur == 1){
            TextView score1 = findViewById(R.id.pts1);
            score1.setText(listeScore.get(0)+"pts");
        }
        if (nbjoueur == 2){
            TextView score1 = findViewById(R.id.pts1);
            score1.setText(listeScore.get(0)+"pts");
            TextView score2 = findViewById(R.id.pts2);
            score2.setText(listeScore.get(1)+"pts");
        }
        if (nbjoueur == 3 || nbjoueur == 4 || nbjoueur == 5 || nbjoueur == 6 || nbjoueur == 7 || nbjoueur == 8 || nbjoueur == 9 || nbjoueur == 10){
            TextView score1 = findViewById(R.id.pts1);
            score1.setText(listeScore.get(0)+"pts");
            TextView score2 = findViewById(R.id.pts2);
            score2.setText(listeScore.get(1)+"pts");
            TextView score3 = findViewById(R.id.pts3);
            score3.setText(listeScore.get(2)+"pts");
        }

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
                intent.putExtras(data5);
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
                //intent.putExtras(data5);
                startActivity(intent);
                return false;
            }
        });
    }
}