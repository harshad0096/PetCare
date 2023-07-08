package com.harshad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harshad.model.BillingDetails;
import com.harshad.repository.BillingDetailsRepository;

@Service
public class BillingDetailsService {

    @Autowired
    private BillingDetailsRepository billingDetailsRepository;

    public BillingDetails saveBillingDetails(BillingDetails billingDetails) {
        return billingDetailsRepository.save(billingDetails);
    }

    public void save(BillingDetails billingDetails) {
    }
}
