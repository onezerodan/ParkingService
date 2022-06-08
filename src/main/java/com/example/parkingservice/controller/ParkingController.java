package com.example.parkingservice.controller;

import com.example.parkingservice.model.Car;
import com.example.parkingservice.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ParkingController {

    @Autowired
    ParkingService parkingService;

    @RequestMapping(value = "/cars", method = RequestMethod.POST)
    public Car createCar(@RequestBody Car car) {
        return parkingService.createCar(car);
    }

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public List<Car> getAllCars() {
        return parkingService.getAllCars();
    }

    @RequestMapping(value = "/cars/{carId}", method = RequestMethod.GET)
    public Car getCar(@PathVariable(value = "carId") Long id) {
        return parkingService.getCarById(id);
    }

    @RequestMapping(value = "/cars/{carId}", method = RequestMethod.PUT)
    public Car editCar(@PathVariable(value = "carId") Long id, @RequestBody Car editCar) {
        return parkingService.updateCar(id, editCar);
    }

    @RequestMapping(value = "/cars/{carId}", method = RequestMethod.DELETE)
    public void deleteCar(@PathVariable(value = "carId") Long id) {
        parkingService.deleteCar(id);
    }

    @RequestMapping(value = "/cars", method = RequestMethod.DELETE)
    public void deleteAllCars() {
        parkingService.deleteAll();
    }

}
