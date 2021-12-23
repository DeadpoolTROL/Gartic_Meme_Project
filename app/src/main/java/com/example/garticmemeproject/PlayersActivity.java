package com.example.garticmemeproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class PlayersActivity extends AppCompatActivity {

    private Bundle data2;
    private int idjoueur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_players);

        data2 = getIntent().getExtras();

        idjoueur = data2.getInt("IDJOUEUR",0) + 1;

        Button bouton;
        bouton = findViewById(R.id.buttonjoueur);

        ImageView imgView = findViewById(R.id.logo4);
        String imgName = "profil" + idjoueur;
        int id = getResources().getIdentifier(imgName, "drawable", getPackageName());
        imgView.setImageResource(id);

        bouton.setOnClickListener(v -> {
            Intent intent = new Intent(
                    PlayersActivity.this,
                    CreationmemeActivity.class
            );
            EditText editText = findViewById(R.id.EditNom);
            String nom = editText.getText().toString();

            data2.putInt("IDJOUEUR",idjoueur);
            data2.putString("NOM"+idjoueur, nom);
            intent.putExtras(data2);
            startActivity(intent);
        });
    }

    @Override
    public void onBackPressed() {
        if (idjoueur==1){
            super.onBackPressed();
        }
    }
}