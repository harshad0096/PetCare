package com.harshad.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harshad.model.BillingDetails;

public interface BillingDetailsRepository  extends JpaRepository<BillingDetails, Integer>{

}
