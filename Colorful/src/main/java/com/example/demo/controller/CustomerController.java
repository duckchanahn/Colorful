package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;

import io.swagger.annotations.ApiOperation;

@RestController
public class CustomerController {
	
	@PostMapping("/login/colorful")
	@ApiOperation("로그인")
	public Customer login(String id, String pw) {
		
		
		return null;
	}
	
	
	@PostMapping("signup/colorful") 
	@ApiOperation("회원가입")
	public Customer signup(String id) {
		
		return null;
	}
	
	
	

}
