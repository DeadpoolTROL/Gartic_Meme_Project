package com.example.garticmemeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class VoteActivity extends AppCompatActivity {

    private Bundle data4;
    TextView value;
    private int idjoueur2;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        data4 = getIntent().getExtras();

//---------------------------------------ID joueur---------------------------------------------------------------------------
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
        value=(TextView)findViewById(R.id.voteresult);

//______________________________Image MEME__________________________________________________________________

        //int randmeme = getIntent().getIntExtra("MEME",1);
        //ImageView imgMeme = (ImageView) findViewById(R.id.Meme);
        //String imgMM = "meme" + randmeme;
        //int id2 = getResources().getIdentifier(imgMM, "drawable", getPackageName());
        //imgMeme.setImageResource(id2);

//---------------------------------------Bouton---------------------------------------------------------------------------

        Button bouton;
        bouton = (Button) findViewById(R.id.buttonvote);
        bouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (idjoueur2 < nbjoueur){
                    Intent intent = new Intent(
                            VoteActivity.this,
                            VoteActivity.class
                    );
                    data4.putInt("IDJOUEUR2",idjoueur2);
                    switch (idjoueur2){
                        case 1 : data4.putInt("VALUEJ1",count);break;
                        case 2 : data4.putInt("VALUEJ2",count);break;
                        case 3 : data4.putInt("VALUEJ3",count);break;
                        case 4 : data4.putInt("VALUEJ4",count);break;
                        case 5 : data4.putInt("VALUEJ5",count);break;
                        case 6 : data4.putInt("VALUEJ6",count);break;
                        case 7 : data4.putInt("VALUEJ7",count);break;
                        case 8 : data4.putInt("VALUEJ8",count);break;
                        case 9 : data4.putInt("VALUEJ9",count);break;
                        case 10 : data4.putInt("VALUEJ10",count);break;
                    }
                    intent.putExtras(data4);
                    startActivity(intent);
                }
                else if (idjoueur2 >= nbjoueur){
                    Intent intent = new Intent(
                            VoteActivity.this,
                            FinActivity.class
                    );
                    switch (idjoueur2){
                        case 1 : data4.putInt("VALUEJ1",count);break;
                        case 2 : data4.putInt("VALUEJ2",count);break;
                        case 3 : data4.putInt("VALUEJ3",count);break;
                        case 4 : data4.putInt("VALUEJ4",count);break;
                        case 5 : data4.putInt("VALUEJ5",count);break;
                        case 6 : data4.putInt("VALUEJ6",count);break;
                        case 7 : data4.putInt("VALUEJ7",count);break;
                        case 8 : data4.putInt("VALUEJ8",count);break;
                        case 9 : data4.putInt("VALUEJ9",count);break;
                        case 10 : data4.putInt("VALUEJ10",count);break;
                    }
                    intent.putExtras(data4);
                    startActivity(intent);
                }
            }
        });
    }

    public void increment(View v){
        int nbJoueur = data4.getInt("NBJOUEUR");
        if (count >= nbJoueur) count = nbJoueur;
        else count++;
        value.setText("" + count);
    }

    public void decrement(View v){
        if (count <= 0) count = 0;
        else count--;
        value.setText("" + count);
    }

    @Override
    public void onBackPressed() {

        return;
    }
}