package com.example.garticmemeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class CreationmemeActivity extends AppCompatActivity {

    private MediaPlayer mp = null;
    private Bundle data3;
    public int randmeme = hazard();
    private TextView time;
    private CountDownTimer countDownTimer;
    private long timeLeftInMilliseconds = 100000; //1 min 40      100000
    private int progress = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //On enleve la barre horizontale en haut de l'écran
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); //On met en plein écran
        setContentView(R.layout.activity_creationmeme+randmeme);//affichage du layout nommé activity_creationmeme1 ; activity_creationmeme2 ; activity_creationmeme3 ; activity_creationmeme4 ; activity_creationmeme5 ; activity_creationmeme6

//______________________________Son__________________________________________________________________
//Dans cette partie, on crée le Médiaplayer musica_ascenseur
        mp = MediaPlayer.create(this, R.raw.musica_ascenseur);

//______________________________Bundle (Récupération des données)__________________________________________________________________
//Dans cette partie, on récupère les données que l'on stock dans un bundle que l'on nomme data3
        data3 = getIntent().getExtras();

//______________________________Récupération et affichage du thème__________________________________________________________________
//Dans cette partie, on récupère le thème défini dans les paramètres au début et on l'affiche sur le layout à l'emplacement du TextView nommé "themecreate"
        String theme = data3.getString("THEME");
        TextView textView = findViewById(R.id.themecreate);
        textView.setText("Thème : " + theme);

//______________________________Image Profil__________________________________________________________________
//Dans cette partie, on affiche l'image de profil du joueur qui joue à l'emplacement de l'ImageView nommée "imagejoueurx"

        ImageView imgProfil = findViewById(R.id.imagejoueurx);
        int idjoueur = data3.getInt("IDJOUEUR");
        String imgPP = "profil" + idjoueur;
        int id2 = getResources().getIdentifier(imgPP, "drawable", getPackageName());
        imgProfil.setImageResource(id2);

//______________________________Recupération du nombre de joueur__________________________________________________________________
//Dans cette partie, on récupère le nombre de joueur défini dans les paramètres au début et on stock la valeur dans la variable "nbjoueur"
        int nbjoueur = data3.getInt("NBJOUEUR");

//______________________________Passage à l'activité suivante__________________________________________________________________
//Dans cette partie, on passe à l'activité suivante lorsque l'on appuie sur le bouton nommée buttoncreation
//Dans notre cas, on passe à l'activité "PlayersActivity" tant que tous les joueurs n'ont pas réalisé leur meme.
// Lorsque tous les joueurs ont joué, alors on passe à l'activité "VoteActivity"
        Button bouton;
        bouton = findViewById(R.id.buttoncreation);
        bouton.setOnClickListener(v -> {

// On arrête la musique et le timer avant de passer à l'activité suivante
            mp.stop();
            if (countDownTimer != null){
                countDownTimer.cancel();
            }

// Cas où les joueurs n'ont pas tous réalisé leur meme
            Intent intent;
            if (idjoueur < nbjoueur){
                intent = new Intent(
                        CreationmemeActivity.this,
                        PlayersActivity.class
                );
            }

// Cas où tous les joueurs ont tous réalisé leur meme
            else {
                intent = new Intent(
                        CreationmemeActivity.this,
                        VoteActivity.class
                );
            }
            data3.putInt("IDJOUEUR",idjoueur);
            actionJoueur(idjoueur);
            intent.putExtras(data3);
            startActivity(intent);
        });

//Dans cette partie, on gère le temps en utilisant les classes réalisé tout en bas du code
        time = findViewById(R.id.time);
        updateTimer();
        startTimer();
    }

