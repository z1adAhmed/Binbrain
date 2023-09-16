package com.example.basket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private Button sign_in;
    EditText username, password;
    Button log_in;
    DbHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        log_in = (Button) findViewById(R.id.log_in);
        sign_in = (Button) findViewById(R.id.sign_up);
        DB = new DbHelper(this);
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {sign_up();}
        });
        log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                if(user.equals("") || pass.equals(""))
                    Toast.makeText(Login.this, "Please fill all the information to Sign Up!", Toast.LENGTH_SHORT).show();
                else
                {
                    Boolean checkuser = DB.checkusernamepassword(user,pass);
                    if(checkuser == true)
                    {
                        Toast.makeText(Login.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
                        Intent  intent = new Intent(getApplicationContext(), Home.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(Login.this, "The username or password is wrong please try again", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    public  void sign_up(){
        Intent intent = new Intent(this, sign_up.class);
        startActivity(intent);
    }
}