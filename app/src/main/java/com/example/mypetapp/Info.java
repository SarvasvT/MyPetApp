package com.example.mypetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Info extends AppCompatActivity {

    Button infonext;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        infonext = findViewById(R.id.infonext);
        infonext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Info.this, "DONE!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Info.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}