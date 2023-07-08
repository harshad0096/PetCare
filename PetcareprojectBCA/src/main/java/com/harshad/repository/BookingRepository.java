package com.harshad.repository;import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

import com.harshad.model.Booking;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

@Transactional
public interface BookingRepository extends JpaRepository<Booking,Integer> {
    List<com.harshad.model.Booking> findByUsername(String username);
    void deleteByUsername(String username);
}