//----------------------------------------Gestion Timer--------------------------------------------------------------------------
//Dans cette partie, on gère le timer
    public void startTimer(){
        countDownTimer = new CountDownTimer(timeLeftInMilliseconds, 1000) {

//Ici, on update le timer
            @Override
            public void onTick(long l) {
                timeLeftInMilliseconds = l;
                updateTimer();
            }

//Ici, on gère les action à réalisé lorsque le timer est fini.
//Dans notre cas, on passe à l'activité "PlayersActivity" tant que tous les joueurs n'ont pas réalisé leur meme.
//Lorsque tous les joueurs ont joué, alors on passe à l'activité "VoteActivity"
            @Override
            public void onFinish() {
                int nbjoueur = data3.getInt("NBJOUEUR");
                int idjoueur = data3.getInt("IDJOUEUR");
                Intent intent;
                if (idjoueur < nbjoueur){
                    intent = new Intent(
                            CreationmemeActivity.this,
                            PlayersActivity.class
                    );
                }
                else {
                    intent = new Intent(
                            CreationmemeActivity.this,
                            VoteActivity.class
                    );
                }
                actionJoueur(idjoueur);
                data3.putInt("IDJOUEUR",idjoueur);
                intent.putExtras(data3);
                startActivity(intent);
            }
        }.start();
    }
//----------------------------------------Update Timer--------------------------------------------------------------------------
//Dans cette partie, on update le timer toutes les secondes et également la barre de progression.
    public void updateTimer(){
        int minute = (int) timeLeftInMilliseconds / 60000;
        int seconde = (int) timeLeftInMilliseconds % 60000 / 1000;
        ProgressBar progressBar = findViewById(R.id.progress_bar);

        String timeleftText;

        timeleftText = "" + minute;
        timeleftText += ":";
        if (seconde < 10) timeleftText += "0";
        timeleftText += seconde;

        time.setText(timeleftText);
        progress = progress - 1;
        progressBar.setProgress(progress); // Default 0.
        if (timeLeftInMilliseconds<=10000) mp.start(); //Si atteint 10 secondes, on lance le son du Médiaplayer mp
    }

//----------------------------------------Génération nombre aléatoire--------------------------------------------------------------------------
//Cette class nous permet de généré un nombre aléatoire, ici on récupère un des nombres suivants : 1 ; 2 ; 3 ; 4 ; 5 ; 6
    public int hazard(){
        Random rand = new Random();
        return (rand.nextInt(6) + 1);
    }

//----------------------------------------Retour en arrière--------------------------------------------------------------------------
//Cette class nous permet d'empêcher de réaliser un retour en arrière
    @Override
    public void onBackPressed() {
    }

