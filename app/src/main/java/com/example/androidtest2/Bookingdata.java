package com.example.androidtest2;

public class Bookingdata {
    String name;
    String price;
    String place;
    String passengers;
    String date;
    private Long bookconf;


    public String getId() {
        return id;
    }

    public Long getBookconf() {
        return bookconf;
    }


    String id;

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getDate() {
        return date;
    }

    public String getPlace() {
        return place;
    }

    public String getPassengers() {
        return passengers;
    }


    public Bookingdata(String name,String price, String place,String passengers,String date,String id,Long bookconf) {
        this.name=name;
        this.price = price;
        this.place = place;
        this.passengers = passengers;
        this.date=date;
        this.id=id;
        this.bookconf = bookconf;
    }
}
