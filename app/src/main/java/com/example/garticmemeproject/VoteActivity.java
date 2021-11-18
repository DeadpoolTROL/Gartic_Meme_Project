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

        data4 = getIntent().getExtras();
        int randmeme = getIntent().getIntExtra("MEME",1);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_vote+randmeme);

        String theme = getIntent().getStringExtra("THEME");
        TextView textView = findViewById(R.id.themevote);
        textView.setText("Thème : " + theme);
        value=(TextView)findViewById(R.id.voteresult);

//______________________________Image MEME__________________________________________________________________

        //int randmeme = getIntent().getIntExtra("MEME",1);
        //ImageView imgMeme = (ImageView) findViewById(R.id.Meme);
        //String imgMM = "meme" + randmeme;
        //int id2 = getResources().getIdentifier(imgMM, "drawable", getPackageName());
        //imgMeme.setImageResource(id2);

        String ecriture1 = data4.getString("ECRITURE1");
        TextView textView1 = findViewById(R.id.ecriture1);
        textView1.setText(ecriture1);
        if (randmeme==1 || randmeme==3 || randmeme==5){
            String ecriture2 = data4.getString("ECRITURE2");
            TextView textView2 = findViewById(R.id.ecriture2);
            textView2.setText(ecriture2);
        }
        if (randmeme==4 || randmeme==6){
            String ecriture2 = data4.getString("ECRITURE2");
            TextView textView2 = findViewById(R.id.ecriture2);
            textView2.setText(ecriture2);
            String ecriture3 = data4.getString("ECRITURE3");
            TextView textView3 = findViewById(R.id.ecriture3);
            textView3.setText(ecriture3);
        }

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