package com.harshad.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harshad.model.AnimalCategory;

public interface AnimalCategoryRepository extends JpaRepository<AnimalCategory, Integer>{
    
}
