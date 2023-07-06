package com.example.androidtest2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Delhi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delhi);
        Button delhi=findViewById(R.id.kasbutton);
        delhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Delhi.this, FinalBook.class);
                intent.putExtra("Price", "2999");
                intent.putExtra("Place","Delhi Odyssey");// Replace "Page1" with the unique value for each page
                startActivity(intent);
            }
        });

    }
}