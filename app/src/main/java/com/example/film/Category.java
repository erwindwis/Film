package com.example.film;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.ConsoleMessage;
import android.widget.TextView;

import java.io.Console;

public class Category extends AppCompatActivity {
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        String genre = intent.getStringExtra("genre");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        title = findViewById(R.id.tvCategory);
        title.setText(genre);
    }
}