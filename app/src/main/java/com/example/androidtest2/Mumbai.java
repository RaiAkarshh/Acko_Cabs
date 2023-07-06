package com.example.androidtest2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Mumbai extends AppCompatActivity {
    Button mumbai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mumbai);
        mumbai=findViewById(R.id.kasbutton);
        mumbai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mumbai.this, FinalBook.class);
                intent.putExtra("Price", "4999");
                intent.putExtra("Place","Mumbai Mystique");// Replace "Page1" with the unique value for each page
                startActivity(intent);
            }
        });

    }
}