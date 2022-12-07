package com.example.film;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton addButton;
    TextView petualangan, keluarga, misteri, fantasi, romantis, animasi, aksi, horor, drama, komedi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addButton = findViewById(R.id.addButton);
        petualangan = findViewById(R.id.petualangan);
        keluarga = findViewById(R.id.keluarga);
        misteri = findViewById(R.id.misteri);
        fantasi = findViewById(R.id.fantasi);
        romantis = findViewById(R.id.romantis);
        animasi = findViewById(R.id.animasi);
        aksi = findViewById(R.id.aksi);
        horor = findViewById(R.id.horor);
        drama = findViewById(R.id.drama);
        komedi = findViewById(R.id.komedi);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
    }
}