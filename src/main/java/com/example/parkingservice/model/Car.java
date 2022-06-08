package com.example.parkingservice.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity()
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    private String carPlate;

    @OneToOne( fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private ParkingSpot parkingSpot;

    @OneToOne( fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private BookingInfo bookingInfo;


    //ID getter is necessary for getting id after saving in response body
    public Long getId() {
        return id;
    }

    public String getCarPlate() {
        return carPlate;
    }

    public void setCarPlate(String carPlate) {
        this.carPlate = carPlate;
    }

    public BookingInfo getBookingInfo() {
        return bookingInfo;
    }

    public void setBookingInfo(BookingInfo bookingInfo) {
        this.bookingInfo = bookingInfo;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public Car(String carPlate, ParkingSpot parkingSpot, BookingInfo bookingInfo) {
        this.carPlate = carPlate;
        this.parkingSpot = parkingSpot;
        this.bookingInfo = bookingInfo;
    }

    public Car() {}
}
