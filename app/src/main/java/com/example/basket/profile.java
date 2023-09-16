package com.example.basket;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class profile extends AppCompatActivity {
    Button show_profile;
    DbHelper DB;
    EditText ID;
    TextView name, Id, mail,points;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        DB = new DbHelper(this);
        show_profile = (Button) findViewById(R.id.show_profile);
        ID = (EditText) findViewById(R.id.userID);
        name = (TextView) findViewById(R.id.textView2);
        Id = (TextView) findViewById(R.id.textView4);
        mail = (TextView) findViewById(R.id.textView6);
        points = (TextView) findViewById(R.id.textView8);
        show_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user_ID = ID.getText().toString();
                if(user_ID.equals(""))
                    Toast.makeText(profile.this, "Please write your userID to show your profile", Toast.LENGTH_SHORT).show();
                else{
                        String fullname = DB.fetch_Fullname(user_ID);
                        name.setText(fullname);
                        String id = DB.fetch_useID(user_ID);
                        Id.setText(id);
                        String email = DB.fetch_Email(user_ID);
                        mail.setText(email);
                        String Points = Integer.toString(DB.fetch_points(user_ID));
                        points.setText(Points);
                }
            }


        });
    }
}