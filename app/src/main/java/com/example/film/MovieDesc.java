package com.example.film;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MovieDesc extends AppCompatActivity {

    TextView tvDesc;
    EditText etDesc;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_desc);

        tvDesc = findViewById(R.id.tvDesc);
        etDesc = findViewById(R.id.etDesc);
        saveButton = findViewById(R.id.saveButton);
    }
}