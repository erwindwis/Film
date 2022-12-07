package com.example.film;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.film.models.Film;

import java.util.List;


public class FilmAdapter extends RecyclerView.Adapter<FilmViewHolder>{
    Context context;
    List<Film> films;
    private SelectListener selectListener;
    public FilmAdapter(Context context, List<Film> films, SelectListener selectListener) {
        this.context = context;
        this.films = films;
        this.selectListener = selectListener;
    }

    @NonNull
    @Override
    public FilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FilmViewHolder(LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FilmViewHolder holder, int position) {
        Glide.with(context).load(films.get(position).getImageUrl()).into(holder.image);
        holder.rating.setText(films.get(position).getRating()+"/5");
        holder.title.setText(films.get(position).getTitle());
        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectListener.onItemClicked(films.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return films.size();
    }
}
