package com.harshad.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.harshad.dto.DiseaseDTO;
import com.harshad.dto.ProductDTO;
import com.harshad.model.AnimalCategory;
import com.harshad.model.Category;
import com.harshad.model.Contact;
import com.harshad.model.Disease;
import com.harshad.model.Product;
import com.harshad.repository.ContactRepository;
import com.harshad.service.AnimalCategoryService;
import com.harshad.service.CategoryService;
import com.harshad.service.DiseaseService;
import com.harshad.service.ProductService;



@Controller
public class AdminController {

	// public static String uploadDir = System.getProperty("user.dir") +
	// "E://website
	// create/Petcareproject/PetcareprojectBCA/src/mainresources/static/productImages";
	public static String uploadDir = "D:/petcare/team 14 project with email/team 14 project/team 14 project/Petcareproject/PetcareprojectBCA/src/main/resources/static/productImages";
	
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;

	@GetMapping("/admin")
	public String adminHome() {
		return "adminHome";

	}

	// category
	@GetMapping("/admin/categories")
	public String getcat(Model model) {
		model.addAttribute("categories", categoryService.getAllCategories());
		return "categories";
	}

	// add cat
	@GetMapping("/admin/categories/add")
	public String addcatadd(Model model) {
		model.addAttribute("category", new Category());
		return "categoriesAdd";
	}

	// get cat
	@PostMapping("/admin/categories/add")
public String postcat(@ModelAttribute("category") Category category) {
    categoryService.addCategory(category);
    return "redirect:/admin/categories";
}


	// delect cat
	@GetMapping("/admin/categories/delete/{id}")
	public String deletecat(@PathVariable int id) {
		categoryService.removeCategoryById(id);
		return "redirect:/admin/categories";
	}

	// update cat
	@GetMapping("/admin/categories/update/{id}")
	public String updateCat(@PathVariable int id, Model model) {
		Optional<Category> category = categoryService.getcategoryById(id);
		if (category.isPresent()) {
			model.addAttribute("category", category.get());

			return "categoriesAdd";
		} else
			return "404";
	}

	// product section

	@GetMapping("/admin/products")
	public String products(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}

	// get all category to add product option
	@GetMapping("/admin/products/add")
	public String productAddGet(Model model) {
		model.addAttribute("productDTO", new ProductDTO());
		model.addAttribute("categories", categoryService.getAllCategories());
		return "productsAdd";
	}

	// add product
	@PostMapping("/admin/products/add")
	public String ProductAddPost(@ModelAttribute("productDTO") ProductDTO productDTO,
			@RequestParam("productImage") MultipartFile file,
			@RequestParam("imgName") String imgName) throws IOException {

		Product product = new Product();
		product.setId(productDTO.getId());
		product.setName(productDTO.getName());
		product.setCategory(categoryService.getcategoryById(productDTO.getCategoryId()).get());
		product.setPrice(productDTO.getPrice());
		product.setDescription(productDTO.getDescription());
		String imageUUID;

		try {
			if (!file.isEmpty()) {
				imageUUID = file.getOriginalFilename();
				Path fileNameAndPath = Paths.get(uploadDir, imageUUID);
				Files.write(fileNameAndPath, file.getBytes());
			} else {
				imageUUID = imgName;
			}
			product.setImageName(imageUUID);
			productService.addProduct(product);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Exception of the file ..............." + e);
		}
		return "redirect:/admin/products";
	}

	// delete product

	@GetMapping("/admin/product/delete/{id}")
	public String deleteProduct(@PathVariable long id) {
		productService.removeProductById(id);
		return "redirect:/admin/products";
	}

	// update product

	@GetMapping("/admin/product/update/{id}")
	public String updateProductGet(@PathVariable long id, Model model) {

		Product product = productService.getProductById(id).get();
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(product.getId());
		productDTO.setName(product.getName());
		productDTO.setCategoryId(product.getCategory().getId());
		productDTO.setPrice(product.getPrice());
		productDTO.setDescription(product.getDescription());
		productDTO.setImageName(product.getImageName());

		model.addAttribute("categories", categoryService.getAllCategories());
		model.addAttribute("productDTO", productDTO);
		return "productsAdd";
	}


	// //////////////////////////////////////////////////////////////////////////////////////////////
	@Autowired
	AnimalCategoryService animalCategoryService;
	@Autowired
	DiseaseService diseaseService;

