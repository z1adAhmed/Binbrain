package com.example.basket;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class redeem extends AppCompatActivity {
    Button redeem;
    EditText code, id;
    DbHelper DB;
    codes db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redeem);
        redeem = (Button) findViewById(R.id.redeem1);
        code = (EditText) findViewById(R.id.code);
        id = (EditText) findViewById(R.id.userID);
        DB = new DbHelper(this);
        db = new codes(this);
        redeem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user_ID = id.getText().toString();
                String code_filled =  code.getText().toString();
                if(code_filled.equals("")  || user_ID.equals(""))
                    Toast.makeText(redeem.this, "Please fill the code and userID section to redeem your points!", Toast.LENGTH_SHORT).show();
                else
                {
                    Boolean checkcode = db.checkcode(code_filled);
                    if(checkcode == false) {
                        DB.redeem_points(user_ID);
                        db.insertData(code_filled);
                        Toast.makeText(redeem.this, "Points added successfully", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(redeem.this, "Code already used!", Toast.LENGTH_SHORT).show();
                    }

                }


            }
        });
    }
}