package com.example.myueeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class UpdateProduct extends AppCompatActivity {

    Button mupdate , mcancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_product);

        mupdate        = findViewById(R.id.fvghy6);
        mcancel      = findViewById(R.id.qwedsa3);


        mupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(),ManageProducts.class);
                startActivity(i);

                Toast.makeText(UpdateProduct.this, "Product updated successfully", Toast.LENGTH_LONG).show();

            }
        });

        mcancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(),AdminHome.class);
                startActivity(i);
            }
        });
    }
}