	// category
	@GetMapping("/admin/animalcategories")
	public String getanimalcat(Model model) {
		model.addAttribute("categories", animalCategoryService.getAllAnimalCategories());
		return "animalcategories";
	}

	// add cat
	@GetMapping("/admin/animalcategories/add")
	public String addanimalcatadd(Model model) {
		model.addAttribute("category", new AnimalCategory());
		return "animalcategoriesAdd";
	}

	// get cat
	@PostMapping("/admin/animalcategories/add")
	public String postanimalcat(@ModelAttribute("category") AnimalCategory category) {
		animalCategoryService.addCategory(category);
		return "redirect:/admin/animalcategories";
	}

	// delect cat
	@GetMapping("/admin/animalcategories/delete/{id}")
	public String deleteanimalcat(@PathVariable int id) {
		animalCategoryService.removeCategoryById(id);
		return "redirect:/admin/animalcategories";
	}

	// update cat
	@GetMapping("/admin/animalcategories/update/{id}")
	public String updateanimalCat(@PathVariable int id, Model model) {
		Optional<AnimalCategory> category = animalCategoryService.getcategoryById(id);
		if (category.isPresent()) {
			model.addAttribute("category", category.get());

			return "animalcategoriesAdd";
		} else
			return "404";
	}


// ///////////////////////////////////////////////disease
// disease
// Add Disease
@GetMapping("/admin/disease")
public String disease(Model model) {
	model.addAttribute("disease", diseaseService.getAllDisease());
	return "disease";
}

// get all category to add product option
@GetMapping("/blog/add")
public String diseaseAddGet(Model model) {
	model.addAttribute("diseaseDTO", new DiseaseDTO());
	model.addAttribute("animalcategories", animalCategoryService.getAllAnimalCategories());
	return "diseasesAdd";
}
@PostMapping("/blog/add")
	public String ProductAddPost(@ModelAttribute("diseaseDTO") DiseaseDTO diseaseDTO,
			@RequestParam("productImage") MultipartFile file,
			@RequestParam("imgName") String imgName) throws IOException {

		Disease disease = new Disease();
		disease.setId(diseaseDTO.getId());
		disease.setName(diseaseDTO.getName());
		disease.setCategory(animalCategoryService.getcategoryById(diseaseDTO.getCategoryId()).get());
		disease.setDescription(diseaseDTO.getDescription());
		String imageUUID;

		try {
			if (!file.isEmpty()) {
				imageUUID = file.getOriginalFilename();
				Path fileNameAndPath = Paths.get(uploadDir, imageUUID);
				Files.write(fileNameAndPath, file.getBytes());
			} else {
				imageUUID = imgName;
			}
			disease.setImageName(imageUUID);
			diseaseService.addDisease(disease);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Exception of the file ..............." + e);
		}
		return "redirect:/disease";
	}

	// delete product

	@GetMapping("/admin/disease/delete/{id}")
	public String deleteDisease(@PathVariable long id) {
		diseaseService.removeDiseaseById(id);
		return "redirect:/disease";
	}

	// update product

	@GetMapping("/admin/disease/update/{id}")
	public String updateDiseaseGet(@PathVariable long id, Model model) {

		Disease disease = diseaseService.getDiseaseById(id).get();
		DiseaseDTO diseaseDTO = new DiseaseDTO();
		diseaseDTO.setId(disease.getId());
		diseaseDTO.setName(disease.getName());
		diseaseDTO.setCategoryId(disease.getCategory().getId());
		diseaseDTO.setDescription(disease.getDescription());
		diseaseDTO.setImageName(disease.getImageName());

		model.addAttribute("categories", categoryService.getAllCategories());
		model.addAttribute("diseaseDTO", diseaseDTO);
		return "diseasesAdd";
	}
//contact
	
	private final ContactRepository contactRepository;

    public AdminController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @GetMapping("/admin/viewcontact")
    public String showContacts(Model model) {
        java.util.List<Contact> contacts = contactRepository.findAll();
        model.addAttribute("contacts", contacts);
        return "viewcontact";
    }
	@GetMapping("/admin/deletecontact/{id}")
	public String deleteContact(@PathVariable("id") Long id) {
		Optional<Contact> contactOptional = contactRepository.findById(id);
		
		if (contactOptional.isPresent()) {
			Contact contact = contactOptional.get();
			contactRepository.delete(contact);
		}
		
		return "redirect:/admin/viewcontact";
	}



}



