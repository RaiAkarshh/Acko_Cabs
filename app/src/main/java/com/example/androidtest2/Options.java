package com.example.androidtest2;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Options extends AppCompatActivity {
    private RadioGroup radioGroup;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        radioGroup = findViewById(R.id.radio_group);
        nextButton = findViewById(R.id.submit);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();

                if (selectedId != -1) {
                    RadioButton selectedRadioButton = findViewById(selectedId);
                    String selectedOption = selectedRadioButton.getText().toString();
                    // Perform any necessary operations with the selected option

                    // Start the next activity (destination page)
                    startActivity(new Intent(Options.this, DestinationActivity.class));
                } else {
                    // No radio button is selected, show an error or prompt the user to select an option
                    Toast.makeText(Options.this, "Please select an option", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
