package com.example.film;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MovieDetail extends AppCompatActivity {

    ImageView image;
    TextView tvJudul;
    TextView tvGenre;
    TextView tvDesc;
    Button editButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        image = findViewById(R.id.image);
        tvJudul = findViewById(R.id.tvJudul);
        tvGenre = findViewById(R.id.tvGenre);
        tvDesc = findViewById(R.id.tvDesc);
        editButton = findViewById(R.id.editButton);
    }
}