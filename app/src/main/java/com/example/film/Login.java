package com.example.film;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText email;
    EditText password;
    Button loginButton;
    boolean passwordVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);

        password.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                final int Right=2;
                if(motionEvent.getAction() == MotionEvent.ACTION_UP){
                    if(motionEvent.getRawX() >= password.getRight()-password.getCompoundDrawables()[Right].getBounds().width()){
                        int selection = password.getSelectionEnd();
                        if(passwordVisible){
                            //set drawable image here
                            password.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_baseline_lock_24, 0, R.drawable.ic_baseline_visibility_off_24, 0);
                            //for hide password
                            password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible = false;
                        } else{
                            //set drawable image here
                            password.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_baseline_lock_24, 0, R.drawable.ic_baseline_visibility_24, 0);
                            //for show password
                            password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible = true;
                        }
                        password.setSelection(selection);
                    }
                }
                return false;
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if success
                Toast.makeText(Login.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                //else
                Toast.makeText(Login.this, "Login Failed!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}