package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query("SELECT c FROM Customer c WHERE c.token = :token")
	Customer findByToken(String token);

	@Modifying
	@Query("UPDATE Customer c SET c.token = '' WHERE  c.customerId = :customerId")
	int logout(String customerId);
	
	@Modifying
	@Query("DELETE FROM Customer c WHERE c.customerId = :customerId")
	int withdrawal(String customerId);
	
	
	
}
