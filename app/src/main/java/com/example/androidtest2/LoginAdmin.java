package com.example.androidtest2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginAdmin extends AppCompatActivity {
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);

        // Initialize the views
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);

        // Set a click listener for the login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (username.equals("admin") && password.equals("password")) {
                    // Successful login
                    Toast.makeText(LoginAdmin.this, "Login successful", Toast.LENGTH_SHORT).show();
                    // Proceed to the next activity
                    Intent intent = new Intent(LoginAdmin.this, AdminActivity.class);
                    startActivity(intent);
                    finish(); // Optional: close the login activity
                } else {
                    // Invalid credentials
                    Toast.makeText(LoginAdmin.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
