package com.harshad.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harshad.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    // add any custom methods here
}
