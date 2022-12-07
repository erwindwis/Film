package com.example.film;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class FilmViewHolder extends RecyclerView.ViewHolder{
    ImageView image;
    TextView title, rating;
    CardView cv;
    public FilmViewHolder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.image);
        title = itemView.findViewById(R.id.tvJudul);
        rating = itemView.findViewById(R.id.tvRate);
        cv = itemView.findViewById(R.id.container);
    }
}
