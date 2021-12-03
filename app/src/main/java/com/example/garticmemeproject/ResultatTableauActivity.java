package com.example.garticmemeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class ResultatTableauActivity extends AppCompatActivity {

    private MediaPlayer mp = null;
    private Bundle data6;
    Button bouton;
    ListView listView;
    ArrayList listeNom = new ArrayList();
    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_resultat_tableau);
        mp = MediaPlayer.create(this, R.raw.celebration);
        mp.start();
        data6 = getIntent().getExtras();

        int nbjoueur = data6.getInt("NBJOUEUR");
        for (i=1; i<=nbjoueur; i++){
            listeNom.add(data6.getString("NOM"+i));
        }
        listView=(ListView)findViewById(R.id.listView);
        ArrayAdapter adapter = new ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1,
            listeNom
        );
        listView.setAdapter(adapter);

        bouton = (Button) findViewById(R.id.ButtonRetour);
        bouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                Intent intent = new Intent(
                        ResultatTableauActivity.this,
                        FinActivity.class
                );
                intent.putExtras(data6);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        mp.stop();
        super.onBackPressed();
    }
}