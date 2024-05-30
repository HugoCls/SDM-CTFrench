package com.example.ctfrench;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Binary extends AppCompatActivity {

    private String comparative_flag = "";
    private String input_request = "";
    private Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_binary);

        Button execute = (Button) findViewById(R.id.button);

        EditText request = (EditText) findViewById(R.id.editTextText);

        TextView affichage = (TextView) findViewById(R.id.outputtext);

        TextView content = findViewById(R.id.textView3);



        TextView warning = findViewById(R.id.justaletter);

        Button reset_flag = findViewById(R.id.reset_flag);

        Button validation = findViewById(R.id.validation);

        TextView flag_show = findViewById(R.id.flag);

        warning.setVisibility(View.INVISIBLE);



        Button Back = findViewById(R.id.Back);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Binary.this, MainActivity.class);
                startActivity(intent);

            }
        });

        execute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Effectuez votre action ici lorsque le bouton est cliqué
                String memory_request = request.getText().toString();
                String output_request = Requestfile.request_treatment(memory_request);
                Log.d("LogLevel: info", "onClick: output_request"+output_request);
                input_request+= memory_request;

                if (output_request.equals("warning")){

                    warning.setVisibility(View.VISIBLE);

                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            warning.setVisibility(View.GONE);
                        }
                    }, 1000);

                }else {

                    comparative_flag += output_request;
                    Log.d("LogLevel: info", "onClick: output_request"+comparative_flag);
                }

                affichage.setText(comparative_flag);

            }
        });

        reset_flag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comparative_flag = "";
                affichage.setText(comparative_flag);
            }

        });

        validation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (comparative_flag.equals("you_deserve_it")) {
                    Intent intent = new Intent(Binary.this, BinaryFlag.class);
                    intent.putExtra("flag", comparative_flag);
                    startActivity(intent);
                }
            }

        });


    }
}