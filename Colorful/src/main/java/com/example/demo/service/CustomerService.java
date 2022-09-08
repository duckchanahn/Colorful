package com.example.demo.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	public Customer login(String token) {
		return this.customerRepository.findByToken(token);
	}

	public Customer signup(Customer customer) {
		return this.customerRepository.save(customer);
	}

	@Transactional(readOnly = false)
	public int logout(String customerId) {
		return this.customerRepository.logout(customerId);
	}

	@Transactional(readOnly = false)
	public int withdrawal(String customerId) {
		return this.customerRepository.withdrawal(customerId);
	}

}
