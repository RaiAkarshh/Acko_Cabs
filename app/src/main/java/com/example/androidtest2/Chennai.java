package com.example.androidtest2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Chennai extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chennai);
        Button chennai=findViewById(R.id.kasbutton);
        chennai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Chennai.this, FinalBook.class);
                intent.putExtra("Price", "2750");
                intent.putExtra("Place","Chennai Melange");// Replace "Page1" with the unique value for each page
                startActivity(intent);
            }
        });
    }
}