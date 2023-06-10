package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class SplashScreen extends AppCompatActivity {

    TextView  textView;
    LottieAnimationView  lottie;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        textView  =findViewById(R.id.newstext);
        lottie = findViewById(R.id.sslottie);

       /// textView.animate().translationY(-1400).setDuration(2700).setStartDelay(0);
        lottie.animate().setDuration(4000).setStartDelay(4000);

         handler =  new Handler();
         handler.postDelayed(new Runnable() {
             @Override
             public void run() {
                 Intent intent=new Intent(SplashScreen
                         .this,MainActivity.class);
                 startActivity(intent);
                 finish();
             }
         },5000);

    }
}