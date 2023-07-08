package com.harshad.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harshad.model.Car;

import java.util.List;

import javax.transaction.Transactional;

@Transactional
public interface CarRepository extends JpaRepository<Car,Integer> {
    //List<Car> findBySeatingCapacityAndavailableForBooking(int seatingCapacity,boolean availableForBooking);
    List<Car> findBySeatingCapacityAndAvailableForBookingTrue(int seatingCapacity);

    List<Car> findByIdIn(List<Integer> carIds);
}
