package com.example.androidtest2;

import java.io.Serializable;

public class Booking implements Serializable {
    private String name;
    private String place;
    private String price;
    private String passengers;
    private String date;
    private String id;
    public Booking() {
        // Default constructor required for Firebase
    }

    public Booking(String name, String place, String price, String passengers, String date,String id) {
        this.name = name;
        this.place = place;
        this.price = price;
        this.passengers = passengers;
        this.date = date;
        this.id=id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPlace() {
        return place;
    }

    public String getPrice() {
        return price;
    }

    public String getPassengers() {
        return passengers;
    }

    public String getDate() {
        return date;
    }
}
