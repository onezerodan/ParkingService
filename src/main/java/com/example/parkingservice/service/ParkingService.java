package com.example.parkingservice.service;

import com.example.parkingservice.model.Car;
import java.util.List;

public interface ParkingService {
    Car createCar(Car car);
    Car getCarById(Long id);
    List<Car> getAllCars();
    Car updateCar(Long id, Car car);
    void deleteCar(Long id);
    void deleteAll();
}
