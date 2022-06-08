package com.example.parkingservice.service;


import com.example.parkingservice.model.BookingInfo;
import com.example.parkingservice.model.Car;
import com.example.parkingservice.model.ParkingSpot;
import com.example.parkingservice.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ParkingServiceImpl implements ParkingService{

    @Autowired
    ParkingRepository parkingRepository;

    @Override
    public Car createCar(Car car) {
        ParkingSpot parkingSpot = car.getParkingSpot();
        BookingInfo bookingInfo = car.getBookingInfo();
        parkingSpot.setCar(car);
        bookingInfo.setCar(car);
        return parkingRepository.save(car);
    }

    @Override
    public Car getCarById(Long id) {
        return parkingRepository.findCarById(id);
    }

    @Override
    public List<Car> getAllCars() {
        return (List<Car>) parkingRepository.findAll();
    }

    @Override
    public Car updateCar(Long id, Car car) {

        Car editCar = parkingRepository.findCarById(id);

        ParkingSpot parkingSpot = editCar.getParkingSpot();
        BookingInfo bookingInfo = editCar.getBookingInfo();
        parkingSpot.setCar(editCar);
        bookingInfo.setCar(editCar);

        editCar.setCarPlate(car.getCarPlate());
        editCar.setParkingSpot(car.getParkingSpot());
        editCar.setBookingInfo(car.getBookingInfo());

        return parkingRepository.save(editCar);
    }

    @Override
    public void deleteCar(Long id) {
        parkingRepository.deleteAllById(id);
    }

    @Override
    public void deleteAll() {parkingRepository.deleteAll();}

}
