package com.example.androidtest2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DestinationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination);
        Button mumbai, delhi, kashmir, hydbad, chennai;
        mumbai = findViewById(R.id.mumbaibtn);
        delhi = findViewById(R.id.delhibtn);
        kashmir = findViewById(R.id.kashmirbtn);
        hydbad = findViewById(R.id.hydbtn);
        chennai = findViewById(R.id.chennaibtn);
        Button logout=findViewById(R.id.logoutbtn);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DestinationActivity.this,MainActivity.class);
                startActivity(intent);

            }
        });

        mumbai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DestinationActivity.this, Mumbai.class);
                startActivity(intent);
            }
        });
        delhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(DestinationActivity.this, Delhi.class);
                startActivity(intent1);
            }
        });
        kashmir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(DestinationActivity.this, Kashmir.class);
                startActivity(intent2);
            }
        });
        hydbad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3=new Intent(DestinationActivity.this,Hyderabad.class);
                startActivity(intent3);
            }
        });
        chennai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4=new Intent(DestinationActivity.this,Chennai.class);
                startActivity(intent4 );
            }
        });

    }
}