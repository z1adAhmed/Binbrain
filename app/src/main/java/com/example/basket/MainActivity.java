package com.example.basket;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends Activity {
    Handler splash = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        splash.postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent splash_screen = new Intent(com.example.basket.MainActivity.this, Login.class);
                startActivity(splash_screen);
                finish();
            }
        },2000);

    }

}
