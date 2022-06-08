package com.example.parkingservice;

import com.example.parkingservice.model.BookingInfo;
import com.example.parkingservice.model.Car;
import com.example.parkingservice.model.ParkingSpot;
import com.example.parkingservice.repository.ParkingRepository;
import com.example.parkingservice.service.ParkingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ParkingServiceApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    ParkingService parkingService;

    @Autowired
    ParkingRepository parkingRepository;

    @Test
    void autowiredComponentsAreNotNull() {
        assert (parkingService != null);
        assert (parkingRepository != null);
    }

    @Test
    void saveDataAndGetBack() {
        Car car = new Car();
        BookingInfo bookingInfo = new BookingInfo("13:00", "1000");
        ParkingSpot parkingSpot = new ParkingSpot("66");

        car.setCarPlate("O111OO");
        car.setBookingInfo(bookingInfo);
        car.setParkingSpot(parkingSpot);

        bookingInfo.setCar(car);
        parkingSpot.setCar(car);

        parkingService.createCar(car);

        assert (parkingService.getCarById(1L) != null);

    }


}
