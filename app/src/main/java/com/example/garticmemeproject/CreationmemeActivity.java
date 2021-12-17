package com.example.garticmemeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
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
    private int nbjoueur;
    private int idjoueur;
    private String theme;
    public int randmeme = hazard();
    private int progressTime = 0;
    private TextView time;
    private ImageView imageView;
    private CountDownTimer countDownTimer;
    private long timeLeftInMilliseconds = 100000; //1 min 40      100000
    public static final String EXTRA_MESSAGE3 = "";
    public static final String EXTRA_MEME = "";
    private int progress = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        switch (randmeme){
            case 1 : setContentView(R.layout.activity_creationmeme1);break;
            case 2 : setContentView(R.layout.activity_creationmeme2);break;
            case 3 : setContentView(R.layout.activity_creationmeme3);break;
            case 4 : setContentView(R.layout.activity_creationmeme4);break;
            case 5 : setContentView(R.layout.activity_creationmeme5);break;
            case 6 : setContentView(R.layout.activity_creationmeme6);break;
            case 7 : setContentView(R.layout.activity_creationmeme7);break;
            case 8 : setContentView(R.layout.activity_creationmeme8);break;
            case 9 : setContentView(R.layout.activity_creationmeme9);break;
            case 10 : setContentView(R.layout.activity_creationmeme10);break;
            case 11 : setContentView(R.layout.activity_creationmeme11);break;
            case 12 : setContentView(R.layout.activity_creationmeme12);break;
            case 13 : setContentView(R.layout.activity_creationmeme13);break;
            case 14 : setContentView(R.layout.activity_creationmeme14);break;
            case 15 : setContentView(R.layout.activity_creationmeme15);break;
            case 16 : setContentView(R.layout.activity_creationmeme16);break;
            case 17 : setContentView(R.layout.activity_creationmeme17);break;
            case 18 : setContentView(R.layout.activity_creationmeme18);break;
            case 19 : setContentView(R.layout.activity_creationmeme19);break;
            case 20 : setContentView(R.layout.activity_creationmeme20);break;
            case 21 : setContentView(R.layout.activity_creationmeme21);break;
            case 22 : setContentView(R.layout.activity_creationmeme22);break;
            case 23 : setContentView(R.layout.activity_creationmeme23);break;
            case 24 : setContentView(R.layout.activity_creationmeme24);break;
            case 25 : setContentView(R.layout.activity_creationmeme25);break;
            case 26 : setContentView(R.layout.activity_creationmeme26);break;
            case 27 : setContentView(R.layout.activity_creationmeme27);break;
            case 28 : setContentView(R.layout.activity_creationmeme28);break;
            case 29 : setContentView(R.layout.activity_creationmeme29);break;
            case 30 : setContentView(R.layout.activity_creationmeme30);break;
        }
        //setContentView(R.layout.activity_creationmeme+randmeme);
        mp = MediaPlayer.create(this, R.raw.musica_ascenseur);

        data3 = getIntent().getExtras();

        String theme = data3.getString("THEME");
        TextView textView = findViewById(R.id.themecreate);
        textView.setText("Thème : " + theme);

//______________________________Image MEME__________________________________________________________________

        //ImageView imgMeme = (ImageView) findViewById(R.id.meme);
        //String imgName = "meme" + randmeme;
        //int id = getResources().getIdentifier(imgName, "drawable", getPackageName());
        //imgMeme.setImageResource(id);

//______________________________Image Profil__________________________________________________________________

        ImageView imgProfil = (ImageView) findViewById(R.id.imagejoueurx);
        int nbjoueur = data3.getInt("NBJOUEUR");

//______________________________idjoueur__________________________________________________________________

        int idjoueur = data3.getInt("IDJOUEUR");
        String imgPP = "profil" + idjoueur;
        int id2 = getResources().getIdentifier(imgPP, "drawable", getPackageName());
        imgProfil.setImageResource(id2);

//______________________________Bundle--------------------------------------------------------



