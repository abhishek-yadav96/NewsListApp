package com.example.newslistapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.ColorSpace;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainactivityAdapter extends RecyclerView.Adapter<MainactivityAdapter.ViewHolder> {
    Context context;
    ModelResponse modelResponse;
    int likes_c=0;
    public MainactivityAdapter(Context context, ModelResponse modelResponse){
        this.context=context;
        this.modelResponse=modelResponse;
    }
    @NonNull
    @Override
    public MainactivityAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
return  new ViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainactivityAdapter.ViewHolder holder, int position) {

//        holder.txtowner.setText(modelResponse.get(position).getArticles().get(position).getSource().getName());
        holder.txtowner.setText(modelResponse.getArticles().get(position).getAuthor());
        //holder.txtowner.setText(modelResponse.get(position).getArticles().get(position).getSource().getName());
        holder.txttitile.setText(modelResponse.getArticles().get(position).getTitle());
        Picasso.get().load(modelResponse.getArticles().get(position).getUrlToImage()).into(holder.img);

        holder.likes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(likes_c==0){
                    holder.likes.setBackgroundResource(R.color.black);
                    likes_c=1;
                }
                else {
                    holder.likes.setBackgroundResource(R.color.teal_200);
                    likes_c=0;
                }


            }
        });



       holder.linearLayout.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
              Intent intent=new Intent(context,ActivityDetails.class);
              intent.putExtra("details",modelResponse.getArticles().get(position).getContent());
              intent.putExtra("desc",modelResponse.getArticles().get(position).getDescription());
              intent.putExtra("pic",modelResponse.getArticles().get(position).getUrlToImage());
              intent.putExtra("aut",modelResponse.getArticles().get(position).getAuthor());
              intent.putExtra("date",modelResponse.getArticles().get(position).getPublishedAt());
              intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|   Intent.FLAG_ACTIVITY_NEW_TASK);
              context.startActivity(intent);
           }
       });


    }

    @Override
    public int getItemCount() {
        return modelResponse.getArticles().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

TextView txttitile,txtowner,txname;
LinearLayout linearLayout;
ImageView img,likes;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txttitile=itemView.findViewById(R.id.title);
            txtowner=itemView.findViewById(R.id.author);
//            txname=itemView.findViewById(R.id.name);
            img=itemView.findViewById(R.id.image);
            linearLayout=itemView.findViewById(R.id.linear);
            likes=itemView.findViewById(R.id.likes);
        }
    }
}
