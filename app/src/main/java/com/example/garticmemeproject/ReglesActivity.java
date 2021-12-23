package com.example.garticmemeproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ReglesActivity extends AppCompatActivity {

    ImageView Layout;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_regles);

        Layout = findViewById(R.id.touchregle);
        Layout.setOnTouchListener((view, motionEvent) -> {
            Intent intent = new Intent(
                    ReglesActivity.this,
                    ParametreActivity.class
            );
            startActivity(intent);
            return false;
        });
    }
    
}