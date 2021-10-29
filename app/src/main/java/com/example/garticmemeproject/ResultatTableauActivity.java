package com.example.garticmemeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

    Button bouton;
    ListView listView;
    String[] data = {
            "Player 1","Player 2","Player 3","Player 4","Benjamin le plus beau"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_resultat_tableau);

        listView=(ListView)findViewById(R.id.listView);
        ArrayAdapter adapter = new ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1,
            data
        );
        listView.setAdapter(adapter);

        bouton = (Button) findViewById(R.id.ButtonRetour);
        bouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        ResultatTableauActivity.this,
                        FinActivity.class
                );
                startActivity(intent);
            }
        });

    }
}