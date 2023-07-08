
package com.harshad.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.harshad.model.ConfirmationToken;
import com.harshad.model.Role;
import com.harshad.model.User;
import com.harshad.repository.ConfirmationTokenRepository;
import com.harshad.repository.RoleRepository;
import com.harshad.repository.UserRepository;
import com.harshad.service.EmailService;
import com.harshad.service.OTPService;

@Controller
public class LoginController {

  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  @Autowired
  UserRepository userRepository;

  @Autowired
	private OTPService userService;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  private ConfirmationTokenRepository confirmationTokenRepository;

  @Autowired
  private EmailService emailService;

  @GetMapping("/login")
  public String login() {

    return "login";
  }

  @GetMapping("/otp")
  public String otp() {

    return "otpvalid";
  }

  @ExceptionHandler(Exception.class)
  public String exceptionHandler(Exception e, Model model) {
    model.addAttribute("errorMessage", e.getMessage());
    return "404";
  }
  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public ModelAndView displayRegistration(ModelAndView modelAndView, User userEntity) {
    modelAndView.addObject("User", userEntity);
    modelAndView.setViewName("register");
    return modelAndView;
  }

  @RequestMapping(value = "/register", method = RequestMethod.POST)
  public ModelAndView registerUser(ModelAndView modelAndView, User userEntity) {

    User existingUser = userRepository.findByEmail(userEntity.getEmail());
    if (existingUser != null) {
      modelAndView.addObject("message", "This email already exists!");
      modelAndView.setViewName("error");
    } else {
      String password = userEntity.getPassword();
      userEntity.setPassword(bCryptPasswordEncoder.encode(password));

      List<Role> roles = new ArrayList<>();
      roles.add(roleRepository.findById(2).get());
      userEntity.setRoles(roles);
      userRepository.save(userEntity);

      ConfirmationToken confirmationToken = new ConfirmationToken(userEntity);

      confirmationTokenRepository.save(confirmationToken);

      SimpleMailMessage mailMessage = new SimpleMailMessage();
      mailMessage.setTo(userEntity.getEmail());
      mailMessage.setSubject("Complete Registration!");
      mailMessage.setText("To confirm your account, please click here : "
          + "http://localhost:9192/confirm-account?token=" + confirmationToken.getConfirmationToken());

      emailService.sendEmail(mailMessage);

      modelAndView.addObject("emailId", userEntity.getEmail());

      modelAndView.setViewName("successfulRegisteration");
    }

    return modelAndView;
  }

  @RequestMapping(value = "/confirm-account", method = { RequestMethod.GET, RequestMethod.POST })
  public ModelAndView confirmUserAccount(ModelAndView modelAndView, @RequestParam("token") String confirmationToken) {
    ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);

    if (token != null) {
      User user = userRepository.findByEmail(token.getUserEntity().getEmail());
      user.setEnabled(true);
      userRepository.save(user);
      modelAndView.setViewName("accountVerified");
    } else {
      modelAndView.addObject("message", "The link is invalid or broken!");
      modelAndView.setViewName("error");
    }

    return modelAndView;
  }
 

@PostMapping("/addUser")
public String addUser(@RequestBody User user) {
  userService.saveUser(user);
  return "Success";
}

}
