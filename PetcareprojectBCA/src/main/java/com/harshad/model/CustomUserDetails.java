package com.harshad.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails extends User implements UserDetails {

    public CustomUserDetails(User user){
        super(user);
    }
    // Collection
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> authorityList=new ArrayList<>();
        super.getRoles().forEach(role -> {

            authorityList.add(new SimpleGrantedAuthority(role.getName()));
        });
        return authorityList;
        
    }

    // UserName 
    @Override
    public String getUsername() {
     
        return super.getEmail();
    }

    // password

    @Override
    public String getPassword() {
        
        return super.getPassword();
    }


    // Account Non Expired is true
    @Override
    public boolean isAccountNonExpired() {

        return true;
    }

    // Account non locked true
    @Override
    public boolean isAccountNonLocked() {
       
        return true;

    }

    @Override
    public boolean isCredentialsNonExpired() {
       return true;
    }

    @Override
    public boolean isEnabled() {

       return true;
    }

  

  
}
