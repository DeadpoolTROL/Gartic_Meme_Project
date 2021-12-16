package com.example.garticmemeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.*;

public class FinActivity extends AppCompatActivity {

    private MediaPlayer mp = null;
    private Bundle data5;
    private ImageView Layout;
    private ImageView Layout2;
    private Button bouton;
    private Map<Integer, String> listeScore = new HashMap<>();
    private Set<Integer> indexe = new HashSet<>();
    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_fin);
        mp = MediaPlayer.create(this, R.raw.metal_gear_solid_alert);

        data5 = getIntent().getExtras();

        int nbjoueur = data5.getInt("NBJOUEUR");

        for (i=1; i<=nbjoueur; i++){
            listeScore.put(i, String.valueOf(data5.getInt("VALUEJ"+i)));
        }

        Map<Integer, String> sortedListeScore = sortByValue(listeScore);
        indexe = sortedListeScore.keySet();
        Object[] indice = indexe.toArray();

        if (nbjoueur == 1){
            ImageView imgView = (ImageView) findViewById(R.id.imageView1);
            int id = getResources().getIdentifier("profil1", "drawable", getPackageName());
            imgView.setImageResource(id);

            TextView score1 = findViewById(R.id.pts1);
            score1.setText(sortedListeScore.get(indice[0])+"pts");
        }
        if (nbjoueur == 2){
            ImageView imgView = (ImageView) findViewById(R.id.imageView1);
            String imgName = "profil" + indice[nbjoueur-1];
            int id = getResources().getIdentifier(imgName, "drawable", getPackageName());
            imgView.setImageResource(id);
            ImageView imgView2 = (ImageView) findViewById(R.id.imageView2);
            String imgName2 = "profil" + indice[nbjoueur-2];
            int id2 = getResources().getIdentifier(imgName2, "drawable", getPackageName());
            imgView2.setImageResource(id2);

            TextView score1 = findViewById(R.id.pts1);
            score1.setText(sortedListeScore.get(indice[nbjoueur-1])+"pts");
            TextView score2 = findViewById(R.id.pts2);
            score2.setText(sortedListeScore.get(indice[nbjoueur-2])+"pts");
        }
        if (nbjoueur == 3 || nbjoueur == 4 || nbjoueur == 5 || nbjoueur == 6 || nbjoueur == 7 || nbjoueur == 8 || nbjoueur == 9 || nbjoueur == 10){
            ImageView imgView = (ImageView) findViewById(R.id.imageView1);
            String imgName = "profil" + indice[nbjoueur-1];
            int id = getResources().getIdentifier(imgName, "drawable", getPackageName());
            imgView.setImageResource(id);
            ImageView imgView2 = (ImageView) findViewById(R.id.imageView2);
            String imgName2 = "profil" + indice[nbjoueur-2];
            int id2 = getResources().getIdentifier(imgName2, "drawable", getPackageName());
            imgView2.setImageResource(id2);
            ImageView imgView3 = (ImageView) findViewById(R.id.imageView3);
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
                mp.start();
                intent.putExtras(data5);
                startActivity(intent);
                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {

        return;
    }

    public static <K extends Comparable,V extends Comparable> Map<K,V> sortByValue(Map<K,V> map) {

        List< Map.Entry<K,V> > entries = new LinkedList< Map.Entry<K,V> >(map.entrySet());

        Collections.sort(entries, new Comparator<Map.Entry<K,V>>() {
            @Override
            public int compare(Map.Entry<K, V> entry1, Map.Entry<K, V> entry2) {
                return entry1.getValue().compareTo(entry2.getValue());
            }
        });

        Map<K,V> sortedMap = new LinkedHashMap<K,V>();

        for (Map.Entry<K,V> entry: entries) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
}