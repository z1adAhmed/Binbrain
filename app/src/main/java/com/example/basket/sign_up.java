package com.example.basket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class sign_up extends AppCompatActivity {

    EditText username, fullname, email, password;
    Button signup;
    DbHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        fullname = (EditText) findViewById(R.id.fullname);
        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        signup = (Button) findViewById(R.id.sign_up);
        DB = new DbHelper(this);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String full = fullname.getText().toString();
                String em = email.getText().toString();
                if (user.equals("") || pass.equals("") || full.equals("") || em.equals("")) {
                     Toast.makeText(sign_up.this, "Please fill all the information to Sign Up!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean checkuser = DB.checkusername(user);
                    if (checkuser == false) {
                        Boolean insert = DB.insertData(user, full, pass, em);
                        if(insert == true) {
                            Toast.makeText(sign_up.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                           Intent  intent = new Intent(getApplicationContext(), Home.class);
                            startActivity(intent);
                        }
                        else
                            Toast.makeText(sign_up.this, "Registered Failed", Toast.LENGTH_SHORT).show();
                    }
                    else
                        Toast.makeText(sign_up.this, "UserID is already taken", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
    }