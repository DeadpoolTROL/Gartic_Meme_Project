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

    TextView value;
    int count = 0;
    public static final String EXTRA_MESSAGE = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_vote);

        Intent intent = getIntent();
        String message = intent.getStringExtra(PlayersActivity.EXTRA_MESSAGE2);

        TextView textView = findViewById(R.id.themevote);
        textView.setText("Thème : " + message);

        value=(TextView)findViewById(R.id.voteresult);

//______________________________Image MEME__________________________________________________________________

        int randmeme = intent.getIntExtra(CreationmemeActivity.EXTRA_MEME,0);
        ImageView imgMeme = (ImageView) findViewById(R.id.Meme);
        String imgMM = "meme" + randmeme;
        int id2 = getResources().getIdentifier(imgMM, "drawable", getPackageName());
        imgMeme.setImageResource(id2);

//---------------------------------------Bouton---------------------------------------------------------------------------

        Button bouton;
        bouton = (Button) findViewById(R.id.buttonvote);
        bouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        VoteActivity.this,
                        FinActivity.class
                );
                startActivity(intent);
            }
        });
    }

    public void increment(View v){
        if (count >= 10) count = 10;
        else count++;
        value.setText("" + count);
    }

    public void decrement(View v){
        if (count <= 0) count = 0;
        else count--;
        value.setText("" + count);
    }
}