package com.example.basket;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class sponsors2 extends AppCompatActivity {
    ImageButton button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsors2);
        button=(ImageButton) findViewById(R.id.Ibutton5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url= "https://www.carrefouregypt.com/mafegy/en/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            }
        });
        button=(ImageButton) findViewById(R.id.ibutton6);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url= "https://grandegyptianmuseum.org/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            }
        });
        button=(ImageButton) findViewById(R.id.ibutton7);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url= "https://www.starbucks.com/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            }
        });
        button=(ImageButton) findViewById(R.id.ibutton8);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url= "https://tickets.zed-park.com/Online/Tickets";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            }
        });
        button=(ImageButton) findViewById(R.id.ibutton9);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url= "https://www.mcdonalds.eg/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            }
        });
        button=(ImageButton) findViewById(R.id.ibutton10);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url= "https://www.adidas.com.eg/en?cm_mmc=AdieSEM_Google-_-brandEN-_-AlwaysON-_-Multiple-_-dv:eCom-_-cn:brandAR-_-pc:Google&cm_mmc1=EG&cm_mmc2=PPC-Multiple-CrossCategory-Multiple-PH-EG-EMEA-eCom-Paid_Search&gclid=Cj0KCQjw6cKiBhD5ARIsAKXUdyamk6fngMBNuKpnPfH1bNk4I7zF5y3ZFUX3hdHGrsJ6CtxbsAiHoiwaAgV-EALw_wcB";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            }
        });
    }
}