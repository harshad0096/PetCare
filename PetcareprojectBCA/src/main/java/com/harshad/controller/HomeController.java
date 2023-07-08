package com.harshad.controller;

import java.security.Principal;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.harshad.global.GlobalData;
import com.harshad.model.Contact;
import com.harshad.model.Product;
import com.harshad.model.User;
import com.harshad.repository.UserRepository;
import com.harshad.service.AnimalCategoryService;
import com.harshad.service.CategoryService;
import com.harshad.service.ContactService;
import com.harshad.service.DiseaseService;
import com.harshad.service.ProductService;


@Controller
public class HomeController {

	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;
	@Autowired 
	AnimalCategoryService animalCategoryService;
	@Autowired
	DiseaseService diseaseService;

	
	@Autowired
	UserRepository repository;

	@GetMapping({ "/" ,"/Home" })
	public String home(Model model) {

		model.addAttribute("cartCount", GlobalData.cart.size());
		return "index";
	}
	@GetMapping("/cat")
	
	public String cat(Model model) {
		model.addAttribute("categories", categoryService.getAllCategories());
		model.addAttribute("products", productService.getAllProducts());
		model.addAttribute("cartCount", GlobalData.cart.size());
		return "catproduct";
	}
	//dog page
    @GetMapping("/dogpage")
	
	public String dog(Model model) {
		model.addAttribute("categories", categoryService.getAllCategories());
		model.addAttribute("products", productService.getAllProducts());
		model.addAttribute("cartCount", GlobalData.cart.size());
		return "DogProduct";
	}
	//fish

	@GetMapping("/fish")
	
	public String fish(Model model) {
		model.addAttribute("categories", categoryService.getAllCategories());
		model.addAttribute("products", productService.getAllProducts());
		model.addAttribute("cartCount", GlobalData.cart.size());
		return "fish";
	}

	//Turtle

	@GetMapping("/Turtle")
	
	public String Turtle(Model model) {
		model.addAttribute("categories", categoryService.getAllCategories());
		model.addAttribute("products", productService.getAllProducts());
		model.addAttribute("cartCount", GlobalData.cart.size());
		return "Turtle";
	}
	@GetMapping("/shop")
	public String shop(Model model) {
		model.addAttribute("categories", categoryService.getAllCategories());
		model.addAttribute("products", productService.getAllProducts());
		model.addAttribute("cartCount", GlobalData.cart.size());
		return "shop";
	}

	@GetMapping("/shop/category/{id}")
	public String shopByCategory(Model model, @PathVariable int id) {
		model.addAttribute("categories", categoryService.getAllCategories());
		model.addAttribute("products", productService.getAllProductByCategoryId(id));
		model.addAttribute("cartCount", GlobalData.cart.size());
		return "shop";
	}

	@GetMapping("/shop/viewproduct/{id}")
	public String Viewshop(Model model, @PathVariable int id) {
		model.addAttribute("categories", categoryService.getAllCategories());
		model.addAttribute("products", productService.getAllProductByCategoryId(id));
		model.addAttribute("cartCount", GlobalData.cart.size());
		model.addAttribute("product", productService.getProductById(id).get());
		model.addAttribute("cartCount", GlobalData.cart.size());
		return "view";
	}
	@GetMapping({ "/contact" })
	public String contact(Model model) {

		model.addAttribute("cartCount", GlobalData.cart.size());
		return "CONTACT";
	}

	//payment
	@GetMapping({ "/peyment" })
	public String payment(Model model)  {
		double total = GlobalData.cart.stream().mapToDouble(p -> p.getPrice() * p.getQuantity()).sum();
		Random random = new Random();
    int randomNumber = random.nextInt(900000) + 100000;
    model.addAttribute("orderid", randomNumber);
		model.addAttribute("cartCount", GlobalData.cart.size());
		model.addAttribute("total", total);
		model.addAttribute("cart", GlobalData.cart);
		return "payment";
	}
	// Animal disease

@GetMapping("/disease")
public String disease(Model model) {
	model.addAttribute("animalcategories", animalCategoryService.getAllAnimalCategories());
	model.addAttribute("disease", diseaseService.getAllDisease());
	// model.addAttribute("cartCount", GlobalData.cart.size());
	return "animal";
}


@GetMapping("/disease/category/{id}")
public String diseaseByCategory(Model model, @PathVariable int id) {
	model.addAttribute("categories", animalCategoryService.getAllAnimalCategories());
	model.addAttribute("disease", diseaseService.getAllDiseaseByCategoryId(id));
	// model.addAttribute("cartCount", GlobalData.cart.size());
	return "animal";
}


@GetMapping("/disease/viewdisease/{id}")
public String Viewdisease(Model model, @PathVariable int id) {

	model.addAttribute("disease", diseaseService.getDiseaseById(id).get());
	// model.addAttribute("cartCount", GlobalData.cart.size());
	return "animal";
}

//contact
private final ContactService contactService;

public HomeController(ContactService contactService) {
    this.contactService = contactService;
}

@GetMapping("/contact-show")
public String showContact(Model model) {	
		model.addAttribute("contact", contactService.getAllContacts());

	return "contact";
}

@GetMapping("/contact-form")
public String showContactForm(Model model) {
    model.addAttribute("contact", new Contact());
    return "index";
}

@PostMapping("/contact")
public String submitContactForm(@ModelAttribute("contact") Contact contact) {
    contactService.save(contact);
    return "/feedback";
}

//prifile


	
@GetMapping("/profile")
public String showProfile(Model model, Principal principal) {
    String email = principal.getName();
    // retrieve user information from database using username
    User user = repository.findByEmail(email);
    model.addAttribute("user", user);
    return "profile";
}
//

//category product retrive



}
