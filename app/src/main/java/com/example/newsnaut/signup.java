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

public class signup extends AppCompatActivity {
    TextInputEditText reg_Email;
    TextInputEditText reg_Pass;
    TextView tvLoginHere;
    Button Register_btn;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        reg_Email=findViewById(R.id.reg_Email);
        reg_Pass=findViewById(R.id.reg_Pass);
        Register_btn=findViewById(R.id.Register_btn);
        tvLoginHere=findViewById(R.id.tvLoginHere);
        mAuth= FirebaseAuth.getInstance();
        Register_btn.setOnClickListener(view ->{
            createUser();
        });

        tvLoginHere.setOnClickListener(view ->{
            startActivity(new Intent(signup.this, login.class));
        });
    }
    private void createUser(){
        String email = reg_Email.getText().toString();
        String password = reg_Pass.getText().toString();

        if (TextUtils.isEmpty(email)){
            reg_Email.setError("Email cannot be empty");
            reg_Email.requestFocus();
        }else if (TextUtils.isEmpty(password)){
            reg_Pass.setError("Password cannot be empty");
            reg_Pass.requestFocus();
        }else{
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(signup.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(signup.this, login.class));
                    }else{
                        Toast.makeText(signup.this, "Registration Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

}