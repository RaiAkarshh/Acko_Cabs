package com.example.androidtest2;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AboutUs extends AppCompatActivity {
    private static final String PHONE_NUMBER = "+917079778024";
    private static final String EMAIL_ADDRESS = "ackocabs@gmail.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        Button phoneButton = findViewById(R.id.phonebtn);
        Button emailButton = findViewById(R.id.mailbtn);

        phoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to the phone app and dial the specified number
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + PHONE_NUMBER));
                startActivity(intent);
            }
        });

        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to the email app with the specified email address
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:" + EMAIL_ADDRESS));
                startActivity(intent);
            }
        });
    }
}
