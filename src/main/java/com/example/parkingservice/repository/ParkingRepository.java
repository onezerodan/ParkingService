package com.example.parkingservice.repository;


import com.example.parkingservice.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepository extends CrudRepository<Car, Long> {
    Car findCarById(String id);
    Car findCarById(Long id);
    void deleteAllById(Long id);
    boolean existsById(Long id);
    void deleteAll();


}
