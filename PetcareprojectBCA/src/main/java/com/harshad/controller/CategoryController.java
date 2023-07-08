package com.harshad.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.harshad.global.GlobalData;
import com.harshad.model.Category;
import com.harshad.repository.UserRepository;
import com.harshad.service.CategoryService;
import com.harshad.service.DiseaseService;
import com.harshad.service.ProductService;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    
	
	@Autowired
	ProductService productService;
	
	@Autowired
	DiseaseService diseaseService;

	

	@Autowired
	UserRepository repository;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/dog")
    public String viewCategoriesPage1(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        
        return "DogProduct";
    }

    @GetMapping("/cat")
    public String viewCategoriesPage2(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        
        return "catproduct";
    }
    
    //fish

    @GetMapping("/fish")
    public String viewCategoriesfish(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        
        return "fish";
    }

    //terrul

    @GetMapping("/Turtle")
    public String viewCategoriesTurtle(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        
        return "Turtle";
    }
}
