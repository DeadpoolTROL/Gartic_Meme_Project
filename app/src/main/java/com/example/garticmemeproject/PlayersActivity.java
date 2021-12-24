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
        requestWindowFeature(Window.FEATURE_NO_TITLE);//On enleve la barre horizontale en haut de l'écran
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//On met en plein écran
        setContentView(R.layout.activity_players);//affichage du layout nommé activity_parametre

//______________________________Bundle (Récupération des données)__________________________________________________________________
//Dans cette partie, on récupère les données que l'on stock dans un bundle que l'on nomme data2
        data2 = getIntent().getExtras();

//Récupération de idjoueur qui correspond au numéro du joueur en cours
        idjoueur = data2.getInt("IDJOUEUR",0) + 1;

//______________________________Image profil du joueur__________________________________________________________________
//Dans cette partie, on affiche l'image de profil du joueur qui doit jouer
        ImageView imgView = findViewById(R.id.logo4);
        String imgName = "profil" + idjoueur;
        int id = getResources().getIdentifier(imgName, "drawable", getPackageName());
        imgView.setImageResource(id);

//______________________________Passage à l'activité suivante__________________________________________________________________
//Dans cette partie, on passe à l'activité suivante lorsque l'on appuie sur le bouton nommée buttoncreation
//Dans notre cas, on passe à l'activité "CreationmemeActivity" et on stock certaines information dans le bundle data2
        Button bouton = findViewById(R.id.buttonjoueur);
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
//----------------------------------------Retour en arrière--------------------------------------------------------------------------
//Cette class nous permet d'empêcher de réaliser un retour en arrière sauf si le joueur en cours est le premier joueur. Dans ce cas on autorise le fait de revenir au menu des paramètres
    @Override
    public void onBackPressed() {
        if (idjoueur==1){
            super.onBackPressed();
        }
    }
}