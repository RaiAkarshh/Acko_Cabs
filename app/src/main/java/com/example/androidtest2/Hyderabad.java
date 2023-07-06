package com.example.androidtest2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Hyderabad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hyderabad);
        Button hyderabad=findViewById(R.id.kasbutton);
        hyderabad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Hyderabad.this, FinalBook.class);
                intent.putExtra("Price", "6999");
                intent.putExtra("Place","Hyderabad Essence");// Replace "Page1" with the unique value for each page
                startActivity(intent);
            }
        });

    }
}