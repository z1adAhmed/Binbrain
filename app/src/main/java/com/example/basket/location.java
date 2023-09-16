package com.example.basket;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class location extends AppCompatActivity {

    ImageButton button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        button=(ImageButton) findViewById(R.id.imageButton2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url= "https://goo.gl/maps/S1fNYBYb7ffSD2ov9";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            }
        });
        button=(ImageButton) findViewById(R.id.imageButton3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url= "https://goo.gl/maps/6MNJ2Jfot6NaPRXu8";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            }
        });
        button=(ImageButton) findViewById(R.id.imageButton4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url= "https://goo.gl/maps/bhMZFeQJ6RQfH9K98";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            }
   });
}

}