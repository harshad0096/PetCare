package com.harshad.repository;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harshad.model.CarRequest;

@Transactional
public interface CarRequestRepository extends JpaRepository<CarRequest,Integer> {
}
