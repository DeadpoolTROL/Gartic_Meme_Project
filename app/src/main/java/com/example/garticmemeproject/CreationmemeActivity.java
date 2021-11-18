package com.example.garticmemeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

    private Bundle data3;
    private int idprofil;
    private String theme;
    public int randmeme = hazard();
    private int progressTime = 0;
    private TextView time;
    private ImageView imageView;
    private CountDownTimer countDownTimer;
    private long timeLeftInMilliseconds = 5000000; //1 min 40      100000
    public static final String EXTRA_MESSAGE3 = "";
    public static final String EXTRA_MEME = "";
    private int progress = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_creationmeme+randmeme);

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
        int idprofil = data3.getInt("NBJOUEUR");
        String imgPP = "profil" + idprofil;
        int id2 = getResources().getIdentifier(imgPP, "drawable", getPackageName());
        imgProfil.setImageResource(id2);

//---------------------------------------Bouton---------------------------------------------------------------------------

        Button bouton;
        bouton = (Button) findViewById(R.id.buttoncreation);
        bouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        CreationmemeActivity.this,
                        VoteActivity.class
                );
                data3.putInt("MEME",randmeme);
                intent.putExtras(data3);
                if (countDownTimer != null){
                    countDownTimer.cancel();
                }

                EditText editText1 = (EditText) findViewById(R.id.ecriture1);
                String ecriture1 = editText1.getText().toString();
                data3.putString("ECRITURE1", ecriture1);
                if (randmeme==1 || randmeme==3 || randmeme==5){
                    EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                    String ecriture2 = editText2.getText().toString();
                    data3.putString("ECRITURE2", ecriture2);
                }
                if (randmeme==4 || randmeme==6){
                    EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                    String ecriture2 = editText2.getText().toString();
                    EditText editText3 = (EditText) findViewById(R.id.ecriture3);
                    String ecriture3 = editText3.getText().toString();
                    data3.putString("ECRITURE2", ecriture2);
                    data3.putString("ECRITURE3", ecriture3);
                }
                intent.putExtras(data3);
                startActivity(intent);
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
                Intent intent = new Intent(
                        CreationmemeActivity.this,
                        VoteActivity.class
                );
                EditText editText1 = (EditText) findViewById(R.id.ecriture1);
                String ecriture1 = editText1.getText().toString();
                data3.putString("ECRITURE1", ecriture1);
                if (randmeme==1 || randmeme==3 || randmeme==5){
                    EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                    String ecriture2 = editText2.getText().toString();
                    data3.putString("ECRITURE2", ecriture2);
                }
                if (randmeme==4 || randmeme==6){
                    EditText editText2 = (EditText) findViewById(R.id.ecriture2);
                    String ecriture2 = editText2.getText().toString();
                    EditText editText3 = (EditText) findViewById(R.id.ecriture3);
                    String ecriture3 = editText3.getText().toString();
                    data3.putString("ECRITURE2", ecriture2);
                    data3.putString("ECRITURE3", ecriture3);
                }
                data3.putInt("MEME",randmeme);
                intent.putExtras(data3);
                startActivity(intent);
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

    }

    public int hazard(){
        Random rand = new Random();
        int hazardnumber = rand.nextInt(6) + 1;
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
}