package com.example.androidtest2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;

import java.util.Random;

public class FinalBook extends AppCompatActivity {
    DatabaseReference booking;
    int amount;
    int initialAmount;
    int textViewValue;
    int initialPassengerValue;
    int selectedValue;
    String final1,number;
    EditText name;
    String bookingid;
    Button copy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_book);
        TextView placeTextView=findViewById(R.id.redirectedTextView4);
        TextView textViewAmount = findViewById(R.id.amount);
        name=findViewById(R.id.name);
        TextView redirectedTextView = findViewById(R.id.redirectedTextView);
        String redirectSource = getIntent().getStringExtra("Price");
        redirectedTextView.setText("" + redirectSource);
        String redirectPlace=getIntent().getStringExtra("Place");
        placeTextView.setText(""+redirectPlace);
        Spinner spinnerPassengers = findViewById(R.id.spinnerPassengers);
        TextView bookid=findViewById(R.id.idfinalbook);
        bookingid=generateBookingID();
        bookid.setText(""+bookingid);
        copy=findViewById(R.id.copybutton);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.passenger_values,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPassengers.setAdapter(adapter);
         initialPassengerValue = Integer.parseInt(spinnerPassengers.getSelectedItem().toString());
         textViewValue = Integer.parseInt(redirectedTextView.getText().toString());
        initialAmount = initialPassengerValue * textViewValue;
        textViewAmount.setText("" + initialAmount);

        spinnerPassengers.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                 selectedValue = Integer.parseInt(adapterView.getSelectedItem().toString());
                 amount = selectedValue * textViewValue;
                textViewAmount.setText("" + amount);
                 final1=String.valueOf(amount);
                 number=String.valueOf(selectedValue);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // Handle case when nothing is selected (if needed)
            }
        });

        Button move=findViewById(R.id.selectdate);
        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FinalBook.this, SelectDate.class);
                intent.putExtra("Place",redirectPlace);
                intent.putExtra("Price",final1);
                intent.putExtra("Passengers",number);
                String nameval=name.getText().toString();
                intent.putExtra("Name",nameval);
                intent.putExtra("ID",bookingid);
                startActivity(intent);

            }
        });
        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = bookid.getText().toString();
                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("TextView", text);
                clipboardManager.setPrimaryClip(clipData);
                Toast.makeText(getApplicationContext(), "Text copied to clipboard", Toast.LENGTH_SHORT).show();
            }
        });


    }
    public String generateBookingID() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder bookingID = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(characters.length());
            bookingID.append(characters.charAt(index));
        }

        return bookingID.toString();
    }


}