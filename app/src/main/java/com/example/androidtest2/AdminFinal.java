package com.example.androidtest2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class AdminFinal extends AppCompatActivity {
    private static final long DELAY_MS = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_final);
        // Create a Handler to delay the redirection
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Intent to navigate to the next page (Page B)
                Intent intent = new Intent(AdminFinal.this, AdminActivity.class);
                startActivity(intent);
                finish(); // Optional: Close the current page if needed
            }
        }, DELAY_MS);
    }
}
