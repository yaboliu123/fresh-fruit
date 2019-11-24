package com.liuyabo.appnew.service;

import com.liuyabo.appnew.entity.Customer;
import com.liuyabo.appnew.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CustomerQueryService {

    @Autowired
    private CustomerRepository customerRepository;

    @PreAuthorize(value = "@permissionValidator.isAllowed()")
    public Collection<Customer> getCustomers() {
        Collection<Customer> result = customerRepository.findAll();
        return result;
    }
}
