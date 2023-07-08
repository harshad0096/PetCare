package com.harshad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harshad.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

    List<Category>findByNameIn(List<String>categoryNames);
}
