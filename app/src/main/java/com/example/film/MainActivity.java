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

public class MainActivity extends AppCompatActivity {
    FloatingActionButton addButton;
    TextView petualangan, keluarga, misteri, fantasi, romantis, animasi, aksi, horor, drama, komedi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<TextView> wrapperButton = new ArrayList<>();
        setContentView(R.layout.activity_main);
        addButton = findViewById(R.id.addButton);
        petualangan = findViewById(R.id.petualangan);
        wrapperButton.add(petualangan);
        keluarga = findViewById(R.id.keluarga);
        wrapperButton.add(keluarga);
        misteri = findViewById(R.id.misteri);
        wrapperButton.add(misteri);
        fantasi = findViewById(R.id.fantasi);
        wrapperButton.add(fantasi);
        romantis = findViewById(R.id.romantis);
        wrapperButton.add(romantis);
        animasi = findViewById(R.id.animasi);
        wrapperButton.add(animasi);
        aksi = findViewById(R.id.aksi);
        wrapperButton.add(aksi);
        horor = findViewById(R.id.horor);
        wrapperButton.add(horor);
        drama = findViewById(R.id.drama);
        wrapperButton.add(drama);
        komedi = findViewById(R.id.komedi);
        wrapperButton.add(komedi);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, CreateActivity.class);
            }
        });

    }
}