//----------------------------------------Gestion des Joueurs--------------------------------------------------------------------------
//Cette class nous permet de gérer le profil des joueurs. D'abord on créé un bundle pour chaque joueur dans lequel on renseigne le layout du meme utilisé
//Ensuite, selon le meme utilisé, on récupère le texte renseigné dans les EditText (maximum 3 EditText)et on les stock toutes les données dans le bundle du joueur
    public void actionJoueur(int Jx){
        if (Jx == 1){
            Bundle Joueur1 = new Bundle();
            Joueur1.putInt("MEME",randmeme);
            EditText editText1 = findViewById(R.id.ecriture1);
            String ecriture1 = editText1.getText().toString();
            Joueur1.putString("ECRITURE1", ecriture1);
            if (randmeme==1 || randmeme==3 || randmeme==5){
                EditText editText2 = findViewById(R.id.ecriture2);
                String ecriture2 = editText2.getText().toString();
                Joueur1.putString("ECRITURE2", ecriture2);
            }
            if (randmeme==4 || randmeme==6){
                EditText editText2 = findViewById(R.id.ecriture2);
                String ecriture2 = editText2.getText().toString();
                EditText editText3 = findViewById(R.id.ecriture3);
                String ecriture3 = editText3.getText().toString();
                Joueur1.putString("ECRITURE2", ecriture2);
                Joueur1.putString("ECRITURE3", ecriture3);
            }
            data3.putBundle("JOUEUR1",Joueur1);
        }
        if (Jx == 2){
            Bundle Joueur2 = new Bundle();
            Joueur2.putInt("MEME",randmeme);
            EditText editText1 = findViewById(R.id.ecriture1);
            String ecriture1 = editText1.getText().toString();
            Joueur2.putString("ECRITURE1", ecriture1);
            if (randmeme==1 || randmeme==3 || randmeme==5){
                EditText editText2 = findViewById(R.id.ecriture2);
                String ecriture2 = editText2.getText().toString();
                Joueur2.putString("ECRITURE2", ecriture2);
            }
            if (randmeme==4 || randmeme==6){
                EditText editText2 = findViewById(R.id.ecriture2);
                String ecriture2 = editText2.getText().toString();
                EditText editText3 = findViewById(R.id.ecriture3);
                String ecriture3 = editText3.getText().toString();
                Joueur2.putString("ECRITURE2", ecriture2);
                Joueur2.putString("ECRITURE3", ecriture3);
            }
            data3.putBundle("JOUEUR2",Joueur2);
        }
        if (Jx == 3){
            Bundle Joueur3 = new Bundle();
            Joueur3.putInt("MEME",randmeme);
            EditText editText1 = findViewById(R.id.ecriture1);
            String ecriture1 = editText1.getText().toString();
            Joueur3.putString("ECRITURE1", ecriture1);
            if (randmeme==1 || randmeme==3 || randmeme==5){
                EditText editText2 = findViewById(R.id.ecriture2);
                String ecriture2 = editText2.getText().toString();
                Joueur3.putString("ECRITURE2", ecriture2);
            }
            if (randmeme==4 || randmeme==6){
                EditText editText2 = findViewById(R.id.ecriture2);
                String ecriture2 = editText2.getText().toString();
                EditText editText3 = findViewById(R.id.ecriture3);
                String ecriture3 = editText3.getText().toString();
                Joueur3.putString("ECRITURE2", ecriture2);
                Joueur3.putString("ECRITURE3", ecriture3);
            }
            data3.putBundle("JOUEUR3",Joueur3);
        }
        if (Jx == 4){
            Bundle Joueur4 = new Bundle();
            Joueur4.putInt("MEME",randmeme);
            EditText editText1 = findViewById(R.id.ecriture1);
            String ecriture1 = editText1.getText().toString();
            Joueur4.putString("ECRITURE1", ecriture1);
            if (randmeme==1 || randmeme==3 || randmeme==5){
                EditText editText2 = findViewById(R.id.ecriture2);
                String ecriture2 = editText2.getText().toString();
                Joueur4.putString("ECRITURE2", ecriture2);
            }
            if (randmeme==4 || randmeme==6){
                EditText editText2 = findViewById(R.id.ecriture2);
                String ecriture2 = editText2.getText().toString();
                EditText editText3 = findViewById(R.id.ecriture3);
                String ecriture3 = editText3.getText().toString();
                Joueur4.putString("ECRITURE2", ecriture2);
                Joueur4.putString("ECRITURE3", ecriture3);
            }
            data3.putBundle("JOUEUR4",Joueur4);
        }
        if (Jx == 5){
            Bundle Joueur5 = new Bundle();
            Joueur5.putInt("MEME",randmeme);
            EditText editText1 = findViewById(R.id.ecriture1);
            String ecriture1 = editText1.getText().toString();
            Joueur5.putString("ECRITURE1", ecriture1);
            if (randmeme==1 || randmeme==3 || randmeme==5){
                EditText editText2 = findViewById(R.id.ecriture2);
                String ecriture2 = editText2.getText().toString();
                Joueur5.putString("ECRITURE2", ecriture2);
            }
            if (randmeme==4 || randmeme==6){
                EditText editText2 = findViewById(R.id.ecriture2);
                String ecriture2 = editText2.getText().toString();
                EditText editText3 = findViewById(R.id.ecriture3);
                String ecriture3 = editText3.getText().toString();
                Joueur5.putString("ECRITURE2", ecriture2);
                Joueur5.putString("ECRITURE3", ecriture3);
            }
            data3.putBundle("JOUEUR5",Joueur5);
        }
        if (Jx == 6){
            Bundle Joueur6 = new Bundle();
            Joueur6.putInt("MEME",randmeme);
            EditText editText1 = findViewById(R.id.ecriture1);
            String ecriture1 = editText1.getText().toString();
            Joueur6.putString("ECRITURE1", ecriture1);
            if (randmeme==1 || randmeme==3 || randmeme==5){
                EditText editText2 = findViewById(R.id.ecriture2);
                String ecriture2 = editText2.getText().toString();
                Joueur6.putString("ECRITURE2", ecriture2);
            }
            if (randmeme==4 || randmeme==6){
                EditText editText2 = findViewById(R.id.ecriture2);
                String ecriture2 = editText2.getText().toString();
                EditText editText3 = findViewById(R.id.ecriture3);
                String ecriture3 = editText3.getText().toString();
                Joueur6.putString("ECRITURE2", ecriture2);
                Joueur6.putString("ECRITURE3", ecriture3);
            }
            data3.putBundle("JOUEUR6",Joueur6);
        }
        if (Jx == 7){
            Bundle Joueur7 = new Bundle();
            Joueur7.putInt("MEME",randmeme);
            EditText editText1 = findViewById(R.id.ecriture1);
            String ecriture1 = editText1.getText().toString();
            Joueur7.putString("ECRITURE1", ecriture1);
            if (randmeme==1 || randmeme==3 || randmeme==5){
                EditText editText2 = findViewById(R.id.ecriture2);
                String ecriture2 = editText2.getText().toString();
                Joueur7.putString("ECRITURE2", ecriture2);
            }
            if (randmeme==4 || randmeme==6){
                EditText editText2 = findViewById(R.id.ecriture2);
                String ecriture2 = editText2.getText().toString();
                EditText editText3 = findViewById(R.id.ecriture3);
                String ecriture3 = editText3.getText().toString();
                Joueur7.putString("ECRITURE2", ecriture2);
                Joueur7.putString("ECRITURE3", ecriture3);
            }
            data3.putBundle("JOUEUR7",Joueur7);
        }
        if (Jx == 8){
            Bundle Joueur8 = new Bundle();
            Joueur8.putInt("MEME",randmeme);
            EditText editText1 = findViewById(R.id.ecriture1);
            String ecriture1 = editText1.getText().toString();
            Joueur8.putString("ECRITURE1", ecriture1);
            if (randmeme==1 || randmeme==3 || randmeme==5){
                EditText editText2 = findViewById(R.id.ecriture2);
                String ecriture2 = editText2.getText().toString();
                Joueur8.putString("ECRITURE2", ecriture2);
            }
            if (randmeme==4 || randmeme==6){
                EditText editText2 = findViewById(R.id.ecriture2);
                String ecriture2 = editText2.getText().toString();
                EditText editText3 = findViewById(R.id.ecriture3);
                String ecriture3 = editText3.getText().toString();
                Joueur8.putString("ECRITURE2", ecriture2);
                Joueur8.putString("ECRITURE3", ecriture3);
            }
            data3.putBundle("JOUEUR8",Joueur8);
        }
        if (Jx == 9){
            Bundle Joueur9 = new Bundle();
            Joueur9.putInt("MEME",randmeme);
            EditText editText1 = findViewById(R.id.ecriture1);
            String ecriture1 = editText1.getText().toString();
            Joueur9.putString("ECRITURE1", ecriture1);
            if (randmeme==1 || randmeme==3 || randmeme==5){
                EditText editText2 = findViewById(R.id.ecriture2);
                String ecriture2 = editText2.getText().toString();
                Joueur9.putString("ECRITURE2", ecriture2);
            }
            if (randmeme==4 || randmeme==6){
                EditText editText2 = findViewById(R.id.ecriture2);
                String ecriture2 = editText2.getText().toString();
                EditText editText3 = findViewById(R.id.ecriture3);
                String ecriture3 = editText3.getText().toString();
                Joueur9.putString("ECRITURE2", ecriture2);
                Joueur9.putString("ECRITURE3", ecriture3);
            }
            data3.putBundle("JOUEUR9",Joueur9);
        }
        if (Jx == 10){
            Bundle Joueur10 = new Bundle();
            Joueur10.putInt("MEME",randmeme);
            EditText editText1 = findViewById(R.id.ecriture1);
            String ecriture1 = editText1.getText().toString();
            Joueur10.putString("ECRITURE1", ecriture1);
            if (randmeme==1 || randmeme==3 || randmeme==5){
                EditText editText2 = findViewById(R.id.ecriture2);
                String ecriture2 = editText2.getText().toString();
                Joueur10.putString("ECRITURE2", ecriture2);
            }
            if (randmeme==4 || randmeme==6){
                EditText editText2 = findViewById(R.id.ecriture2);
                String ecriture2 = editText2.getText().toString();
                EditText editText3 = findViewById(R.id.ecriture3);
                String ecriture3 = editText3.getText().toString();
                Joueur10.putString("ECRITURE2", ecriture2);
                Joueur10.putString("ECRITURE3", ecriture3);
            }
            data3.putBundle("JOUEUR10",Joueur10);
        }
    }
}