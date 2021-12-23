package com.example.garticmemeproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FinActivity extends AppCompatActivity {

    private MediaPlayer mp = null;
    private Bundle data5;
    private final Map<Integer, String> listeScore = new HashMap<>();

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_fin);
        mp = MediaPlayer.create(this, R.raw.metal_gear_solid_alert);

        data5 = getIntent().getExtras();

        int nbjoueur = data5.getInt("NBJOUEUR");

        int i;
        for (i =1; i <=nbjoueur; i++){
            listeScore.put(i, String.valueOf(data5.getInt("VALUEJ"+ i)));
        }

        Map<Integer, String> sortedListeScore = sortByValue(listeScore);
        Set<Integer> indexe = sortedListeScore.keySet();
        Object[] indice = indexe.toArray();

        if (nbjoueur == 1){
            ImageView imgView = findViewById(R.id.imageView1);
            int id = getResources().getIdentifier("profil1", "drawable", getPackageName());
            imgView.setImageResource(id);

            TextView score1 = findViewById(R.id.pts1);
            score1.setText(sortedListeScore.get(indice[0])+"pts");
        }
        if (nbjoueur == 2){
            ImageView imgView = findViewById(R.id.imageView1);
            String imgName = "profil" + indice[nbjoueur-1];
            int id = getResources().getIdentifier(imgName, "drawable", getPackageName());
            imgView.setImageResource(id);
            ImageView imgView2 = findViewById(R.id.imageView2);
            String imgName2 = "profil" + indice[nbjoueur-2];
            int id2 = getResources().getIdentifier(imgName2, "drawable", getPackageName());
            imgView2.setImageResource(id2);

            TextView score1 = findViewById(R.id.pts1);
            score1.setText(sortedListeScore.get(indice[nbjoueur-1])+"pts");
            TextView score2 = findViewById(R.id.pts2);
            score2.setText(sortedListeScore.get(indice[nbjoueur-2])+"pts");
        }
        if (nbjoueur == 3 || nbjoueur == 4 || nbjoueur == 5 || nbjoueur == 6 || nbjoueur == 7 || nbjoueur == 8 || nbjoueur == 9 || nbjoueur == 10){
            ImageView imgView = findViewById(R.id.imageView1);
            String imgName = "profil" + indice[nbjoueur-1];
            int id = getResources().getIdentifier(imgName, "drawable", getPackageName());
            imgView.setImageResource(id);
            ImageView imgView2 = findViewById(R.id.imageView2);
            String imgName2 = "profil" + indice[nbjoueur-2];
            int id2 = getResources().getIdentifier(imgName2, "drawable", getPackageName());
            imgView2.setImageResource(id2);
            ImageView imgView3 = findViewById(R.id.imageView3);
            String imgName3 = "profil" + indice[nbjoueur-3];
            int id3 = getResources().getIdentifier(imgName3, "drawable", getPackageName());
            imgView3.setImageResource(id3);

            TextView score1 = findViewById(R.id.pts1);
            score1.setText(listeScore.get(indice[nbjoueur-1])+"pts");
            TextView score2 = findViewById(R.id.pts2);
            score2.setText(listeScore.get(indice[nbjoueur-2])+"pts");
            TextView score3 = findViewById(R.id.pts3);
            score3.setText(listeScore.get(indice[nbjoueur-3])+"pts");
        }

        Button bouton = findViewById(R.id.buttonfin);
        bouton.setOnClickListener(v -> {
            Intent intent = new Intent(
                    FinActivity.this,
                    ParametreActivity.class
            );
            startActivity(intent);
        });

        ImageView layout = findViewById(R.id.podium);
        layout.setOnTouchListener((view, motionEvent) -> {
            Intent intent = new Intent(
                    FinActivity.this,
                    ResultatTableauActivity.class
            );
            intent.putExtras(data5);
            startActivity(intent);
            return false;
        });

        ImageView layout2 = findViewById(R.id.accessecret);
        layout2.setOnTouchListener((view, motionEvent) -> {
            Intent intent = new Intent(
                    FinActivity.this,
                    EasterEggActivity.class
            );
            mp.start();
            intent.putExtras(data5);
            startActivity(intent);
            return false;
        });
    }

    @Override
    public void onBackPressed() {

    }

    public static <K extends Comparable,V extends Comparable> Map<K,V> sortByValue(Map<K,V> map) {

        List< Map.Entry<K,V> > entries = new LinkedList<>(map.entrySet());

        entries.sort(Map.Entry.comparingByValue());

        Map<K,V> sortedMap = new LinkedHashMap<>();

        for (Map.Entry<K,V> entry: entries) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
}