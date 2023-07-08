package com.harshad.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harshad.model.Address;
import com.harshad.model.User;
import com.harshad.repository.AddressRepository;
import com.harshad.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    public User getUserById(int id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElse(null);
    }
    
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
    
   
    
}
