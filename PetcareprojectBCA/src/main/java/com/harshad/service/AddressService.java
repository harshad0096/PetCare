package com.harshad.service;

import java.util.List;

import com.harshad.model.Address;

public interface AddressService {
    Address add(Address address);
    List<Address> getAll();
    void deleteById(int id);
    List<Address> getAddressByUserId(int userId);
    Address getById(int id);
}
