package com.example.garticmemeproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            Intent intent=new Intent(SplashScreenActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        },2000);
    }
}