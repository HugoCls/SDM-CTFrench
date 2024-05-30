package com.example.ctfrench;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BinaryFlag extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        Intent launchIntent = getIntent();
        String Extra = launchIntent.getStringExtra("flag");
        WebView myWebView = findViewById(R.id.Webview);
        myWebView.setWebViewClient(new WebViewClient()); // Ensures links open in the WebView
        myWebView.loadUrl("http://79.137.38.217:5002/flag?param="+Extra);
        http://79.137.38.217:5002/flag?param=you_deserve_it

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button Back = findViewById(R.id.Back);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(BinaryFlag.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }


}
