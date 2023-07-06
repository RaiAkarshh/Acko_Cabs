package com.example.androidtest2;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StatusActivity extends AppCompatActivity {

    private static final String TAG = "StatusActivity";
    int flag=0,flag1=0;
    private TextView resultTextView;
    String bookingId;
    String driverName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);


        EditText editText=findViewById(R.id.editid);
        Button button=findViewById(R.id.searchButton);
        TextView textView = findViewById(R.id.resultTextView);
        String compare="FTLtBE";// Replace R.id.textView with the actual ID of your TextView

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Booking");
        DatabaseReference driverReference = FirebaseDatabase.getInstance().getReference().child("Driver");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        StringBuilder stringBuilder = new StringBuilder();

                        String check=editText.getText().toString().trim();

                        for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                             bookingId = childSnapshot.child("id").getValue(String.class);
                            int bookconf = childSnapshot.child("bookconf").getValue(Integer.class);
                            if (check.equals(bookingId)) {
                                if (bookconf == 1) {
                                    flag=2;

                                    break;

                                } else if (bookconf == 0) {
                                    flag=1;
                                    break;

                                }
                            }
                            else{
                                flag=3;

                            }


                            stringBuilder.append("\n");
                        }
                        if(flag==1)
                        {
                            stringBuilder.append("Booking not confirmed").append("\n");


                        }
                        if(flag==2)
                        {
                            driverReference.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    StringBuilder stringBuilder = new StringBuilder();

                                    for (DataSnapshot driverSnapshot : dataSnapshot.getChildren()) {
                                         driverName = driverSnapshot.child("driver").getValue(String.class);
                                        String driverId = driverSnapshot.child("id").getValue(String.class);
                                        {
                                            if (driverId.equals(bookingId)) {


                                                flag1 = 1;
                                                break;

                                            }
                                        }
                                    }
                                    if(flag1==1)
                                    {
                                        stringBuilder.append("Booking confirmed").append("\n");
                                        stringBuilder.append("Driver assigned for your tour is: ").append(driverName).append("\n");
                                        stringBuilder.append("\n");
                                    }

                                    textView.setText(stringBuilder.toString());
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                    // Handle error
                                }
                            });



                        }

                        if(flag==3)
                        {
                            stringBuilder.append("ID doesn't exist").append("\n");

                        }

                        textView.setText(stringBuilder.toString());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }

        });

    }
}

