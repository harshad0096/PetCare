package com.harshad.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harshad.model.Product;
import com.harshad.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    
    
     
    User findByConfirmationToken(String confirmationToken);
    
    User findByEmail(String email);

    public User findByResetPasswordToken(String token);

    Optional<User> findUserByEmail(String email);

  User getById(String userId);

  Optional<User> findByUsername(String username);

  
}
