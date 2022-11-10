package com.example.myueeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ManageProducts extends AppCompatActivity {

    Button mngupdate , mngdelete  , sdupdate , sddelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_products);


        mngupdate    =  findViewById(R.id.UPD1);
        mngdelete    = findViewById(R.id.DLT1);
        sdupdate     =  findViewById(R.id.UPD2e);
        sddelete    = findViewById(R.id.DLEt2);



       mngupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(),UpdateProduct.class);
                startActivity(i);


            }
        });

        mngdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(ManageProducts.this, "Product deleted successfully", Toast.LENGTH_LONG).show();
            }
        });

        sdupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(),UpdateProduct.class);
                startActivity(i);

            }
        });

       sddelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(ManageProducts.this, "Product deleted successfully", Toast.LENGTH_LONG).show();

            }
        });
    }
}



