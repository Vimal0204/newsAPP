package com.example.newsnaut;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter1 extends RecyclerView.Adapter<Adapter1.ViewHolder> {
    Context context;
    ArrayList<ModelClass1> modelClassArrayList1;

    public Adapter1(Context context, ArrayList<ModelClass1> modelClassArrayList1) {
        this.context = context;
        this.modelClassArrayList1 = modelClassArrayList1;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.layout_item1,null,false);
       return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.cardView1.setOnClickListener(view -> {
            Intent intent=new Intent(context,webView1.class);
                intent.putExtra("url",modelClassArrayList1.get(position).getUrl());
                context.startActivity(intent);
        });

        holder.mtime1.setText("Published At :- "+modelClassArrayList1.get(position).getPublishedAt());
        holder.mauthor1.setText(modelClassArrayList1.get(position).getAuthor());
        holder.mheading1.setText(modelClassArrayList1.get(position).getTitle());
        holder.mcontent1.setText(modelClassArrayList1.get(position).getDescription());
        Glide.with(context).load(modelClassArrayList1.get(position).getUrlToImage()).into(holder.imageView1);



    }

    @Override
    public int getItemCount() {
       return modelClassArrayList1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mheading1,mcontent1,mauthor1,mtime1;
        CardView cardView1;
        ImageView imageView1;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mheading1=itemView.findViewById(R.id.mainheading1);
            mcontent1=itemView.findViewById(R.id.content1);
            mauthor1=itemView.findViewById(R.id.author1);
            mtime1=itemView.findViewById(R.id.time1);
            imageView1=itemView.findViewById(R.id.imageview1);
            cardView1=itemView.findViewById(R.id.cardview1);
        }
    }
}
