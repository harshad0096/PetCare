package com.harshad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harshad.model.Disease;

public interface DiseaseRepository extends JpaRepository<Disease,Long>{
    List<Disease> findAllByCategory_Id(int id);
}
