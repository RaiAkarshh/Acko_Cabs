package com.example.androidtest2;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminActivity extends AppCompatActivity {
    private ListView bookingsListView;
    private BookingAdapter bookingAdapter;
    private DatabaseReference bookingsRef;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        bookingsListView = findViewById(R.id.bookingsListView);
        List<Booking> bookingsList = new ArrayList<>();
        bookingAdapter = new BookingAdapter(this, bookingsList);
        bookingsListView.setAdapter(bookingAdapter);
        bookingsListView.setDivider(getResources().getDrawable(R.drawable.divider));
        bookingsListView.setDividerHeight(4); // Adjust the height as needed

        // Initialize Firebase Realtime Database reference
        bookingsRef = FirebaseDatabase.getInstance().getReference().child("Booking");

        // Retrieve booking data from Firebase
        bookingsRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String previousChildName) {
                Booking booking = dataSnapshot.getValue(Booking.class);
                bookingAdapter.add(booking);
                bookingAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String previousChildName) {
                // Handle changes to existing bookings if necessary
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                // Handle removed bookings if necessary
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String previousChildName) {
                // Handle moved bookings if necessary
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle database errors
                Toast.makeText(AdminActivity.this, "Database error: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        bookingsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Booking selectedBooking = bookingAdapter.getItem(position);
                Booking selectedChildNode = (Booking) parent.getItemAtPosition(position);

                // Extract the booking ID from the selected Booking object
                String selectedChildNodeKey = selectedChildNode.getName();
                DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
                Map<String, Object> map = new HashMap<>();
                map.put("bookconf", 1);
                rootRef.child("Booking").child(selectedChildNodeKey).updateChildren(map);
                // Navigate to the desired page, passing the selected booking data
                Intent intent = new Intent(AdminActivity.this, DriverSelect.class);
                intent.putExtra("details",selectedBooking);
                startActivity(intent);
            }
        });

    }
}
