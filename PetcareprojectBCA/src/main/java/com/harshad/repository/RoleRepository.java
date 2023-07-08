package com.harshad.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harshad.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
    
}
