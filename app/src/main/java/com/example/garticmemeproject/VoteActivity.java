package com.example.garticmemeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class VoteActivity extends AppCompatActivity {

    private Bundle data4;
    private TextView value;
    private int idjoueur2;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //On enleve la barre horizontale en haut de l'écran
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); //On met en plein écran

//______________________________Bundle (Récupération des données)__________________________________________________________________
//Dans cette partie, on récupère les données que l'on stock dans un bundle que l'on nomme data4
        data4 = getIntent().getExtras();

//---------------------------------------Info joueur---------------------------------------------------------------------------
//Dans cette partie, on gère l'affichage du meme ainsi que du texte renseigné précédemment par le joueur lors de l'activité CreationmemeActivity. D'abord on récupère
//les informations comprise dans le bundle du joueur en cours. C'est à dire le layout du meme précédemment obtenu ainsi que le texte que le joueur a renseigné dans les
//différents EditText. On affiche ensuite ce texte dans les différents TextView. Enfin, on récupère le score associé au joueur dans le bundle data4.
        int nbjoueur = data4.getInt("NBJOUEUR");
        idjoueur2 = data4.getInt("IDJOUEUR2") + 1;

        if (idjoueur2 == 1){
            Bundle Joueur1 = data4.getBundle("JOUEUR1");
            int randmeme = Joueur1.getInt("MEME",1);
            setContentView(R.layout.activity_vote+randmeme);

            String ecriture1 = Joueur1.getString("ECRITURE1");
            TextView textView1 = findViewById(R.id.ecriture1);
            textView1.setText(ecriture1);
            if (randmeme==1 || randmeme==3 || randmeme==5){
                String ecriture2 = Joueur1.getString("ECRITURE2");
                TextView textView2 = findViewById(R.id.ecriture2);
                textView2.setText(ecriture2);
            }
            if (randmeme==4 || randmeme==6){
                String ecriture2 = Joueur1.getString("ECRITURE2");
                TextView textView2 = findViewById(R.id.ecriture2);
                textView2.setText(ecriture2);
                String ecriture3 = Joueur1.getString("ECRITURE3");
                TextView textView3 = findViewById(R.id.ecriture3);
                textView3.setText(ecriture3);
            }
        }
        if (idjoueur2 == 2){
            Bundle Joueur2 = data4.getBundle("JOUEUR2");
            int randmeme = Joueur2.getInt("MEME",1);
            setContentView(R.layout.activity_vote+randmeme);

            String ecriture1 = Joueur2.getString("ECRITURE1");
            TextView textView1 = findViewById(R.id.ecriture1);
            textView1.setText(ecriture1);
            if (randmeme==1 || randmeme==3 || randmeme==5){
                String ecriture2 = Joueur2.getString("ECRITURE2");
                TextView textView2 = findViewById(R.id.ecriture2);
                textView2.setText(ecriture2);
            }
            if (randmeme==4 || randmeme==6){
                String ecriture2 = Joueur2.getString("ECRITURE2");
                TextView textView2 = findViewById(R.id.ecriture2);
                textView2.setText(ecriture2);
                String ecriture3 = Joueur2.getString("ECRITURE3");
                TextView textView3 = findViewById(R.id.ecriture3);
                textView3.setText(ecriture3);
            }
            data4.putInt("VALUEJ2",count);
        }
        if (idjoueur2 == 3){
            Bundle Joueur3 = data4.getBundle("JOUEUR3");
            int randmeme = Joueur3.getInt("MEME",1);
            setContentView(R.layout.activity_vote+randmeme);

            String ecriture1 = Joueur3.getString("ECRITURE1");
            TextView textView1 = findViewById(R.id.ecriture1);
            textView1.setText(ecriture1);
            if (randmeme==1 || randmeme==3 || randmeme==5){
                String ecriture2 = Joueur3.getString("ECRITURE2");
                TextView textView2 = findViewById(R.id.ecriture2);
                textView2.setText(ecriture2);
            }
            if (randmeme==4 || randmeme==6){
                String ecriture2 = Joueur3.getString("ECRITURE2");
                TextView textView2 = findViewById(R.id.ecriture2);
                textView2.setText(ecriture2);
                String ecriture3 = Joueur3.getString("ECRITURE3");
                TextView textView3 = findViewById(R.id.ecriture3);
                textView3.setText(ecriture3);
            }
            data4.putInt("VALUEJ3",count);
        }
        if (idjoueur2 == 4){
            Bundle Joueur4 = data4.getBundle("JOUEUR4");
            int randmeme = Joueur4.getInt("MEME",1);
            setContentView(R.layout.activity_vote+randmeme);

            String ecriture1 = Joueur4.getString("ECRITURE1");
            TextView textView1 = findViewById(R.id.ecriture1);
            textView1.setText(ecriture1);
            if (randmeme==1 || randmeme==3 || randmeme==5){
                String ecriture2 = Joueur4.getString("ECRITURE2");
                TextView textView2 = findViewById(R.id.ecriture2);
                textView2.setText(ecriture2);
            }
            if (randmeme==4 || randmeme==6){
                String ecriture2 = Joueur4.getString("ECRITURE2");
                TextView textView2 = findViewById(R.id.ecriture2);
                textView2.setText(ecriture2);
                String ecriture3 = Joueur4.getString("ECRITURE3");
                TextView textView3 = findViewById(R.id.ecriture3);
                textView3.setText(ecriture3);
            }
            data4.putInt("VALUEJ4",count);
        }
        if (idjoueur2 == 5){
            Bundle Joueur5 = data4.getBundle("JOUEUR5");
            int randmeme = Joueur5.getInt("MEME",1);
            setContentView(R.layout.activity_vote+randmeme);

            String ecriture1 = Joueur5.getString("ECRITURE1");
            TextView textView1 = findViewById(R.id.ecriture1);
            textView1.setText(ecriture1);
            if (randmeme==1 || randmeme==3 || randmeme==5){
                String ecriture2 = Joueur5.getString("ECRITURE2");
                TextView textView2 = findViewById(R.id.ecriture2);
                textView2.setText(ecriture2);
            }
            if (randmeme==4 || randmeme==6){
                String ecriture2 = Joueur5.getString("ECRITURE2");
                TextView textView2 = findViewById(R.id.ecriture2);
                textView2.setText(ecriture2);
                String ecriture3 = Joueur5.getString("ECRITURE3");
                TextView textView3 = findViewById(R.id.ecriture3);
                textView3.setText(ecriture3);
            }
            data4.putInt("VALUEJ5",count);
        }
        if (idjoueur2 == 6){
            Bundle Joueur6 = data4.getBundle("JOUEUR6");
            int randmeme = Joueur6.getInt("MEME",1);
            setContentView(R.layout.activity_vote+randmeme);

            String ecriture1 = Joueur6.getString("ECRITURE1");
            TextView textView1 = findViewById(R.id.ecriture1);
            textView1.setText(ecriture1);
            if (randmeme==1 || randmeme==3 || randmeme==5){
                String ecriture2 = Joueur6.getString("ECRITURE2");
                TextView textView2 = findViewById(R.id.ecriture2);
                textView2.setText(ecriture2);
            }
            if (randmeme==4 || randmeme==6){
                String ecriture2 = Joueur6.getString("ECRITURE2");
                TextView textView2 = findViewById(R.id.ecriture2);
                textView2.setText(ecriture2);
                String ecriture3 = Joueur6.getString("ECRITURE3");
                TextView textView3 = findViewById(R.id.ecriture3);
                textView3.setText(ecriture3);
            }
            data4.putInt("VALUEJ6",count);
        }
        if (idjoueur2 == 7){
            Bundle Joueur7 = data4.getBundle("JOUEUR7");
            int randmeme = Joueur7.getInt("MEME",1);
            setContentView(R.layout.activity_vote+randmeme);

            String ecriture1 = Joueur7.getString("ECRITURE1");
            TextView textView1 = findViewById(R.id.ecriture1);
            textView1.setText(ecriture1);
            if (randmeme==1 || randmeme==3 || randmeme==5){
                String ecriture2 = Joueur7.getString("ECRITURE2");
                TextView textView2 = findViewById(R.id.ecriture2);
                textView2.setText(ecriture2);
            }
            if (randmeme==4 || randmeme==6){
                String ecriture2 = Joueur7.getString("ECRITURE2");
                TextView textView2 = findViewById(R.id.ecriture2);
                textView2.setText(ecriture2);
                String ecriture3 = Joueur7.getString("ECRITURE3");
                TextView textView3 = findViewById(R.id.ecriture3);
                textView3.setText(ecriture3);
            }
            data4.putInt("VALUEJ7",count);
        }
        if (idjoueur2 == 8){
            Bundle Joueur8 = data4.getBundle("JOUEUR8");
            int randmeme = Joueur8.getInt("MEME",1);
            setContentView(R.layout.activity_vote+randmeme);

            String ecriture1 = Joueur8.getString("ECRITURE1");
            TextView textView1 = findViewById(R.id.ecriture1);
            textView1.setText(ecriture1);
            if (randmeme==1 || randmeme==3 || randmeme==5){
                String ecriture2 = Joueur8.getString("ECRITURE2");
                TextView textView2 = findViewById(R.id.ecriture2);
                textView2.setText(ecriture2);
            }
            if (randmeme==4 || randmeme==6){
                String ecriture2 = Joueur8.getString("ECRITURE2");
                TextView textView2 = findViewById(R.id.ecriture2);
                textView2.setText(ecriture2);
                String ecriture3 = Joueur8.getString("ECRITURE3");
                TextView textView3 = findViewById(R.id.ecriture3);
                textView3.setText(ecriture3);
            }
            data4.putInt("VALUEJ8",count);
        }
        if (idjoueur2 == 9){
            Bundle Joueur9 = data4.getBundle("JOUEUR9");
            int randmeme = Joueur9.getInt("MEME",1);
            setContentView(R.layout.activity_vote+randmeme);

            String ecriture1 = Joueur9.getString("ECRITURE1");
            TextView textView1 = findViewById(R.id.ecriture1);
            textView1.setText(ecriture1);
            if (randmeme==1 || randmeme==3 || randmeme==5){
                String ecriture2 = Joueur9.getString("ECRITURE2");
                TextView textView2 = findViewById(R.id.ecriture2);
                textView2.setText(ecriture2);
            }
            if (randmeme==4 || randmeme==6){
                String ecriture2 = Joueur9.getString("ECRITURE2");
                TextView textView2 = findViewById(R.id.ecriture2);
                textView2.setText(ecriture2);
                String ecriture3 = Joueur9.getString("ECRITURE3");
                TextView textView3 = findViewById(R.id.ecriture3);
                textView3.setText(ecriture3);
            }
            data4.putInt("VALUEJ9",count);
        }
        if (idjoueur2 == 10){
            Bundle Joueur10 = data4.getBundle("JOUEUR10");
            int randmeme = Joueur10.getInt("MEME",1);
            setContentView(R.layout.activity_vote+randmeme);

            String ecriture1 = Joueur10.getString("ECRITURE1");
            TextView textView1 = findViewById(R.id.ecriture1);
            textView1.setText(ecriture1);
            if (randmeme==1 || randmeme==3 || randmeme==5){
                String ecriture2 = Joueur10.getString("ECRITURE2");
                TextView textView2 = findViewById(R.id.ecriture2);
                textView2.setText(ecriture2);
            }
            if (randmeme==4 || randmeme==6){
                String ecriture2 = Joueur10.getString("ECRITURE2");
                TextView textView2 = findViewById(R.id.ecriture2);
                textView2.setText(ecriture2);
                String ecriture3 = Joueur10.getString("ECRITURE3");
                TextView textView3 = findViewById(R.id.ecriture3);
                textView3.setText(ecriture3);
            }
            data4.putInt("VALUEJ10",count);
        }

        String theme = data4.getString("THEME");
        TextView textView = findViewById(R.id.themevote);
        textView.setText("Thème : " + theme);
        value= findViewById(R.id.voteresult);

