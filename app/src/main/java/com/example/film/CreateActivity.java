package com.example.film;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.film.models.Film;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class CreateActivity extends AppCompatActivity {
    public static final int PICKFILE_RESULT_CODE = 1;
    EditText title, genre, rating, desc;
    Button uploadImageButton, createButton;
    FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();
    StorageReference storageReference = firebaseStorage.getReference().child("images");
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private Uri fileUri;
    private String filePath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        title = findViewById(R.id.etJudul);
        uploadImageButton = findViewById(R.id.uploadButton);
        createButton= findViewById(R.id.createButton);
        genre = findViewById(R.id.etGenre);
        rating = findViewById(R.id.etRate);
        desc = findViewById(R.id.etDesc);
        uploadImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent choosedFile = new Intent(Intent.ACTION_GET_CONTENT);
                choosedFile.setType("image/*");
                startActivityForResult(Intent.createChooser(choosedFile, "image"), PICKFILE_RESULT_CODE);
            }
        });
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                storageReference = storageReference.child(fileUri.getLastPathSegment());
                storageReference.putFile(fileUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                Toast.makeText(getBaseContext(), "Success upload image", Toast.LENGTH_SHORT).show();
                                Film film = new Film(title.getText().toString(), desc.getText().toString(),uri.toString(), rating.getText().toString());
                                db.collection("film").add(film).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                    @Override
                                    public void onSuccess(DocumentReference documentReference) {
                                        Toast.makeText(getBaseContext(), "Create Success", Toast.LENGTH_SHORT).show();
                                        db.collection("genre").document(genre.getText().toString()).update("films", FieldValue.arrayUnion(film.getTitle())).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                Toast.makeText(getBaseContext(), "Success add to Genre's", Toast.LENGTH_SHORT).show();
                                            }
                                        }).addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Toast.makeText(getBaseContext(), "Failed add to Genre's", Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(getBaseContext(), "Create Failed", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getBaseContext(), "Upload Image Failed", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            fileUri = data.getData();
            uploadImageButton.setText(fileUri.getPath());
        }
    }
}