//---------------------------------------Bouton---------------------------------------------------------------------------

        Button bouton;
        bouton = (Button) findViewById(R.id.buttoncreation);
        bouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                if (countDownTimer != null){
                    countDownTimer.cancel();
                }

                if (idjoueur < nbjoueur){
                    Intent intent = new Intent(
                            CreationmemeActivity.this,
                            PlayersActivity.class
                    );
                    data3.putInt("IDJOUEUR",idjoueur);

                    if (idjoueur == 1){
                        Bundle Joueur1 = new Bundle();
                        Joueur1.putInt("MEME",randmeme);
                        EditText editText1 = (EditText) findViewById(R.id.ecriture1);
                        String ecriture1 = editText1.getText().toString();
                        Joueur1.putString("ECRITURE1", ecriture1);
                        if (randmeme==1 || randmeme==3 || randmeme==5 || randmeme==7 || randmeme==11 || randmeme==13 || randmeme==14 || randmeme==22 || randmeme==24 || randmeme==25){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            Joueur1.putString("ECRITURE2", ecriture2);
                        }
                        if (randmeme==4 || randmeme==6 || randmeme==8 || randmeme==9 || randmeme==10 || randmeme==12 || randmeme==15 || randmeme==26){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            EditText editText3 = (EditText) findViewById(R.id.ecriture3);
                            String ecriture3 = editText3.getText().toString();
                            Joueur1.putString("ECRITURE2", ecriture2);
                            Joueur1.putString("ECRITURE3", ecriture3);
                        }
                        data3.putBundle("JOUEUR1",Joueur1);
                    }
                    if (idjoueur == 2){
                        Bundle Joueur2 = new Bundle();
                        Joueur2.putInt("MEME",randmeme);
                        EditText editText1 = (EditText) findViewById(R.id.ecriture1);
                        String ecriture1 = editText1.getText().toString();
                        Joueur2.putString("ECRITURE1", ecriture1);
                        if (randmeme==1 || randmeme==3 || randmeme==5 || randmeme==7 || randmeme==11 || randmeme==13 || randmeme==14 || randmeme==22 || randmeme==24 || randmeme==25){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            Joueur2.putString("ECRITURE2", ecriture2);
                        }
                        if (randmeme==4 || randmeme==6 || randmeme==8 || randmeme==9 || randmeme==10 || randmeme==12 || randmeme==15 || randmeme==26){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            EditText editText3 = (EditText) findViewById(R.id.ecriture3);
                            String ecriture3 = editText3.getText().toString();
                            Joueur2.putString("ECRITURE2", ecriture2);
                            Joueur2.putString("ECRITURE3", ecriture3);
                        }
                        data3.putBundle("JOUEUR2",Joueur2);
                    }
                    if (idjoueur == 3){
                        Bundle Joueur3 = new Bundle();
                        Joueur3.putInt("MEME",randmeme);
                        EditText editText1 = (EditText) findViewById(R.id.ecriture1);
                        String ecriture1 = editText1.getText().toString();
                        Joueur3.putString("ECRITURE1", ecriture1);
                        if (randmeme==1 || randmeme==3 || randmeme==5 || randmeme==7 || randmeme==11 || randmeme==13 || randmeme==14 || randmeme==22 || randmeme==24 || randmeme==25){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            Joueur3.putString("ECRITURE2", ecriture2);
                        }
                        if (randmeme==4 || randmeme==6 || randmeme==8 || randmeme==9 || randmeme==10 || randmeme==12 || randmeme==15 || randmeme==26){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            EditText editText3 = (EditText) findViewById(R.id.ecriture3);
                            String ecriture3 = editText3.getText().toString();
                            Joueur3.putString("ECRITURE2", ecriture2);
                            Joueur3.putString("ECRITURE3", ecriture3);
                        }
                        data3.putBundle("JOUEUR3",Joueur3);
                    }
                    if (idjoueur == 4){
                        Bundle Joueur4 = new Bundle();
                        Joueur4.putInt("MEME",randmeme);
                        EditText editText1 = (EditText) findViewById(R.id.ecriture1);
                        String ecriture1 = editText1.getText().toString();
                        Joueur4.putString("ECRITURE1", ecriture1);
                        if (randmeme==1 || randmeme==3 || randmeme==5 || randmeme==7 || randmeme==11 || randmeme==13 || randmeme==14 || randmeme==22 || randmeme==24 || randmeme==25){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            Joueur4.putString("ECRITURE2", ecriture2);
                        }
                        if (randmeme==4 || randmeme==6 || randmeme==8 || randmeme==9 || randmeme==10 || randmeme==12 || randmeme==15 || randmeme==26){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            EditText editText3 = (EditText) findViewById(R.id.ecriture3);
                            String ecriture3 = editText3.getText().toString();
                            Joueur4.putString("ECRITURE2", ecriture2);
                            Joueur4.putString("ECRITURE3", ecriture3);
                        }
                        data3.putBundle("JOUEUR4",Joueur4);
                    }
                    if (idjoueur == 5){
                        Bundle Joueur5 = new Bundle();
                        Joueur5.putInt("MEME",randmeme);
                        EditText editText1 = (EditText) findViewById(R.id.ecriture1);
                        String ecriture1 = editText1.getText().toString();
                        Joueur5.putString("ECRITURE1", ecriture1);
                        if (randmeme==1 || randmeme==3 || randmeme==5 || randmeme==7 || randmeme==11 || randmeme==13 || randmeme==14 || randmeme==22 || randmeme==24 || randmeme==25){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            Joueur5.putString("ECRITURE2", ecriture2);
                        }
                        if (randmeme==4 || randmeme==6 || randmeme==8 || randmeme==9 || randmeme==10 || randmeme==12 || randmeme==15 || randmeme==26){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            EditText editText3 = (EditText) findViewById(R.id.ecriture3);
                            String ecriture3 = editText3.getText().toString();
                            Joueur5.putString("ECRITURE2", ecriture2);
                            Joueur5.putString("ECRITURE3", ecriture3);
                        }
                        data3.putBundle("JOUEUR5",Joueur5);
                    }
                    if (idjoueur == 6){
                        Bundle Joueur6 = new Bundle();
                        Joueur6.putInt("MEME",randmeme);
                        EditText editText1 = (EditText) findViewById(R.id.ecriture1);
                        String ecriture1 = editText1.getText().toString();
                        Joueur6.putString("ECRITURE1", ecriture1);
                        if (randmeme==1 || randmeme==3 || randmeme==5 || randmeme==7 || randmeme==11 || randmeme==13 || randmeme==14 || randmeme==22 || randmeme==24 || randmeme==25){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            Joueur6.putString("ECRITURE2", ecriture2);
                        }
                        if (randmeme==4 || randmeme==6 || randmeme==8 || randmeme==9 || randmeme==10 || randmeme==12 || randmeme==15 || randmeme==26){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            EditText editText3 = (EditText) findViewById(R.id.ecriture3);
                            String ecriture3 = editText3.getText().toString();
                            Joueur6.putString("ECRITURE2", ecriture2);
                            Joueur6.putString("ECRITURE3", ecriture3);
                        }
                        data3.putBundle("JOUEUR6",Joueur6);
                    }
                    if (idjoueur == 7){
                        Bundle Joueur7 = new Bundle();
                        Joueur7.putInt("MEME",randmeme);
                        EditText editText1 = (EditText) findViewById(R.id.ecriture1);
                        String ecriture1 = editText1.getText().toString();
                        Joueur7.putString("ECRITURE1", ecriture1);
                        if (randmeme==1 || randmeme==3 || randmeme==5 || randmeme==7 || randmeme==11 || randmeme==13 || randmeme==14 || randmeme==22 || randmeme==24 || randmeme==25){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            Joueur7.putString("ECRITURE2", ecriture2);
                        }
                        if (randmeme==4 || randmeme==6 || randmeme==8 || randmeme==9 || randmeme==10 || randmeme==12 || randmeme==15 || randmeme==26){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            EditText editText3 = (EditText) findViewById(R.id.ecriture3);
                            String ecriture3 = editText3.getText().toString();
                            Joueur7.putString("ECRITURE2", ecriture2);
                            Joueur7.putString("ECRITURE3", ecriture3);
                        }
                        data3.putBundle("JOUEUR7",Joueur7);
                    }
                    if (idjoueur == 8){
                        Bundle Joueur8 = new Bundle();
                        Joueur8.putInt("MEME",randmeme);
                        EditText editText1 = (EditText) findViewById(R.id.ecriture1);
                        String ecriture1 = editText1.getText().toString();
                        Joueur8.putString("ECRITURE1", ecriture1);
                        if (randmeme==1 || randmeme==3 || randmeme==5 || randmeme==7 || randmeme==11 || randmeme==13 || randmeme==14 || randmeme==22 || randmeme==24 || randmeme==25){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            Joueur8.putString("ECRITURE2", ecriture2);
                        }
                        if (randmeme==4 || randmeme==6 || randmeme==8 || randmeme==9 || randmeme==10 || randmeme==12 || randmeme==15 || randmeme==26){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            EditText editText3 = (EditText) findViewById(R.id.ecriture3);
                            String ecriture3 = editText3.getText().toString();
                            Joueur8.putString("ECRITURE2", ecriture2);
                            Joueur8.putString("ECRITURE3", ecriture3);
                        }
                        data3.putBundle("JOUEUR8",Joueur8);
                    }
                    if (idjoueur == 9){
                        Bundle Joueur9 = new Bundle();
                        Joueur9.putInt("MEME",randmeme);
                        EditText editText1 = (EditText) findViewById(R.id.ecriture1);
                        String ecriture1 = editText1.getText().toString();
                        Joueur9.putString("ECRITURE1", ecriture1);
                        if (randmeme==1 || randmeme==3 || randmeme==5 || randmeme==7 || randmeme==11 || randmeme==13 || randmeme==14 || randmeme==22 || randmeme==24 || randmeme==25){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            Joueur9.putString("ECRITURE2", ecriture2);
                        }
                        if (randmeme==4 || randmeme==6 || randmeme==8 || randmeme==9 || randmeme==10 || randmeme==12 || randmeme==15 || randmeme==26){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            EditText editText3 = (EditText) findViewById(R.id.ecriture3);
                            String ecriture3 = editText3.getText().toString();
                            Joueur9.putString("ECRITURE2", ecriture2);
                            Joueur9.putString("ECRITURE3", ecriture3);
                        }
                        data3.putBundle("JOUEUR9",Joueur9);
                    }
                    if (idjoueur == 10){
                        Bundle Joueur10 = new Bundle();
                        Joueur10.putInt("MEME",randmeme);
                        EditText editText1 = (EditText) findViewById(R.id.ecriture1);
                        String ecriture1 = editText1.getText().toString();
                        Joueur10.putString("ECRITURE1", ecriture1);
                        if (randmeme==1 || randmeme==3 || randmeme==5 || randmeme==7 || randmeme==11 || randmeme==13 || randmeme==14 || randmeme==22 || randmeme==24 || randmeme==25){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            Joueur10.putString("ECRITURE2", ecriture2);
                        }
                        if (randmeme==4 || randmeme==6 || randmeme==8 || randmeme==9 || randmeme==10 || randmeme==12 || randmeme==15 || randmeme==26){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            EditText editText3 = (EditText) findViewById(R.id.ecriture3);
                            String ecriture3 = editText3.getText().toString();
                            Joueur10.putString("ECRITURE2", ecriture2);
                            Joueur10.putString("ECRITURE3", ecriture3);
                        }
                        data3.putBundle("JOUEUR10",Joueur10);
                    }
                    intent.putExtras(data3);
                    startActivity(intent);
                }
                else if (idjoueur >= nbjoueur){
                    Intent intent = new Intent(
                            CreationmemeActivity.this,
                            VoteActivity.class
                    );
                    data3.putInt("IDJOUEUR",idjoueur);

                    if (idjoueur == 1){
                        Bundle Joueur1 = new Bundle();
                        Joueur1.putInt("MEME",randmeme);
                        EditText editText1 = (EditText) findViewById(R.id.ecriture1);
                        String ecriture1 = editText1.getText().toString();
                        Joueur1.putString("ECRITURE1", ecriture1);
                        if (randmeme==1 || randmeme==3 || randmeme==5 || randmeme==7 || randmeme==11 || randmeme==13 || randmeme==14 || randmeme==22 || randmeme==24 || randmeme==25){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            Joueur1.putString("ECRITURE2", ecriture2);
                        }
                        if (randmeme==4 || randmeme==6 || randmeme==8 || randmeme==9 || randmeme==10 || randmeme==12 || randmeme==15 || randmeme==26){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            EditText editText3 = (EditText) findViewById(R.id.ecriture3);
                            String ecriture3 = editText3.getText().toString();
                            Joueur1.putString("ECRITURE2", ecriture2);
                            Joueur1.putString("ECRITURE3", ecriture3);
                        }
                        data3.putBundle("JOUEUR1",Joueur1);
                    }
                    if (idjoueur == 2){
                        Bundle Joueur2 = new Bundle();
                        Joueur2.putInt("MEME",randmeme);
                        EditText editText1 = (EditText) findViewById(R.id.ecriture1);
                        String ecriture1 = editText1.getText().toString();
                        Joueur2.putString("ECRITURE1", ecriture1);
                        if (randmeme==1 || randmeme==3 || randmeme==5 || randmeme==7 || randmeme==11 || randmeme==13 || randmeme==14 || randmeme==22 || randmeme==24 || randmeme==25){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            Joueur2.putString("ECRITURE2", ecriture2);
                        }
                        if (randmeme==4 || randmeme==6 || randmeme==8 || randmeme==9 || randmeme==10 || randmeme==12 || randmeme==15 || randmeme==26){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            EditText editText3 = (EditText) findViewById(R.id.ecriture3);
                            String ecriture3 = editText3.getText().toString();
                            Joueur2.putString("ECRITURE2", ecriture2);
                            Joueur2.putString("ECRITURE3", ecriture3);
                        }
                        data3.putBundle("JOUEUR2",Joueur2);
                    }
                    if (idjoueur == 3){
                        Bundle Joueur3 = new Bundle();
                        Joueur3.putInt("MEME",randmeme);
                        EditText editText1 = (EditText) findViewById(R.id.ecriture1);
                        String ecriture1 = editText1.getText().toString();
                        Joueur3.putString("ECRITURE1", ecriture1);
                        if (randmeme==1 || randmeme==3 || randmeme==5 || randmeme==7 || randmeme==11 || randmeme==13 || randmeme==14 || randmeme==22 || randmeme==24 || randmeme==25){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            Joueur3.putString("ECRITURE2", ecriture2);
                        }
                        if (randmeme==4 || randmeme==6 || randmeme==8 || randmeme==9 || randmeme==10 || randmeme==12 || randmeme==15 || randmeme==26){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            EditText editText3 = (EditText) findViewById(R.id.ecriture3);
                            String ecriture3 = editText3.getText().toString();
                            Joueur3.putString("ECRITURE2", ecriture2);
                            Joueur3.putString("ECRITURE3", ecriture3);
                        }
                        data3.putBundle("JOUEUR3",Joueur3);
                    }
                    if (idjoueur == 4){
                        Bundle Joueur4 = new Bundle();
                        Joueur4.putInt("MEME",randmeme);
                        EditText editText1 = (EditText) findViewById(R.id.ecriture1);
                        String ecriture1 = editText1.getText().toString();
                        Joueur4.putString("ECRITURE1", ecriture1);
                        if (randmeme==1 || randmeme==3 || randmeme==5 || randmeme==7 || randmeme==11 || randmeme==13 || randmeme==14 || randmeme==22 || randmeme==24 || randmeme==25){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            Joueur4.putString("ECRITURE2", ecriture2);
                        }
                        if (randmeme==4 || randmeme==6 || randmeme==8 || randmeme==9 || randmeme==10 || randmeme==12 || randmeme==15 || randmeme==26){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            EditText editText3 = (EditText) findViewById(R.id.ecriture3);
                            String ecriture3 = editText3.getText().toString();
                            Joueur4.putString("ECRITURE2", ecriture2);
                            Joueur4.putString("ECRITURE3", ecriture3);
                        }
                        data3.putBundle("JOUEUR4",Joueur4);
                    }
                    if (idjoueur == 5){
                        Bundle Joueur5 = new Bundle();
                        Joueur5.putInt("MEME",randmeme);
                        EditText editText1 = (EditText) findViewById(R.id.ecriture1);
                        String ecriture1 = editText1.getText().toString();
                        Joueur5.putString("ECRITURE1", ecriture1);
                        if (randmeme==1 || randmeme==3 || randmeme==5 || randmeme==7 || randmeme==11 || randmeme==13 || randmeme==14 || randmeme==22 || randmeme==24 || randmeme==25){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            Joueur5.putString("ECRITURE2", ecriture2);
                        }
                        if (randmeme==4 || randmeme==6 || randmeme==8 || randmeme==9 || randmeme==10 || randmeme==12 || randmeme==15 || randmeme==26){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            EditText editText3 = (EditText) findViewById(R.id.ecriture3);
                            String ecriture3 = editText3.getText().toString();
                            Joueur5.putString("ECRITURE2", ecriture2);
                            Joueur5.putString("ECRITURE3", ecriture3);
                        }
                        data3.putBundle("JOUEUR5",Joueur5);
                    }
                    if (idjoueur == 6){
                        Bundle Joueur6 = new Bundle();
                        Joueur6.putInt("MEME",randmeme);
                        EditText editText1 = (EditText) findViewById(R.id.ecriture1);
                        String ecriture1 = editText1.getText().toString();
                        Joueur6.putString("ECRITURE1", ecriture1);
                        if (randmeme==1 || randmeme==3 || randmeme==5 || randmeme==7 || randmeme==11 || randmeme==13 || randmeme==14 || randmeme==22 || randmeme==24 || randmeme==25){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            Joueur6.putString("ECRITURE2", ecriture2);
                        }
                        if (randmeme==4 || randmeme==6 || randmeme==8 || randmeme==9 || randmeme==10 || randmeme==12 || randmeme==15 || randmeme==26){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            EditText editText3 = (EditText) findViewById(R.id.ecriture3);
                            String ecriture3 = editText3.getText().toString();
                            Joueur6.putString("ECRITURE2", ecriture2);
                            Joueur6.putString("ECRITURE3", ecriture3);
                        }
                        data3.putBundle("JOUEUR6",Joueur6);
                    }
                    if (idjoueur == 7){
                        Bundle Joueur7 = new Bundle();
                        Joueur7.putInt("MEME",randmeme);
                        EditText editText1 = (EditText) findViewById(R.id.ecriture1);
                        String ecriture1 = editText1.getText().toString();
                        Joueur7.putString("ECRITURE1", ecriture1);
                        if (randmeme==1 || randmeme==3 || randmeme==5 || randmeme==7 || randmeme==11 || randmeme==13 || randmeme==14 || randmeme==22 || randmeme==24 || randmeme==25){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            Joueur7.putString("ECRITURE2", ecriture2);
                        }
                        if (randmeme==4 || randmeme==6 || randmeme==8 || randmeme==9 || randmeme==10 || randmeme==12 || randmeme==15 || randmeme==26){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            EditText editText3 = (EditText) findViewById(R.id.ecriture3);
                            String ecriture3 = editText3.getText().toString();
                            Joueur7.putString("ECRITURE2", ecriture2);
                            Joueur7.putString("ECRITURE3", ecriture3);
                        }
                        data3.putBundle("JOUEUR7",Joueur7);
                    }
                    if (idjoueur == 8){
                        Bundle Joueur8 = new Bundle();
                        Joueur8.putInt("MEME",randmeme);
                        EditText editText1 = (EditText) findViewById(R.id.ecriture1);
                        String ecriture1 = editText1.getText().toString();
                        Joueur8.putString("ECRITURE1", ecriture1);
                        if (randmeme==1 || randmeme==3 || randmeme==5 || randmeme==7 || randmeme==11 || randmeme==13 || randmeme==14 || randmeme==22 || randmeme==24 || randmeme==25){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            Joueur8.putString("ECRITURE2", ecriture2);
                        }
                        if (randmeme==4 || randmeme==6 || randmeme==8 || randmeme==9 || randmeme==10 || randmeme==12 || randmeme==15 || randmeme==26){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            EditText editText3 = (EditText) findViewById(R.id.ecriture3);
                            String ecriture3 = editText3.getText().toString();
                            Joueur8.putString("ECRITURE2", ecriture2);
                            Joueur8.putString("ECRITURE3", ecriture3);
                        }
                        data3.putBundle("JOUEUR8",Joueur8);
                    }
                    if (idjoueur == 9){
                        Bundle Joueur9 = new Bundle();
                        Joueur9.putInt("MEME",randmeme);
                        EditText editText1 = (EditText) findViewById(R.id.ecriture1);
                        String ecriture1 = editText1.getText().toString();
                        Joueur9.putString("ECRITURE1", ecriture1);
                        if (randmeme==1 || randmeme==3 || randmeme==5 || randmeme==7 || randmeme==11 || randmeme==13 || randmeme==14 || randmeme==22 || randmeme==24 || randmeme==25){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            Joueur9.putString("ECRITURE2", ecriture2);
                        }
                        if (randmeme==4 || randmeme==6 || randmeme==8 || randmeme==9 || randmeme==10 || randmeme==12 || randmeme==15 || randmeme==26){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            EditText editText3 = (EditText) findViewById(R.id.ecriture3);
                            String ecriture3 = editText3.getText().toString();
                            Joueur9.putString("ECRITURE2", ecriture2);
                            Joueur9.putString("ECRITURE3", ecriture3);
                        }
                        data3.putBundle("JOUEUR9",Joueur9);
                    }
                    if (idjoueur == 10){
                        Bundle Joueur10 = new Bundle();
                        Joueur10.putInt("MEME",randmeme);
                        EditText editText1 = (EditText) findViewById(R.id.ecriture1);
                        String ecriture1 = editText1.getText().toString();
                        Joueur10.putString("ECRITURE1", ecriture1);
                        if (randmeme==1 || randmeme==3 || randmeme==5 || randmeme==7 || randmeme==11 || randmeme==13 || randmeme==14 || randmeme==22 || randmeme==24 || randmeme==25){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            Joueur10.putString("ECRITURE2", ecriture2);
                        }
                        if (randmeme==4 || randmeme==6 || randmeme==8 || randmeme==9 || randmeme==10 || randmeme==12 || randmeme==15 || randmeme==26){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            EditText editText3 = (EditText) findViewById(R.id.ecriture3);
                            String ecriture3 = editText3.getText().toString();
                            Joueur10.putString("ECRITURE2", ecriture2);
                            Joueur10.putString("ECRITURE3", ecriture3);
                        }
                        data3.putBundle("JOUEUR10",Joueur10);
                    }
                    intent.putExtras(data3);
                    startActivity(intent);
                }

            }
        });

        time = (TextView)findViewById(R.id.time);
        updateTimer();
        startTimer();
    }

