package com.uee.admin_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class UpdateArticleActivity extends AppCompatActivity {

    EditText title, desc, author;
    AppCompatButton updateBtn;

    DatabaseReference reference = FirebaseDatabase.getInstance ("https://uee-project-1c21d-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference ("Articles");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_update_article );

        ArticleHelperClass articleData = (ArticleHelperClass) getIntent ().getCharSequenceExtra ( "Data" );

        title = findViewById ( R.id.update_article_title );
        desc = findViewById ( R.id.update_article_desc );
        author = findViewById ( R.id.update_article_author );
        updateBtn = findViewById ( R.id.update_article_update_btn );

        Bundle bundle = getIntent ().getExtras ();

        //setting article data to edit texts to update
        title.setText ( bundle.getString ( "Title" ) );
        desc.setText ( bundle.getString ( "Desc" ) );
        author.setText ( bundle.getString ( "Author" ) );

        updateBtn.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                HashMap<String, Object> hashMap = new HashMap<> ();
                hashMap.put ( "title", title.getText ().toString () );
                hashMap.put ( "description", desc.getText ().toString () );
                hashMap.put ( "author", author.getText ().toString () );

                reference.child ( bundle.getString ( "Title" ) ).updateChildren( hashMap ).addOnSuccessListener( suc -> {
                    Toast.makeText(getApplicationContext(), "Record is updated", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), AllArticlesActivity.class);
                    startActivity(intent);
                    finish();
                }).addOnFailureListener(er ->
                {
                    Toast.makeText(getApplicationContext(), "" + er.getMessage(), Toast.LENGTH_SHORT).show();
                });
            }
        } );
    }
}