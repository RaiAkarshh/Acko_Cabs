package com.example.androidtest2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Kashmir extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kashmir);
        Button kashmir=findViewById(R.id.kasbutton);
        kashmir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Kashmir.this, FinalBook.class);
                intent.putExtra("Price", "9999");
                intent.putExtra("Place","Kashmir Serenade");// Replace "Page1" with the unique value for each page
                startActivity(intent);
            }
        });

    }
}