//----------------------------------------Timer--------------------------------------------------------------------------
    public void startTimer(){
        countDownTimer = new CountDownTimer(timeLeftInMilliseconds, 1000) {
            @Override
            public void onTick(long l) {
                timeLeftInMilliseconds = l;
                updateTimer();
            }

            @Override
            public void onFinish() {
                int nbjoueur = data3.getInt("NBJOUEUR");
                int idjoueur = data3.getInt("IDJOUEUR");
                if (idjoueur < nbjoueur){
                    Intent intent = new Intent(
                            CreationmemeActivity.this,
                            PlayersActivity.class
                    );
                    if (idjoueur == 1){
                        Bundle Joueur1 = new Bundle();
                        Joueur1.putInt("MEME",randmeme);
                        EditText editText1 = (EditText) findViewById(R.id.ecriture1);
                        String ecriture1 = editText1.getText().toString();
                        Joueur1.putString("ECRITURE1", ecriture1);
                        if (randmeme==1 || randmeme==3 || randmeme==5 || randmeme==7 || randmeme==11 || randmeme==13 || randmeme==14 || randmeme==22 || randmeme==24 || randmeme==25){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            Joueur1.putString("ECRITURE2", ecriture2);
                        }
                        if (randmeme==4 || randmeme==6 || randmeme==8 || randmeme==9 || randmeme==10 || randmeme==12 || randmeme==15 || randmeme==26){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            EditText editText3 = (EditText) findViewById(R.id.ecriture3);
                            String ecriture3 = editText3.getText().toString();
                            Joueur1.putString("ECRITURE2", ecriture2);
                            Joueur1.putString("ECRITURE3", ecriture3);
                        }
                        data3.putBundle("JOUEUR1",Joueur1);
                    }
                    if (idjoueur == 2){
                        Bundle Joueur2 = new Bundle();
                        Joueur2.putInt("MEME",randmeme);
                        EditText editText1 = (EditText) findViewById(R.id.ecriture1);
                        String ecriture1 = editText1.getText().toString();
                        Joueur2.putString("ECRITURE1", ecriture1);
                        if (randmeme==1 || randmeme==3 || randmeme==5 || randmeme==7 || randmeme==11 || randmeme==13 || randmeme==14 || randmeme==22 || randmeme==24 || randmeme==25){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            Joueur2.putString("ECRITURE2", ecriture2);
                        }
                        if (randmeme==4 || randmeme==6 || randmeme==8 || randmeme==9 || randmeme==10 || randmeme==12 || randmeme==15 || randmeme==26){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            EditText editText3 = (EditText) findViewById(R.id.ecriture3);
                            String ecriture3 = editText3.getText().toString();
                            Joueur2.putString("ECRITURE2", ecriture2);
                            Joueur2.putString("ECRITURE3", ecriture3);
                        }
                        data3.putBundle("JOUEUR2",Joueur2);
                    }
                    if (idjoueur == 3){
                        Bundle Joueur3 = new Bundle();
                        Joueur3.putInt("MEME",randmeme);
                        EditText editText1 = (EditText) findViewById(R.id.ecriture1);
                        String ecriture1 = editText1.getText().toString();
                        Joueur3.putString("ECRITURE1", ecriture1);
                        if (randmeme==1 || randmeme==3 || randmeme==5 || randmeme==7 || randmeme==11 || randmeme==13 || randmeme==14 || randmeme==22 || randmeme==24 || randmeme==25){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            Joueur3.putString("ECRITURE2", ecriture2);
                        }
                        if (randmeme==4 || randmeme==6 || randmeme==8 || randmeme==9 || randmeme==10 || randmeme==12 || randmeme==15 || randmeme==26){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            EditText editText3 = (EditText) findViewById(R.id.ecriture3);
                            String ecriture3 = editText3.getText().toString();
                            Joueur3.putString("ECRITURE2", ecriture2);
                            Joueur3.putString("ECRITURE3", ecriture3);
                        }
                        data3.putBundle("JOUEUR3",Joueur3);
                    }
                    if (idjoueur == 4){
                        Bundle Joueur4 = new Bundle();
                        Joueur4.putInt("MEME",randmeme);
                        EditText editText1 = (EditText) findViewById(R.id.ecriture1);
                        String ecriture1 = editText1.getText().toString();
                        Joueur4.putString("ECRITURE1", ecriture1);
                        if (randmeme==1 || randmeme==3 || randmeme==5 || randmeme==7 || randmeme==11 || randmeme==13 || randmeme==14 || randmeme==22 || randmeme==24 || randmeme==25){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            Joueur4.putString("ECRITURE2", ecriture2);
                        }
                        if (randmeme==4 || randmeme==6 || randmeme==8 || randmeme==9 || randmeme==10 || randmeme==12 || randmeme==15 || randmeme==26){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            EditText editText3 = (EditText) findViewById(R.id.ecriture3);
                            String ecriture3 = editText3.getText().toString();
                            Joueur4.putString("ECRITURE2", ecriture2);
                            Joueur4.putString("ECRITURE3", ecriture3);
                        }
                        data3.putBundle("JOUEUR4",Joueur4);
                    }
                    if (idjoueur == 5){
                        Bundle Joueur5 = new Bundle();
                        Joueur5.putInt("MEME",randmeme);
                        EditText editText1 = (EditText) findViewById(R.id.ecriture1);
                        String ecriture1 = editText1.getText().toString();
                        Joueur5.putString("ECRITURE1", ecriture1);
                        if (randmeme==1 || randmeme==3 || randmeme==5 || randmeme==7 || randmeme==11 || randmeme==13 || randmeme==14 || randmeme==22 || randmeme==24 || randmeme==25){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            Joueur5.putString("ECRITURE2", ecriture2);
                        }
                        if (randmeme==4 || randmeme==6 || randmeme==8 || randmeme==9 || randmeme==10 || randmeme==12 || randmeme==15 || randmeme==26){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            EditText editText3 = (EditText) findViewById(R.id.ecriture3);
                            String ecriture3 = editText3.getText().toString();
                            Joueur5.putString("ECRITURE2", ecriture2);
                            Joueur5.putString("ECRITURE3", ecriture3);
                        }
                        data3.putBundle("JOUEUR5",Joueur5);
                    }
                    if (idjoueur == 6){
                        Bundle Joueur6 = new Bundle();
                        Joueur6.putInt("MEME",randmeme);
                        EditText editText1 = (EditText) findViewById(R.id.ecriture1);
                        String ecriture1 = editText1.getText().toString();
                        Joueur6.putString("ECRITURE1", ecriture1);
                        if (randmeme==1 || randmeme==3 || randmeme==5 || randmeme==7 || randmeme==11 || randmeme==13 || randmeme==14 || randmeme==22 || randmeme==24 || randmeme==25){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            Joueur6.putString("ECRITURE2", ecriture2);
                        }
                        if (randmeme==4 || randmeme==6 || randmeme==8 || randmeme==9 || randmeme==10 || randmeme==12 || randmeme==15 || randmeme==26){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            EditText editText3 = (EditText) findViewById(R.id.ecriture3);
                            String ecriture3 = editText3.getText().toString();
                            Joueur6.putString("ECRITURE2", ecriture2);
                            Joueur6.putString("ECRITURE3", ecriture3);
                        }
                        data3.putBundle("JOUEUR6",Joueur6);
                    }
                    if (idjoueur == 7){
                        Bundle Joueur7 = new Bundle();
                        Joueur7.putInt("MEME",randmeme);
                        EditText editText1 = (EditText) findViewById(R.id.ecriture1);
                        String ecriture1 = editText1.getText().toString();
                        Joueur7.putString("ECRITURE1", ecriture1);
                        if (randmeme==1 || randmeme==3 || randmeme==5 || randmeme==7 || randmeme==11 || randmeme==13 || randmeme==14 || randmeme==22 || randmeme==24 || randmeme==25){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            Joueur7.putString("ECRITURE2", ecriture2);
                        }
                        if (randmeme==4 || randmeme==6 || randmeme==8 || randmeme==9 || randmeme==10 || randmeme==12 || randmeme==15 || randmeme==26){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            EditText editText3 = (EditText) findViewById(R.id.ecriture3);
                            String ecriture3 = editText3.getText().toString();
                            Joueur7.putString("ECRITURE2", ecriture2);
                            Joueur7.putString("ECRITURE3", ecriture3);
                        }
                        data3.putBundle("JOUEUR7",Joueur7);
                    }
                    if (idjoueur == 8){
                        Bundle Joueur8 = new Bundle();
                        Joueur8.putInt("MEME",randmeme);
                        EditText editText1 = (EditText) findViewById(R.id.ecriture1);
                        String ecriture1 = editText1.getText().toString();
                        Joueur8.putString("ECRITURE1", ecriture1);
                        if (randmeme==1 || randmeme==3 || randmeme==5 || randmeme==7 || randmeme==11 || randmeme==13 || randmeme==14 || randmeme==22 || randmeme==24 || randmeme==25){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            Joueur8.putString("ECRITURE2", ecriture2);
                        }
                        if (randmeme==4 || randmeme==6 || randmeme==8 || randmeme==9 || randmeme==10 || randmeme==12 || randmeme==15 || randmeme==26){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            EditText editText3 = (EditText) findViewById(R.id.ecriture3);
                            String ecriture3 = editText3.getText().toString();
                            Joueur8.putString("ECRITURE2", ecriture2);
                            Joueur8.putString("ECRITURE3", ecriture3);
                        }
                        data3.putBundle("JOUEUR8",Joueur8);
                    }
                    if (idjoueur == 9){
                        Bundle Joueur9 = new Bundle();
                        Joueur9.putInt("MEME",randmeme);
                        EditText editText1 = (EditText) findViewById(R.id.ecriture1);
                        String ecriture1 = editText1.getText().toString();
                        Joueur9.putString("ECRITURE1", ecriture1);
                        if (randmeme==1 || randmeme==3 || randmeme==5 || randmeme==7 || randmeme==11 || randmeme==13 || randmeme==14 || randmeme==22 || randmeme==24 || randmeme==25){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            Joueur9.putString("ECRITURE2", ecriture2);
                        }
                        if (randmeme==4 || randmeme==6 || randmeme==8 || randmeme==9 || randmeme==10 || randmeme==12 || randmeme==15 || randmeme==26){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            EditText editText3 = (EditText) findViewById(R.id.ecriture3);
                            String ecriture3 = editText3.getText().toString();
                            Joueur9.putString("ECRITURE2", ecriture2);
                            Joueur9.putString("ECRITURE3", ecriture3);
                        }
                        data3.putBundle("JOUEUR9",Joueur9);
                    }
                    if (idjoueur == 10){
                        Bundle Joueur10 = new Bundle();
                        Joueur10.putInt("MEME",randmeme);
                        EditText editText1 = (EditText) findViewById(R.id.ecriture1);
                        String ecriture1 = editText1.getText().toString();
                        Joueur10.putString("ECRITURE1", ecriture1);
                        if (randmeme==1 || randmeme==3 || randmeme==5 || randmeme==7 || randmeme==11 || randmeme==13 || randmeme==14 || randmeme==22 || randmeme==24 || randmeme==25){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            Joueur10.putString("ECRITURE2", ecriture2);
                        }
                        if (randmeme==4 || randmeme==6 || randmeme==8 || randmeme==9 || randmeme==10 || randmeme==12 || randmeme==15 || randmeme==26){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            EditText editText3 = (EditText) findViewById(R.id.ecriture3);
                            String ecriture3 = editText3.getText().toString();
                            Joueur10.putString("ECRITURE2", ecriture2);
                            Joueur10.putString("ECRITURE3", ecriture3);
                        }
                        data3.putBundle("JOUEUR10",Joueur10);
                    }
                    data3.putInt("IDJOUEUR",idjoueur);
                    intent.putExtras(data3);
                    startActivity(intent);
                }
                else if (idjoueur >= nbjoueur){
                    Intent intent = new Intent(
                            CreationmemeActivity.this,
                            VoteActivity.class
                    );
                    if (idjoueur == 1){
                        Bundle Joueur1 = new Bundle();
                        Joueur1.putInt("MEME",randmeme);
                        EditText editText1 = (EditText) findViewById(R.id.ecriture1);
                        String ecriture1 = editText1.getText().toString();
                        Joueur1.putString("ECRITURE1", ecriture1);
                        if (randmeme==1 || randmeme==3 || randmeme==5 || randmeme==7 || randmeme==11 || randmeme==13 || randmeme==14 || randmeme==22 || randmeme==24 || randmeme==25){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            Joueur1.putString("ECRITURE2", ecriture2);
                        }
                        if (randmeme==4 || randmeme==6 || randmeme==8 || randmeme==9 || randmeme==10 || randmeme==12 || randmeme==15 || randmeme==26){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            EditText editText3 = (EditText) findViewById(R.id.ecriture3);
                            String ecriture3 = editText3.getText().toString();
                            Joueur1.putString("ECRITURE2", ecriture2);
                            Joueur1.putString("ECRITURE3", ecriture3);
                        }
                        data3.putBundle("JOUEUR1",Joueur1);
                    }
                    if (idjoueur == 2){
                        Bundle Joueur2 = new Bundle();
                        Joueur2.putInt("MEME",randmeme);
                        EditText editText1 = (EditText) findViewById(R.id.ecriture1);
                        String ecriture1 = editText1.getText().toString();
                        Joueur2.putString("ECRITURE1", ecriture1);
                        if (randmeme==1 || randmeme==3 || randmeme==5 || randmeme==7 || randmeme==11 || randmeme==13 || randmeme==14 || randmeme==22 || randmeme==24 || randmeme==25){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            Joueur2.putString("ECRITURE2", ecriture2);
                        }
                        if (randmeme==4 || randmeme==6 || randmeme==8 || randmeme==9 || randmeme==10 || randmeme==12 || randmeme==15 || randmeme==26){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            EditText editText3 = (EditText) findViewById(R.id.ecriture3);
                            String ecriture3 = editText3.getText().toString();
                            Joueur2.putString("ECRITURE2", ecriture2);
                            Joueur2.putString("ECRITURE3", ecriture3);
                        }
                        data3.putBundle("JOUEUR2",Joueur2);
                    }
                    if (idjoueur == 3){
                        Bundle Joueur3 = new Bundle();
                        Joueur3.putInt("MEME",randmeme);
                        EditText editText1 = (EditText) findViewById(R.id.ecriture1);
                        String ecriture1 = editText1.getText().toString();
                        Joueur3.putString("ECRITURE1", ecriture1);
                        if (randmeme==1 || randmeme==3 || randmeme==5 || randmeme==7 || randmeme==11 || randmeme==13 || randmeme==14 || randmeme==22 || randmeme==24 || randmeme==25){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            Joueur3.putString("ECRITURE2", ecriture2);
                        }
                        if (randmeme==4 || randmeme==6 || randmeme==8 || randmeme==9 || randmeme==10 || randmeme==12 || randmeme==15 || randmeme==26){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            EditText editText3 = (EditText) findViewById(R.id.ecriture3);
                            String ecriture3 = editText3.getText().toString();
                            Joueur3.putString("ECRITURE2", ecriture2);
                            Joueur3.putString("ECRITURE3", ecriture3);
                        }
                        data3.putBundle("JOUEUR3",Joueur3);
                    }
                    if (idjoueur == 4){
                        Bundle Joueur4 = new Bundle();
                        Joueur4.putInt("MEME",randmeme);
                        EditText editText1 = (EditText) findViewById(R.id.ecriture1);
                        String ecriture1 = editText1.getText().toString();
                        Joueur4.putString("ECRITURE1", ecriture1);
                        if (randmeme==1 || randmeme==3 || randmeme==5 || randmeme==7 || randmeme==11 || randmeme==13 || randmeme==14 || randmeme==22 || randmeme==24 || randmeme==25){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            Joueur4.putString("ECRITURE2", ecriture2);
                        }
                        if (randmeme==4 || randmeme==6 || randmeme==8 || randmeme==9 || randmeme==10 || randmeme==12 || randmeme==15 || randmeme==26){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            EditText editText3 = (EditText) findViewById(R.id.ecriture3);
                            String ecriture3 = editText3.getText().toString();
                            Joueur4.putString("ECRITURE2", ecriture2);
                            Joueur4.putString("ECRITURE3", ecriture3);
                        }
                        data3.putBundle("JOUEUR4",Joueur4);
                    }
                    if (idjoueur == 5){
                        Bundle Joueur5 = new Bundle();
                        Joueur5.putInt("MEME",randmeme);
                        EditText editText1 = (EditText) findViewById(R.id.ecriture1);
                        String ecriture1 = editText1.getText().toString();
                        Joueur5.putString("ECRITURE1", ecriture1);
                        if (randmeme==1 || randmeme==3 || randmeme==5 || randmeme==7 || randmeme==11 || randmeme==13 || randmeme==14 || randmeme==22 || randmeme==24 || randmeme==25){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            Joueur5.putString("ECRITURE2", ecriture2);
                        }
                        if (randmeme==4 || randmeme==6 || randmeme==8 || randmeme==9 || randmeme==10 || randmeme==12 || randmeme==15 || randmeme==26){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            EditText editText3 = (EditText) findViewById(R.id.ecriture3);
                            String ecriture3 = editText3.getText().toString();
                            Joueur5.putString("ECRITURE2", ecriture2);
                            Joueur5.putString("ECRITURE3", ecriture3);
                        }
                        data3.putBundle("JOUEUR5",Joueur5);
                    }
                    if (idjoueur == 6){
                        Bundle Joueur6 = new Bundle();
                        Joueur6.putInt("MEME",randmeme);
                        EditText editText1 = (EditText) findViewById(R.id.ecriture1);
                        String ecriture1 = editText1.getText().toString();
                        Joueur6.putString("ECRITURE1", ecriture1);
                        if (randmeme==1 || randmeme==3 || randmeme==5 || randmeme==7 || randmeme==11 || randmeme==13 || randmeme==14 || randmeme==22 || randmeme==24 || randmeme==25){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            Joueur6.putString("ECRITURE2", ecriture2);
                        }
                        if (randmeme==4 || randmeme==6 || randmeme==8 || randmeme==9 || randmeme==10 || randmeme==12 || randmeme==15 || randmeme==26){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            EditText editText3 = (EditText) findViewById(R.id.ecriture3);
                            String ecriture3 = editText3.getText().toString();
                            Joueur6.putString("ECRITURE2", ecriture2);
                            Joueur6.putString("ECRITURE3", ecriture3);
                        }
                        data3.putBundle("JOUEUR6",Joueur6);
                    }
                    if (idjoueur == 7){
                        Bundle Joueur7 = new Bundle();
                        Joueur7.putInt("MEME",randmeme);
                        EditText editText1 = (EditText) findViewById(R.id.ecriture1);
                        String ecriture1 = editText1.getText().toString();
                        Joueur7.putString("ECRITURE1", ecriture1);
                        if (randmeme==1 || randmeme==3 || randmeme==5 || randmeme==7 || randmeme==11 || randmeme==13 || randmeme==14 || randmeme==22 || randmeme==24 || randmeme==25){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            Joueur7.putString("ECRITURE2", ecriture2);
                        }
                        if (randmeme==4 || randmeme==6 || randmeme==8 || randmeme==9 || randmeme==10 || randmeme==12 || randmeme==15 || randmeme==26){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            EditText editText3 = (EditText) findViewById(R.id.ecriture3);
                            String ecriture3 = editText3.getText().toString();
                            Joueur7.putString("ECRITURE2", ecriture2);
                            Joueur7.putString("ECRITURE3", ecriture3);
                        }
                        data3.putBundle("JOUEUR7",Joueur7);
                    }
                    if (idjoueur == 8){
                        Bundle Joueur8 = new Bundle();
                        Joueur8.putInt("MEME",randmeme);
                        EditText editText1 = (EditText) findViewById(R.id.ecriture1);
                        String ecriture1 = editText1.getText().toString();
                        Joueur8.putString("ECRITURE1", ecriture1);
                        if (randmeme==1 || randmeme==3 || randmeme==5 || randmeme==7 || randmeme==11 || randmeme==13 || randmeme==14 || randmeme==22 || randmeme==24 || randmeme==25){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            Joueur8.putString("ECRITURE2", ecriture2);
                        }
                        if (randmeme==4 || randmeme==6 || randmeme==8 || randmeme==9 || randmeme==10 || randmeme==12 || randmeme==15 || randmeme==26){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            EditText editText3 = (EditText) findViewById(R.id.ecriture3);
                            String ecriture3 = editText3.getText().toString();
                            Joueur8.putString("ECRITURE2", ecriture2);
                            Joueur8.putString("ECRITURE3", ecriture3);
                        }
                        data3.putBundle("JOUEUR8",Joueur8);
                    }
                    if (idjoueur == 9){
                        Bundle Joueur9 = new Bundle();
                        Joueur9.putInt("MEME",randmeme);
                        EditText editText1 = (EditText) findViewById(R.id.ecriture1);
                        String ecriture1 = editText1.getText().toString();
                        Joueur9.putString("ECRITURE1", ecriture1);
                        if (randmeme==1 || randmeme==3 || randmeme==5 || randmeme==7 || randmeme==11 || randmeme==13 || randmeme==14 || randmeme==22 || randmeme==24 || randmeme==25){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            Joueur9.putString("ECRITURE2", ecriture2);
                        }
                        if (randmeme==4 || randmeme==6 || randmeme==8 || randmeme==9 || randmeme==10 || randmeme==12 || randmeme==15 || randmeme==26){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            EditText editText3 = (EditText) findViewById(R.id.ecriture3);
                            String ecriture3 = editText3.getText().toString();
                            Joueur9.putString("ECRITURE2", ecriture2);
                            Joueur9.putString("ECRITURE3", ecriture3);
                        }
                        data3.putBundle("JOUEUR9",Joueur9);
                    }
                    if (idjoueur == 10){
                        Bundle Joueur10 = new Bundle();
                        Joueur10.putInt("MEME",randmeme);
                        EditText editText1 = (EditText) findViewById(R.id.ecriture1);
                        String ecriture1 = editText1.getText().toString();
                        Joueur10.putString("ECRITURE1", ecriture1);
                        if (randmeme==1 || randmeme==3 || randmeme==5 || randmeme==7 || randmeme==11 || randmeme==13 || randmeme==14 || randmeme==22 || randmeme==24 || randmeme==25){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            Joueur10.putString("ECRITURE2", ecriture2);
                        }
                        if (randmeme==4 || randmeme==6 || randmeme==8 || randmeme==9 || randmeme==10 || randmeme==12 || randmeme==15 || randmeme==26){
                            EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                            String ecriture2 = editText2.getText().toString();
                            EditText editText3 = (EditText) findViewById(R.id.ecriture3);
                            String ecriture3 = editText3.getText().toString();
                            Joueur10.putString("ECRITURE2", ecriture2);
                            Joueur10.putString("ECRITURE3", ecriture3);
                        }
                        data3.putBundle("JOUEUR10",Joueur10);
                    }
                    data3.putInt("IDJOUEUR",idjoueur);
                    intent.putExtras(data3);
                    startActivity(intent);
                }
            }
        }.start();
    }

    public void updateTimer(){
        int minute = (int) timeLeftInMilliseconds / 60000;
        int seconde = (int) timeLeftInMilliseconds % 60000 / 1000;
        ProgressBar progressBar = (ProgressBar)findViewById(R.id.progress_bar);

        String timeleftText;


        timeleftText = "" + minute;
        timeleftText += ":";
        if (seconde < 10) timeleftText += "0";
        timeleftText += seconde;

        time.setText(timeleftText);
        progress = progress - 1;
        progressBar.setProgress(progress); // Default 0.
        if (timeLeftInMilliseconds<=10000) mp.start();
    }

    public int hazard(){
        Random rand = new Random();
        int hazardnumber = rand.nextInt(30) + 1;
        return (hazardnumber);
    }

    public String ecriture1() {
        EditText editText1 = (EditText) findViewById(R.id.ecriture1);
        String ecriture1 = editText1.getText().toString();
        return (ecriture1);
    }
    public String ecriture2() {
        EditText editText2 = (EditText) findViewById(R.id.ecriture2);
        String ecriture2 = editText2.getText().toString();
        return (ecriture2);
    }

    @Override
    public void onBackPressed() {

        return;
    }
}