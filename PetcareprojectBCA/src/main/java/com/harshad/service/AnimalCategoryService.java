package com.harshad.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harshad.model.AnimalCategory;
import com.harshad.repository.AnimalCategoryRepository;

@Service
public class AnimalCategoryService {
    
     @Autowired
    AnimalCategoryRepository animalCategoryRepository;

    public List<AnimalCategory> getAllAnimalCategories() {
        return animalCategoryRepository.findAll();
    }

    public void addCategory(AnimalCategory category) {
        animalCategoryRepository.save(category);
    }

    public void removeCategoryById(int id) {
        animalCategoryRepository.deleteById(id);
    }

    public Optional<AnimalCategory> getcategoryById(int id) {
        return animalCategoryRepository.findById(id);
    }
}
