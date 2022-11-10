package com.example.myueeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class NewArticle extends AppCompatActivity {

    Button radd , rcancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_article);


        radd        = findViewById(R.id.Addsa);
        rcancel      = findViewById(R.id.Cncelsa);


        radd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(),AdminHome.class);
                startActivity(i);

                Toast.makeText(NewArticle.this, "Article updated successfully", Toast.LENGTH_LONG).show();

            }
        });

        rcancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(),AdminHome.class);
                startActivity(i);
            }
        });
    }
}