//______________________________Passage à l'activité suivante__________________________________________________________________
//Dans cette partie, on passe à l'activité suivante lorsque l'on appuie sur le bouton nommée buttoncreation
//Dans notre cas, on passe à l'activité "VoteActivity" tant que tous les joueurs n'ont pas réalisé leur meme.
// Lorsque tous les joueurs ont joué, alors on passe à l'activité "FinActivity"

        Button bouton;
        bouton = findViewById(R.id.buttonvote);
        bouton.setOnClickListener(v -> {
            if (idjoueur2 < nbjoueur){
                Intent intent = new Intent(
                        VoteActivity.this,
                        VoteActivity.class
                );
                data4.putInt("IDJOUEUR2",idjoueur2);
                data4.putInt("VALUEJ"+idjoueur2,count);
                intent.putExtras(data4);
                startActivity(intent);
            }
            else if (idjoueur2 >= nbjoueur){
                Intent intent = new Intent(
                        VoteActivity.this,
                        FinActivity.class
                );
                data4.putInt("VALUEJ"+idjoueur2,count);
                intent.putExtras(data4);
                startActivity(intent);
            }
        });
    }

//______________________________Incrémentation du score__________________________________________________________________
//Dans cette partie, on réalise l'incrémentation du score à chaque appui sur le bouton "+" présent sur le Layout
    public void increment(View v){
        int nbJoueur = data4.getInt("NBJOUEUR");
        if (count >= nbJoueur) count = nbJoueur;
        else count++;
        value.setText("" + count);
    }

//______________________________décrémentation du score__________________________________________________________________
//Dans cette partie, on réalise la décrémentation du score à chaque appui sur le bouton "-" présent sur le Layout
    public void decrement(View v){
        if (count <= 0) count = 0;
        else count--;
        value.setText("" + count);
    }

//----------------------------------------Retour en arrière--------------------------------------------------------------------------
//Cette class nous permet d'empêcher de réaliser un retour en arrière
    @Override
    public void onBackPressed() {
    }
}