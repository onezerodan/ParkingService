package com.example.parkingservice.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "booking_info")
public class BookingInfo {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String bookingTime;

    @NotNull
    private String bookingPrice;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "car_id")
    private Car car;


    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getBookingPrice() {
        return bookingPrice;
    }

    public void setBookingPrice(String bookingPrice) {
        this.bookingPrice = bookingPrice;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public BookingInfo(String bookingTime, String bookingPrice) {
        this.bookingTime = bookingTime;
        this.bookingPrice = bookingPrice;
    }

    public BookingInfo() {}
}
