package com.uee.admin_app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;
import java.util.ArrayList;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {
    Context context;
    ArrayList<ArticleHelperClass> list;
    FirebaseDatabase database = FirebaseDatabase.getInstance("https://uee-project-1c21d-default-rtdb.asia-southeast1.firebasedatabase.app/");
    DatabaseReference myRef = database.getReference("Articles");

    public ArticleAdapter(Context context, ArrayList<ArticleHelperClass> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ArticleAdapter.ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent , int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.article_card, parent, false);
        return new ArticleAdapter.ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder , @SuppressLint("RecyclerView") int position) {
        ArticleHelperClass helperClass = list.get(position);
        holder.title.setText ( helperClass.getTitle () );
        holder.author.setText ( helperClass.getAuthor () );

        holder.updateBtn.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle ();

                bundle.putString ( "Title", helperClass.getTitle () );
                bundle.putString ( "Desc", helperClass.getDescription () );
                bundle.putString ( "Author", helperClass.getAuthor () );

                Intent intent = new Intent ( context, UpdateArticleActivity.class );
                intent.putExtras( bundle );
                context.startActivity ( intent );
            }
        } );

        holder.deleteBtn.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                myRef.child(helperClass.getTitle()).removeValue().addOnSuccessListener(suc->
                {
                    Toast.makeText(context, "Record is removed", Toast.LENGTH_SHORT).show();
                    notifyItemRemoved(position);
                    list.remove(helperClass);
                    Intent intent = new Intent (context, AllArticlesActivity.class);
                    context.startActivity(intent);
                    ((Activity)context).finish();
                }).addOnFailureListener(er->
                {
                    Toast.makeText(context, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
                });
            }
        } );

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ArticleViewHolder extends  RecyclerView.ViewHolder {
        TextView title, author;
        AppCompatButton updateBtn, deleteBtn;

        public ArticleViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById ( R.id.article_card_title );
            author = itemView.findViewById ( R.id.article_card_author );
            updateBtn = itemView.findViewById ( R.id.article_card_updateBtn );
            deleteBtn = itemView.findViewById ( R.id.article_card_deleteBtn );
        }
    }
}
