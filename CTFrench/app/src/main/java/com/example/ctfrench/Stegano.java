package com.example.ctfrench;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Stegano extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_stegano);

        Button submitButton = (Button) findViewById(R.id.button);
        TextView commentaries = (TextView) findViewById(R.id.textView);
        ImageView plats = (ImageView) findViewById(R.id.imageView2);
        ImageView frog = (ImageView) findViewById(R.id.imageView);

        TextView text = (TextView) findViewById(R.id.textView3);
        TextView text2 = (TextView) findViewById(R.id.textView4);

        frog.setVisibility(View.INVISIBLE);
        text.setVisibility(View.INVISIBLE);
        text2.setVisibility(View.INVISIBLE);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<String> commentaries_list = Arrays.asList("oh oui very good ca", "miam miam", "oh ça it's delicious", "roooohlalala ca c'est bon");
                Random index_phrase = new Random();
                int index_random_phrase = index_phrase.nextInt(4);
                commentaries.setText(commentaries_list.get(index_random_phrase).toString());

                Random index_image = new Random();
                int index_image_int = index_image.nextInt(12);
                plats.setImageResource(FileList.imageResources.get(index_image_int));

                if (index_image_int == 1){
                    frog.setVisibility(View.VISIBLE);
                    text.setVisibility(View.VISIBLE);
                    text2.setVisibility(View.VISIBLE);
                } else {
                    frog.setVisibility(View.INVISIBLE);
                    text.setVisibility(View.INVISIBLE);
                    text2.setVisibility(View.INVISIBLE);

                }



            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button Back = findViewById(R.id.Back);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Stegano.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }



}