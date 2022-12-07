package com.example.film;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    FloatingActionButton addButton;
    TextView petualangan, keluarga, misteri, fantasi, romantis, animasi, aksi, horor, drama, komedi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addButton = findViewById(R.id.addButton);
        petualangan = findViewById(R.id.petualangan);
        petualangan.setOnClickListener(this::onClick);
        keluarga = findViewById(R.id.keluarga);
        keluarga.setOnClickListener(this::onClick);
        misteri = findViewById(R.id.misteri);
        misteri.setOnClickListener(this::onClick);
        fantasi = findViewById(R.id.fantasi);
        fantasi.setOnClickListener(this::onClick);
        romantis = findViewById(R.id.romantis);
        romantis.setOnClickListener(this::onClick);
        animasi = findViewById(R.id.animasi);
        animasi.setOnClickListener(this::onClick);
        aksi = findViewById(R.id.aksi);
        aksi.setOnClickListener(this::onClick);
        horor = findViewById(R.id.horor);
        horor.setOnClickListener(this::onClick);
        drama = findViewById(R.id.drama);
        drama.setOnClickListener(this::onClick);
        komedi = findViewById(R.id.komedi);
        komedi.setOnClickListener(this::onClick);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, CreateActivity.class);
                startActivity(i);
            }
        });

    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(getBaseContext(), Category.class);
        i.putExtra("genre", v.getResources().getResourceEntryName(v.getId()));
        startActivity(i);
    }
}