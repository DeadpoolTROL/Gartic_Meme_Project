package com.example.garticmemeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class CreationmemeActivity extends AppCompatActivity {

    private int idprofil;
    private String theme;
    public int randmeme = Hazard();
    public Bundle data2 = new Bundle();
    private int progressTime = 0;
    private TextView time;
    private ImageView imageView;
    private CountDownTimer countDownTimer;
    private long timeLeftInMilliseconds = 100000; //1 min 40
    public static final String EXTRA_MESSAGE3 = "";
    public static final String EXTRA_MEME = "";
    private int progress = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_creationmeme);

        String theme = getIntent().getStringExtra("THEME");
        TextView textView = findViewById(R.id.themecreate);
        textView.setText("Thème : " + theme);

//______________________________Image MEME__________________________________________________________________

        ImageView imgMeme = (ImageView) findViewById(R.id.meme);
        String imgName = "meme" + randmeme;
        int id = getResources().getIdentifier(imgName, "drawable", getPackageName());
        imgMeme.setImageResource(id);

//______________________________Image Profil__________________________________________________________________

        ImageView imgProfil = (ImageView) findViewById(R.id.imagejoueurx);
        int idprofil = getIntent().getIntExtra("NBJOUEUR",0);
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
                data2.putString("THEME", theme);
                data2.putInt("NBJOUEUR", idprofil);
                data2.putInt("MEME",randmeme);
                intent.putExtras(data2);
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
                idprofil = getIntent().getIntExtra("NBJOUEUR",0);
                theme = getIntent().getStringExtra("THEME");
                data2.putString("THEME", theme);
                data2.putInt("NBJOUEUR", idprofil);
                data2.putInt("MEME",randmeme);
                intent.putExtras(data2);
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

    public int Hazard(){
        Random rand = new Random();
        int hazardnumber = rand.nextInt(6) + 1;
        return (hazardnumber);
    }
}