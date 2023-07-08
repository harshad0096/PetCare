package com.harshad.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harshad.model.Category;
import com.harshad.repository.CategoryRepository;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    public List<Category> getAllCategories(List<String> categoryNames) {
        return categoryRepository.findByNameIn(categoryNames);
    }
    
    public List<Category> getcatCategories() {
        List<String> categoryNames = Arrays.asList("cat food", "cat toys");
        return categoryRepository.findByNameIn(categoryNames);
    }
    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public void removeCategoryById(int id) {
        categoryRepository.deleteById(id);
    }

    public Optional<Category> getcategoryById(int id) {
        return categoryRepository.findById(id);
    }

    public List<Category> getdogCategories() {
        List<String> categoryNames = Arrays.asList("Dog food ", "Dog toys","Dog Accessories");
        return categoryRepository.findByNameIn(categoryNames);
    }

    public List<Category> getSelectedCategories() {
        List<Category> allCategories = getAllCategories();
        return allCategories.subList(0, 5); // get first 9 categories
    }
    
}