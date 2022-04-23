package com.example.newsnaut;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
    private TextInputEditText log_email;
    private TextInputEditText log_pass;
    private TextView tvRegisterHere;
    private Button login_btn;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        log_email=findViewById(R.id.log_email);
        log_pass = findViewById(R.id.log_pass);
        tvRegisterHere=findViewById(R.id.tvRegisterHere);
        login_btn = findViewById(R.id.login_btn);
        mAuth = FirebaseAuth.getInstance();
        login_btn.setOnClickListener(view -> {
            loginUser();
        });
        tvRegisterHere.setOnClickListener(view ->{
            startActivity(new Intent(login.this, signup.class));
        });
    }
    private void loginUser(){
        String email = log_email.getText().toString();
        String password = log_pass.getText().toString();

        if (TextUtils.isEmpty(email)){
            log_email.setError("Email cannot be empty");
            log_email.requestFocus();
        }else if (TextUtils.isEmpty(password)){
            log_pass.setError("Password cannot be empty");
            log_pass.requestFocus();
        }else{
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(login.this, "User logged in successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(login.this, MainActivity.class));
                    }else{
                        Toast.makeText(login.this, "Log in Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}