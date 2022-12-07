package com.example.film;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class MovieDesc extends AppCompatActivity {

    TextView tvDesc;
    EditText etDesc;
    Button saveButton;
    String title;
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String desc = intent.getStringExtra("description");
        title = intent.getStringExtra("title");
        setContentView(R.layout.activity_movie_desc);
        tvDesc = findViewById(R.id.tvDesc);
        etDesc = findViewById(R.id.etDesc);
        saveButton = findViewById(R.id.saveButton);
        etDesc.setText(desc);
        db = FirebaseFirestore.getInstance();
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.collection("film").whereEqualTo("title", title).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        List<DocumentSnapshot> documentSnapshots = task.getResult().getDocuments();
                        db.collection("film").document(documentSnapshots.get(0).getId()).update("description", etDesc.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Toast.makeText(getBaseContext(), "Edit Success", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(getBaseContext(), MainActivity.class);
                                startActivity(i);
                            }
                        });
                    }
                });
            }
        });
    }
}