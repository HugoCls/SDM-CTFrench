package com.example.ctfrench;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Crypto1 = findViewById(R.id.Crypto1);
        Button Crypto2 = findViewById(R.id.Crypto2);
        Button Stegano = findViewById(R.id.Stegano);
        Button Osint = findViewById(R.id.Osint);
        Crypto1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Crypto.class);
                startActivity(intent);

            }
        });

        Crypto2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Crypto2.class);
                startActivity(intent);

            }
        });

        Stegano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Stegano.class);
                startActivity(intent);

            }
        });

        Osint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, OSINT.class);
                startActivity(intent);

            }
        });
    }
}