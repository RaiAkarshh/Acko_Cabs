package com.example.androidtest2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Intro extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        Button buttonBookCab = findViewById(R.id.button_book_cab);
        Button buttonAboutUs = findViewById(R.id.button_about_us);
        Button logout=findViewById(R.id.logoutbtn);
        Button checkstatus=findViewById(R.id.check);


        buttonAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(Intro.this,AboutUs.class);
                startActivity(intent1);
                // Handle About Us button click
                // Add your code here
            }
        });

        buttonBookCab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intro.this, Bookings.class);
                startActivity(intent);
            }
        });
        checkstatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intro.this,StatusActivity.class);
                startActivity(intent);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intro.this,MainActivity.class);
                startActivity(intent);

            }
        });

    }
}
