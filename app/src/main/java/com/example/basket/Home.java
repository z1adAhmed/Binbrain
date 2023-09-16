package com.example.basket;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {
    private ImageButton redeem;
    private ImageButton sponsors;
    private ImageButton profile;
    private  ImageButton location;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        redeem = (ImageButton) findViewById(R.id.buttonn4);
        sponsors = (ImageButton) findViewById(R.id.buttonn2);
        profile = (ImageButton) findViewById(R.id.buttonn1);
        location = (ImageButton) findViewById(R.id.buttonn3);
        redeem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {redeem();}
        });
        sponsors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {sponsors();}
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {profile();}
        });
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {location();}
        });
    }
    public  void redeem(){
        Intent intent = new Intent(this, redeem.class);
        startActivity(intent);
    }
    public  void sponsors(){
        Intent intent = new Intent(this, sponsors2.class);
        startActivity(intent);
    }
    public  void profile(){
        Intent intent = new Intent(this, profile.class);
        startActivity(intent);
    }
    public  void location(){
        Intent intent = new Intent(this, location.class);
        startActivity(intent);
    }
}