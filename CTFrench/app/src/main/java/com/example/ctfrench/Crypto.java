package com.example.ctfrench;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
public class Crypto extends AppCompatActivity {

    public static String md5(final String s) {
        final String MD5 = "MD5";
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest
                    .getInstance(MD5);
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuilder hexString = new StringBuilder();
            for (byte aMessageDigest : messageDigest) {
                String h = Integer.toHexString(0xFF & aMessageDigest);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    private Button showTextButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_crypto);

        Button submitButton = (Button) findViewById(R.id.button);
        EditText passwordinput = (EditText)findViewById(R.id.editTextText);
        TextView flagOutput = (TextView)findViewById(R.id.editTextText2);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userinput = passwordinput.getText().toString();
                String Md5_hash = md5(userinput);

                /*if (passwordinput.getText().toString().decrypt("b74dec4f39d35b6a2e6c48e637c8aedb")){
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Noice :) CTFrench{");
                    stringBuilder.append(flagOutput.getText().toString());
                    stringBuilder.append("_is_good!}");
                    flagOutput.setText(stringBuilder.toString());

                }*/
                if (Md5_hash.equals("69801a4ccce0e5179a027cce35f58ab2")) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Noice :) CTFrench{");
                    stringBuilder.append(userinput);
                    stringBuilder.append("_is_good!}");
                    flagOutput.setText(stringBuilder.toString());
                } else {
                    flagOutput.setText("Wrong password");
                }
            }
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    /*public static String decrypt (byte[] cipherText, SecretKey key, byte[] IV) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            SecretKeySpec keySpec = new SecretKeySpec(key.getEncoded(), "AES");
            IvParameterSpec ivSpec = new IvParameterSpec(IV);
            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
            byte[] decryptedText = cipher.doFinal(cipherText);
            return new String(decryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }*/
}