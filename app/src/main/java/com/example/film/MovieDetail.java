package com.example.film;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MovieDetail extends AppCompatActivity {

    ImageView image;
    TextView tvJudul;
    TextView tvGenre;
    TextView tvDesc;
    Button editButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_movie_detail);
        image = findViewById(R.id.image);
        tvJudul = findViewById(R.id.tvJudul);
        tvGenre = findViewById(R.id.tvGenre);
        tvDesc = findViewById(R.id.tvDesc);
        editButton = findViewById(R.id.editButton);
        Glide.with(getBaseContext()).load(intent.getStringExtra("imageUrl")).into(image);
        tvJudul.setText(intent.getStringExtra("title"));
        tvGenre.setText("Genre: "+intent.getStringExtra("genre"));
        tvDesc.setText(intent.getStringExtra("description"));
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), MovieDesc.class);
                i.putExtra("title", tvJudul.getText().toString());
                i.putExtra("description", tvDesc.getText().toString());
                startActivity(i);
            }
        });
    }
}