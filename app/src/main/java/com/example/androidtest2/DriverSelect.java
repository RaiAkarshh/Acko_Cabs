package com.example.androidtest2;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DriverSelect extends AppCompatActivity {
    private TextView nameTextView;
    private TextView placeTextView;
    private TextView priceTextView;
    private TextView passengersTextView;
    private TextView dateTextView;
    private TextView idTextView;
    String selectedValue;
    String id;
    DatabaseReference driver;
    FirebaseDatabase firebaseDatabase;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_select);
        nameTextView = findViewById(R.id.nameTextView1);
        placeTextView = findViewById(R.id.placeTextView1);
        priceTextView = findViewById(R.id.priceTextView1);
        passengersTextView = findViewById(R.id.passengersTextView1);
        dateTextView = findViewById(R.id.dateTextView1);
        idTextView=findViewById(R.id.idtextview1);
        Spinner driverSpinner = findViewById(R.id.driverSpinner);
        Button confirm=findViewById(R.id.updateButton);

// Define the driver names array
        String[] driverNames = {"Ravi", "Asif", "Leon", "Rithesh", "Kumar"};

// Create an ArrayAdapter using the driver names array and default layout
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, driverNames);

// Set the layout for the dropdown items
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

// Set the adapter to the spinner
        driverSpinner.setAdapter(adapter);


        // Retrieve the Booking object from the Intent extras
        Booking booking = (Booking) getIntent().getSerializableExtra("details");

        id=String.valueOf(booking.getId());
        nameTextView.setText("Name:"+booking.getName());
        placeTextView.setText("Place:"+booking.getPlace());
        priceTextView.setText("Price:"+String.valueOf(booking.getPrice()));
        passengersTextView.setText("Passengers:"+String.valueOf(booking.getPassengers()));
        dateTextView.setText("Date:"+booking.getDate());
        idTextView.setText("Booking ID:"+booking.getId());
        driverSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                 selectedValue = parent.getItemAtPosition(position).toString();
                // Do something with the selected value
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Handle the case where no item is selected
            }
        });
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DriverSelect.this,AdminFinal.class);
                startActivity(intent);
                insertdriverdata();
            }
        });


    }
    private void insertdriverdata(){
         DriverData driverData=new DriverData(id,selectedValue);
        firebaseDatabase=FirebaseDatabase.getInstance();
        driver=firebaseDatabase.getReference("Driver");
        driver.child(id).setValue(driverData);

    }
}
