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
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class CreationmemeActivity extends AppCompatActivity {

    private TextView time;
    private ImageView imageView;
    private CountDownTimer countDownTimer;
    private long timeLeftInMilliseconds = 90000; //1 min 30
    public static final String EXTRA_MESSAGE3 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_creationmeme);

        Intent intent = getIntent();
        String message = intent.getStringExtra(PlayersActivity.EXTRA_MESSAGE2);

        TextView textView = findViewById(R.id.themecreate);
        textView.setText("Thème : " + message);

        ImageView imgView = (ImageView) findViewById(R.id.meme);
        Random rand = new Random();
        int rndInt = rand.nextInt(6) + 1;
        String imgName = "meme" + rndInt;
        int id = getResources().getIdentifier(imgName, "drawable", getPackageName());
        imgView.setImageResource(id);

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
                intent.putExtra(EXTRA_MESSAGE3, message);
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
                        FinActivity.class
                );
                startActivity(intent);
            }
        }.start();
    }

    public void updateTimer(){
        int minute = (int) timeLeftInMilliseconds / 60000;
        int seconde = (int) timeLeftInMilliseconds % 60000 / 1000;

        String timeleftText;

        timeleftText = "" + minute;
        timeleftText += ":";
        if (seconde < 10) timeleftText += "0";
        timeleftText += seconde;

        time.setText(timeleftText);
    }

}