package com.harshad.service;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harshad.model.Address;
import com.harshad.model.User;
import com.harshad.repository.AddressRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService{
    @Autowired
     AddressRepository addressRepository ;
    @Autowired
     UserService userService;
    
    @Override
    public Address add(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        addressRepository.deleteById(id);
    }

    @Override
    public List<Address> getAddressByUserId(int userId) {
        Optional<User> user = Optional.ofNullable(userService.getUserById(userId));
        List<Address> addressesResponse = new ArrayList<>();
        
        if (user.isPresent()) {
          //  for (Address address : user.get().getAddress()) {
           //     addressesResponse.add(address);
            }
            return addressesResponse;
       // }
       // return null;
    }

    @Override
    public Address getById(int id) {
        Optional<Address> address = addressRepository.findById(id);
        return address.orElse(null);
    }
}