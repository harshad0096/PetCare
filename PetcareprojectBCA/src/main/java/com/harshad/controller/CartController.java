package com.harshad.controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import java.security.Principal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.harshad.global.GlobalData;
import com.harshad.model.Product;
import com.harshad.model.User;
import com.harshad.repository.UserRepository;
import com.harshad.service.ProductService;

@Controller
public class CartController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    ProductService productService;

    @GetMapping("/product/{id}")
    public String getProductDetails(@PathVariable int id, Model model) {
        Optional<Product> optionalProduct = productService.getProductById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            model.addAttribute("product", product);
            return "product-details";
        }
        return "redirect:/shop";
    }

    @GetMapping("/addToCart/{id}")
    public String addToCart(@PathVariable int id, @RequestParam(value = "quantity", defaultValue = "1") int quantity) {
        Optional<Product> optionalProduct = productService.getProductById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            GlobalData.cart.add(product);
            product.setQuantity(quantity);
        }
        return "redirect:/shop";
    }

    @GetMapping("/updateQuantity/{id}")
    public String updateQuantity(@PathVariable int id, @RequestParam(value = "quantity") int quantity) {
        Optional<Product> optionalProduct = productService.getProductById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            int previousQuantity = product.getQuantity();
            int quantityDifference = quantity - previousQuantity;

            if (quantityDifference > 0) {
                // Increase quantity
                for (int i = 0; i < quantityDifference; i++) {
                    GlobalData.cart.add(product);
                }
            } else if (quantityDifference < 0) {
                // Decrease quantity
                for (int i = 0; i < -quantityDifference; i++) {
                    GlobalData.cart.remove(product);
                }
            }

            product.setQuantity(quantity);
        }
        return "redirect:/shop";
    }

   /* @GetMapping("/addToCart/{id}")
public String addToCart(@PathVariable int id) {
    Product product = productService.getProductById(id).get();
    GlobalData.cart.add(product);
    int quantity = Collections.frequency(GlobalData.cart, product);
    product.setQuantity(quantity);
    
    return "redirect:/shop";
}
 */

@GetMapping("/cart")
public String cartGet(Model model) {
    double total = GlobalData.cart.stream().mapToDouble(p -> p.getPrice() * p.getQuantity()).sum();
    model.addAttribute("cartCount", GlobalData.cart.size());
    model.addAttribute("total", total);
    model.addAttribute("cart", GlobalData.cart);
    return "cart";
}

@GetMapping("/adminorder")
public String adminOrder(Model model, Principal principal) {
    // Retrieve user details
    String email = principal.getName();
    User user = userRepository.findByEmail(email);
    model.addAttribute("user", user);

    // Generate current date
    LocalDate currentDate = LocalDate.now();
    model.addAttribute("currentDate", currentDate);

    // Generate 5 days after date
    LocalDate afterDate = currentDate.plusDays(8);
    model.addAttribute("afterDate", afterDate);

    // Generate a random number
    Random random = new Random();
    int randomNumber = random.nextInt(9000) + 1000;
    model.addAttribute("randomNumber", randomNumber);

    // Calculate total and add cart details
    double total = GlobalData.cart.stream().mapToDouble(p -> p.getPrice() * p.getQuantity()).sum();
    model.addAttribute("cartCount", GlobalData.cart.size());
    model.addAttribute("total", total);
    model.addAttribute("cart", GlobalData.cart);

    return "showadminorder";
}

    @GetMapping("/cart/removeItem/{index}")
    public String cartItemremove(@PathVariable int index) {

        GlobalData.cart.remove(index);
        return "redirect:/cart";
    }

    

    //user order page

    @GetMapping("/userorder")
public String userOrder(Model model, Principal principal) {
    // Retrieve user details
    String email = principal.getName();
    User user = userRepository.findByEmail(email);
    model.addAttribute("user", user);
    // Generate current date
    LocalDate currentDate = LocalDate.now();
    model.addAttribute("currentDate", currentDate);

    // Generate 5 days after date
    LocalDate afterDate = currentDate.plusDays(5);
    model.addAttribute("afterDate", afterDate);

    // Generate a random number
    Random random = new Random();
    int randomNumber = random.nextInt(90000000) + 10000000;
    model.addAttribute("randomNumber", randomNumber);
 // Generate a random number
 Random random1 = new Random();
 int randomNumber1 = random.nextInt(100);
 model.addAttribute("orderid", randomNumber);

    // Calculate total and add cart details
    double total = GlobalData.cart.stream().mapToDouble(p -> p.getPrice() * p.getQuantity()).sum();
    model.addAttribute("cartCount", GlobalData.cart.size());
    model.addAttribute("total", total);
    model.addAttribute("cart", GlobalData.cart);

    return "userorders";
}

}
