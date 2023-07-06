package com.example.androidtest2;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button signUpButton;

    private DatabaseReference usersRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        signUpButton = findViewById(R.id.loginButton);

        usersRef = FirebaseDatabase.getInstance().getReference("users");

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(SignUpActivity.this, "Please enter both username and password", Toast.LENGTH_SHORT).show();
                } else {
                    saveUserToDatabase(username, password);
                    Intent intent=new Intent(SignUpActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        });

    }

    private void saveUserToDatabase(String username, String password) {
        String userId = usersRef.push().getKey();
        User user = new User(username, password);
        usersRef.child(userId).setValue(user);
        Toast.makeText(SignUpActivity.this, "User registered successfully", Toast.LENGTH_SHORT).show();
    }
}
