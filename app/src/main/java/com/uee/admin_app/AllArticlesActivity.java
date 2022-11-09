package com.uee.admin_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AllArticlesActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    ArticleAdapter articleAdapter;
    ArrayList<ArticleHelperClass> list;

    public AllArticlesActivity() {}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_all_articles );

        recyclerView = findViewById ( R.id.article_recyclerView );
        databaseReference = FirebaseDatabase.getInstance ( "https://uee-project-1c21d-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference ( "Articles" );
        recyclerView.setHasFixedSize (true);
        recyclerView.setLayoutManager ( new LinearLayoutManager ( AllArticlesActivity.this ) );

        list = new ArrayList<> ();
        articleAdapter = new ArticleAdapter ( AllArticlesActivity.this, list );
        recyclerView.setAdapter ( articleAdapter );

        databaseReference.addValueEventListener ( new ValueEventListener ( ) {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren ()) {
                    ArticleHelperClass helperClass = dataSnapshot.getValue ( ArticleHelperClass.class );
                    list.add(helperClass);
                }
                articleAdapter.notifyDataSetChanged ();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        } );
    }
}