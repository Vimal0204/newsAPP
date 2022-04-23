package com.example.newsnaut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class NEWS extends AppCompatActivity {
    private Button newsbtn,hinbtn,intbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        newsbtn=findViewById(R.id.newsbtn);
        hinbtn=findViewById(R.id.hinbtn);
        intbtn=findViewById(R.id.intbtn);
        newsbtn.setOnClickListener(view -> {
            startActivity(new Intent(NEWS.this,mainnews.class));
        });
//        intbtn.setOnClickListener(view -> {
//            startActivity(new Intent(NEWS.this,intermainnews.class));
//        });
//        newsbtn.setOnClickListener(view -> {
//            startActivity(new Intent(NEWS.this,mainnews.class));
//        });
    }
}