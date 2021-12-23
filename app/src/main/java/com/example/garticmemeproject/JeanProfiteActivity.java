package com.example.garticmemeproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class JeanProfiteActivity extends AppCompatActivity {

    private Bundle data7;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_jean_profite);

        data7 = getIntent().getExtras();

        ImageView layout = findViewById(R.id.logo1);
        layout.setOnTouchListener((view, motionEvent) -> {
            Intent intent = new Intent(
                    JeanProfiteActivity.this,
                    EasterEggActivity.class
            );
            intent.putExtras(data7);
            startActivity(intent);
            return false;
        });
    }
}