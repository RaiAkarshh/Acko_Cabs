package com.example.androidtest2;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class BookingAdapter extends ArrayAdapter<Booking> {
    private Context context;
    private List<Booking> bookings;

    public BookingAdapter(Context context, List<Booking> bookings) {
        super(context, 0, bookings);
        this.context=context;
        this.bookings = bookings;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_booking, parent, false);
        }

        // Get the Booking object at the current position
        Booking booking = getItem(position);

        // Bind the data to the TextViews with attribute labels
        TextView nameLabelTextView = convertView.findViewById(R.id.nameTextView);
        nameLabelTextView.setText("Name: " + booking.getName());
        nameLabelTextView.setTypeface(null, Typeface.BOLD);

        TextView placeTextView = convertView.findViewById(R.id.placeTextView);
        placeTextView.setText("Place: " + booking.getPlace());
        placeTextView.setTypeface(null, Typeface.BOLD);

        TextView priceTextView = convertView.findViewById(R.id.priceTextView);
        priceTextView.setText("Price: " + String.valueOf(booking.getPrice()));
        priceTextView.setTypeface(null, Typeface.BOLD);

        TextView passengersTextView = convertView.findViewById(R.id.passengersTextView);
        passengersTextView.setText("Passengers: " + String.valueOf(booking.getPassengers()));
        passengersTextView.setTypeface(null, Typeface.BOLD);

        TextView dateTextView = convertView.findViewById(R.id.dateTextView);
        dateTextView.setText("Date: " + booking.getDate());
        dateTextView.setTypeface(null, Typeface.BOLD);

        TextView idTextView = convertView.findViewById(R.id.idTextView);
        dateTextView.setText("ID: " + booking.getId());
        dateTextView.setTypeface(null, Typeface.BOLD);

        return convertView;
    }



}
