package com.example.myueeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminHome extends AppCompatActivity {

     Button add, update, delete , article ,sales;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        add     =  findViewById(R.id.ADDproducts);
        update  = findViewById(R.id.UpdaTeProd);
        delete  = findViewById(R.id.DelTePro);
        article = findViewById(R.id.AddArTiCles);
        sales   = findViewById(R.id.BTNreport);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(),AddSolar.class);
                startActivity(i);

            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(),ManageProducts.class);
                startActivity(i);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(),ManageProducts.class);
                startActivity(i);

            }
        });

        article.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(),NewArticle.class);
                startActivity(i);

            }
        });


        sales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(),salesReport.class);
                startActivity(i);

            }
        });
    }
}


