package com.example.androidtest2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class SelectDate extends AppCompatActivity {
    CalendarView calendarView;
    Button nextPageButton;
    TextView myDate;
    DatabaseReference booking;
    FirebaseDatabase firebaseDatabase;
    String date1;
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_date);
        String place =getIntent().getStringExtra("Place");
        String price=getIntent().getStringExtra("Price");
        String passengers=getIntent().getStringExtra("Passengers");
        calendarView=(CalendarView) findViewById(R.id.calendarView);
        nextPageButton=findViewById(R.id.finalbutton);
        myDate=(TextView) findViewById(R.id.DateView);
        Calendar calendar = Calendar.getInstance();
        long todayInMillis = calendar.getTimeInMillis();

// Set the minimum date to today
        calendarView.setMinDate(todayInMillis);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                date= i2 +"/" + (i1+1) + "/" + i;
                myDate.setText(date);
                date1=date.toString();
            }
        });

        nextPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SelectDate.this,FinalPage.class);
                startActivity(intent);
                insertbookingdata();
            }
        });

        // Assuming you have a CalendarView with the id "calendarView" and a Button to navigate to the next page with the id "nextButton"


// Set an OnClickListener
    }   
    private void insertbookingdata(){
        String place =getIntent().getStringExtra("Place");
        String price=getIntent().getStringExtra("Price");
        String passengers=getIntent().getStringExtra("Passengers");
        String name=getIntent().getStringExtra("Name");
        String date1=date.toString();
        String bookid=getIntent().getStringExtra("ID");
        Long bookconf= Long.valueOf(0);
        Bookingdata newbooking=new Bookingdata(name,price,place,passengers,date1,bookid,bookconf);
        firebaseDatabase=FirebaseDatabase.getInstance();
        booking=firebaseDatabase.getReference("Booking");
        booking.child(name).setValue(newbooking);
    }

}