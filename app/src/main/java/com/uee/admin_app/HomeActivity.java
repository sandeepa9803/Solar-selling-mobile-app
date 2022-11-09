package com.uee.admin_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    AppCompatButton addBtn, allArticleBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_home );

        addBtn = findViewById ( R.id.add_article_btn );
        allArticleBtn = findViewById ( R.id.all_article_btn );

        addBtn.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent ( getApplicationContext (), AddArticleActivity.class );
                startActivity ( intent );
            }
        } );

        allArticleBtn.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent ( getApplicationContext (), AllArticlesActivity.class );
                startActivity ( intent );
            }
        } );
    }
}