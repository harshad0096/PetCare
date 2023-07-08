package com.harshad.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harshad.model.Driver;

public interface DriverRepository extends JpaRepository<Driver,Integer> {
}
