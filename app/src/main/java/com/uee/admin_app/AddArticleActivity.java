package com.uee.admin_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class AddArticleActivity extends AppCompatActivity {

    EditText title, desc, author;
    AppCompatButton addBtn, cancelBtn;
    ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_add_article );

        title = findViewById ( R.id.article_title );
        desc = findViewById ( R.id.article_desc );
        author = findViewById ( R.id.article_creator );
        addBtn = findViewById ( R.id.add_btn_add_article );
        cancelBtn = findViewById ( R.id.cancel_btn_add_article );
        backBtn = findViewById ( R.id.back_btn_add_article );

        addBtn.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                if (!validateTitle () | !validateDesc () | !validateAuthor ()){
                    return;
                } else {
                    String titleStr = title.getText ().toString ();
                    String descStr = desc.getText ().toString ();
                    String authorStr = author.getText ().toString ();

                    ArticleHelperClass helperClass = new ArticleHelperClass ( titleStr, descStr, authorStr );

                    DatabaseReference reference = FirebaseDatabase.getInstance ( "https://uee-project-1c21d-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference ( "Articles" ).child ( titleStr );

                    reference.setValue ( helperClass ).addOnSuccessListener ( suc -> {
                        Toast.makeText(getApplicationContext(), "Added Successfully", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(intent);
                        finish();
                    }).addOnFailureListener ( err -> {
                        Toast.makeText(getApplicationContext(), "" + err.getMessage(), Toast.LENGTH_SHORT).show();
                    });

                }

            }
        } );

        cancelBtn.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        } );

        backBtn.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        } );
    }

    private Boolean validateTitle () {
        String nameStr = Objects.requireNonNull( title.getText() ).toString();

        if (nameStr.isEmpty ()) {
            title.setError ( "Fields cannot be empty" );
            return false;
        } else {
            title.setError ( null );
            return true;
        }
    }

    private Boolean validateDesc () {
        String nameStr = Objects.requireNonNull( desc.getText() ).toString();

        if (nameStr.isEmpty ()) {
            desc.setError ( "Fields cannot be empty" );
            return false;
        } else {
            desc.setError ( null );
            return true;
        }
    }

    private Boolean validateAuthor () {
        String nameStr = Objects.requireNonNull( author.getText() ).toString();

        if (nameStr.isEmpty ()) {
            author.setError ( "Fields cannot be empty" );
            return false;
        } else {
            author.setError ( null );
            return true;
        }
    }
}