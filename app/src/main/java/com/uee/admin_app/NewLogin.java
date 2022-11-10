package com.example.myueeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NewLogin extends AppCompatActivity {

    Button loginadmin , google ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_login);

        loginadmin    = findViewById(R.id.DLEt2);
        google      = findViewById(R.id.GOOGLEbtn);


        loginadmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(),AdminHome.class);
                startActivity(i);

            }
        });

        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(),AdminHome.class);
                startActivity(i);
            }
        });
    }
}



