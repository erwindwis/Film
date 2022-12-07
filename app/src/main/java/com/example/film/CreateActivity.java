package com.example.film;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CreateActivity extends AppCompatActivity {

    TextView tvCreate;
    EditText etJudul, etGenre, etRate, etDesc;
    Button uploadButton, createButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        tvCreate = findViewById(R.id.tvCreate);
        etJudul = findViewById(R.id.etJudul);
        etGenre = findViewById(R.id.etGenre);
        etRate = findViewById(R.id.etRate);
        etDesc = findViewById(R.id.etDesc);
        uploadButton = findViewById(R.id.uploadButton);
        createButton = findViewById(R.id.createButton);
    }
}