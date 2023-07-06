package com.example.androidtest2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class FinalPage extends AppCompatActivity {
    private static final long DELAY_MS = 5000; // 5 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_page);

        // Create a Handler to delay the redirection
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Intent to navigate to the next page (Page B)
                Intent intent = new Intent(FinalPage.this, Intro.class);
                startActivity(intent);
                finish(); // Optional: Close the current page if needed
            }
        }, DELAY_MS);
    }
}
