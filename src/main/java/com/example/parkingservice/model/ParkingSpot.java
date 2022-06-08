package com.example.parkingservice.model;

import com.sun.istack.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "parking_spots")
public class ParkingSpot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    private String spotNumber;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Car car;


    public void setCar(Car car) {
        this.car = car;
    }

    public String getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(String spotNumber) {
        this.spotNumber = spotNumber;
    }

    public ParkingSpot(String spotNumber) {
        this.spotNumber = spotNumber;
    }

    public ParkingSpot() {}
}
