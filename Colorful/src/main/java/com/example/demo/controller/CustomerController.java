package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

import io.swagger.annotations.ApiOperation;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;

	@PostMapping("/customer/login")
	@ApiOperation("로그인")
	public Customer login(String token) {
		System.out.println("start login ---------------------------------");
		System.out.println(token);
		System.out.println(customerService.login(token));
		return customerService.login(token);
	}
	
	@PostMapping("/customer/signup")
	@ApiOperation("회원가입")
	public Customer signup(@RequestBody Customer customer) {
		System.out.println("start signup ---------------------------------");
		return customerService.signup(customer);
	}
	
	@PostMapping("/customer/logout")
	@ApiOperation("로그아웃")
	public int logout(String customerId) {
		return customerService.logout(customerId);
	}
	
	@PostMapping("/customer/withdrawal")
	@ApiOperation("회원탈퇴")
	public int withdrawal(String customerId) {
		return customerService.withdrawal(customerId);
	}
	
	
	

}
