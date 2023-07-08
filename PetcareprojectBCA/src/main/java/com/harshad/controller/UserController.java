package com.harshad.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.harshad.global.GlobalData;
import com.harshad.model.Address;
import com.harshad.model.Product;
import com.harshad.model.User;
import com.harshad.repository.UserRepository;
import com.harshad.service.UserService;


@Controller
public class UserController {
	 @Autowired
	    private UserService userService;
	    
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/profile")
    public String userProfile(Model model, Principal principal) {
        String email = principal.getName();
        User user = userRepository.findByEmail(email);
        model.addAttribute("user", user);
        return "profile";
    }
   
    @GetMapping("/Address")
	public String adminHome() {
		return "BookingAddress";

	}
    @GetMapping("/Allusers")
public String getAdminPage(Model model) {
    List<User> users = userRepository.findAll();
    model.addAttribute("user", users);
    return "Allusers";
}

//update

@GetMapping("/checkout")
    public String userChekout(Model model, Principal principal) {
       
        double total = GlobalData.cart.stream().mapToDouble(p -> p.getPrice() * p.getQuantity()).sum();
    model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
 String email = principal.getName();
        User user = userRepository.findByEmail(email);
        model.addAttribute("user", user);
        return "checkout";
    }

@PostMapping("/user/profile/update")
public String updateUserProfile(@ModelAttribute("user") User updatedUser, Model model, Principal principal) {
   
    String email = principal.getName();
    User user = userRepository.findByEmail(email);
    user.setUsername(updatedUser.getUsername());
    user.setPhoneno(updatedUser.getPhoneno());
    user.setUserAddress(updatedUser.getUserAddress());
    user.setEmail(updatedUser.getEmail());
    user.setCity(updatedUser.getCity());
   
    // Update other user properties as needed

    userRepository.save(user);
    model.addAttribute("user", user);
    return "redirect:/peyment";
}
    
}
