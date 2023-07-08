package com.harshad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.harshad.dto.BookingDetailDao;
import com.harshad.model.Booking;
import com.harshad.model.Car;
import com.harshad.repository.BookingRepository;
import com.harshad.repository.CarRepository;

import java.util.Optional;

@Controller
@SessionAttributes({"username","id"})
public class BookingController {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private CarRepository carRepository;

    @GetMapping("book-car")
    public String bookCar(@RequestParam int carId, @RequestParam String username, ModelMap modelMap) {
        Car car = carRepository.findById(carId).orElse(null);
        if (car != null) {
            car.setAvailableForBooking(false);
            carRepository.save(car);

            Booking newBooking = new Booking();
            newBooking.setCarId(carId);
            newBooking.setDriverId(car.getDriverId());
            newBooking.setStatus("booked");
            newBooking.setUsername(username);
            bookingRepository.save(newBooking);

            String cancelCarUrl = "localhost:8080/cancel-car?bookingId=" + newBooking.getId();
            BookingDetailDao bookingDetailDao = new BookingDetailDao(newBooking, cancelCarUrl);
            modelMap.addAttribute("booking", newBooking);
            return "bookcomplit";
        } else {
            return "error-page"; // Handle car not found
        }
    }

    @RequestMapping("cancel-car")
    public String cancelCar(@RequestParam int bookingId, ModelMap modelMap) {
        Optional<Booking> bookingOptional = bookingRepository.findById(bookingId);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String loggedInUsername = authentication.getName();

        if (bookingOptional.isPresent()) {
            Booking booking = bookingOptional.get();

            if (booking.getUsername().equals(loggedInUsername)) {
                Car car = carRepository.findById(booking.getCarId()).orElse(null);
                if (car != null) {
                    car.setAvailableForBooking(true);
                    carRepository.save(car);
                }

                bookingRepository.deleteById(bookingId);
                return "cancel-confirmation";
            }
        }

        return "error-page"; // Handle booking not found or user mismatch
    }

    @GetMapping("/bookingview")
	public String adminHome() {
		return "bookcomplit";

	}
}
