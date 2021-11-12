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
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_vote);

        data4 = getIntent().getExtras();

        String theme = getIntent().getStringExtra("THEME");
        TextView textView = findViewById(R.id.themevote);
        textView.setText("Thème : " + theme);
        value=(TextView)findViewById(R.id.voteresult);

//______________________________Image MEME__________________________________________________________________

        int randmeme = getIntent().getIntExtra("MEME",1);
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
                intent.putExtras(data4);
                startActivity(intent);
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
}