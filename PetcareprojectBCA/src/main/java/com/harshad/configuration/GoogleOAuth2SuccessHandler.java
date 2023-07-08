
  package com.harshad.configuration;
  
  import java.io.IOException; import java.util.ArrayList; import
  java.util.List;
  
  import javax.servlet.ServletException; import
  javax.servlet.http.HttpServletRequest; import
  javax.servlet.http.HttpServletResponse;
  
  import org.springframework.beans.factory.annotation.Autowired; import
  org.springframework.security.core.Authentication; import
  org.springframework.security.oauth2.client.authentication.
  OAuth2AuthenticationToken; import
  org.springframework.security.web.DefaultRedirectStrategy; import
  org.springframework.security.web.RedirectStrategy; import
  org.springframework.security.web.authentication.AuthenticationSuccessHandler;
  import org.springframework.stereotype.Component;
  
  import com.harshad.model.Role; import com.harshad.model.User; import
  com.harshad.repository.RoleRepository; import
  com.harshad.repository.UserRepository;
  
  @Component public class GoogleOAuth2SuccessHandler implements
  AuthenticationSuccessHandler {
  
  @Autowired RoleRepository roleRepository;
  
  @Autowired UserRepository userRepository;
  
  private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
  
  @Override public void onAuthenticationSuccess(HttpServletRequest
  httpServletRequest, HttpServletResponse httpServletResponse, Authentication
  authentication) throws IOException, ServletException {
  
  OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) authentication;
  
  String email = token.getPrincipal().getAttributes().get("email").toString();
  if (userRepository.findUserByEmail(email).isPresent()) {
  
  } else { User user = new User();
  user.setUsername(token.getPrincipal().getAttributes().get("username").
  toString());
  user.setPhoneno(token.getPrincipal().getAttributes().get("phoneno").toString(
  )); user.setEmail(email); List<Role> roles = new ArrayList<>();
  roles.add(roleRepository.findById(2).get()); user.setRoles((roles));
  userRepository.save(user);
  
  }
  
  redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse,
  "/admin");
  
  }
  
  }
 