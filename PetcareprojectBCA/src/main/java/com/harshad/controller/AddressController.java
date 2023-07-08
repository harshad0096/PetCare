package com.harshad.controller;



import com.harshad.model.Address;
import com.harshad.model.User;
import com.harshad.repository.AddressRepository;
import com.harshad.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import javax.persistence.Id;

@RestController

public class AddressController {

    private final AddressRepository addressRepository;
    private final UserRepository userRepository;

    @Autowired
    public AddressController(AddressRepository addressRepository, UserRepository userRepository) {
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("/address")
    public Address saveAddress(@PathVariable int userId, @RequestBody Address address) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + userId));

       
        return addressRepository.save(address);
    }

    @GetMapping("/{userId}")
    public Optional<Address> getAddressesByUserId(@PathVariable int userId) {
        return addressRepository.findById(userId);
    }
}
