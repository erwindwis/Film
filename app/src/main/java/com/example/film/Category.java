package com.example.film;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.ConsoleMessage;
import android.widget.TextView;
import android.widget.Toast;

import com.example.film.models.Categories;
import com.example.film.models.Film;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.common.reflect.TypeToken;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.gson.Gson;

import java.io.Console;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Category extends AppCompatActivity implements SelectListener{
    TextView title;
    Categories categories;
    FirebaseFirestore db;
    FilmAdapter adapter;
    List<Film> films;
    String genre;
    List<String> titles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        genre = intent.getStringExtra("genre");
        super.onCreate(savedInstanceState);
        titles = new ArrayList<String>();
        setContentView(R.layout.activity_category);
        title = findViewById(R.id.tvCategory);
        title.setText(genre);
        RecyclerView recyclerView = findViewById(R.id.recyclerFilms);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        films = new ArrayList<Film>();
        adapter = new FilmAdapter(this,films, this);
        recyclerView.setAdapter(adapter);
        db = FirebaseFirestore.getInstance();
       db.collection("genre").document(genre).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
           @Override
           public void onComplete(@NonNull Task<DocumentSnapshot> task) {
               DocumentSnapshot documentSnapshot = task.getResult();
               if(documentSnapshot.exists()){
                   Categories categories = task.getResult().toObject(Categories.class);
                   for (String film : categories.getFilms()) {
                       titles.add(film);
                   }
                   if(!titles.isEmpty()){
                       db.collection("film").whereIn("title",titles ).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                           @Override
                           public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                               if(!queryDocumentSnapshots.isEmpty()){
                                   List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                                   List<Film>temp = new ArrayList<>();
                                   for (DocumentSnapshot documentSnapshot : list) {
                                       Film data = documentSnapshot.toObject(Film.class);
                                       Log.d("alvin", data.getTitle());
                                       films.add(data);
                                   }
                                   Log.d("alvin", films.size()+" ukurannya film");
                                   adapter.notifyDataSetChanged();
                               }

                           }
                       });
                   }
               }
           }
       });

    }

    @Override
    public void onItemClicked(Film film) {
        Intent i = new Intent(getBaseContext(), MovieDetail.class);
        i.putExtra("title", film.getTitle());
        i.putExtra("description", film.getDescription());
        i.putExtra("rating", film.getRating());
        i.putExtra("imageUrl", film.getImageUrl());
        i.putExtra("genre", genre);
        startActivity(i);
    }
}