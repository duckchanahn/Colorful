package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Test;
import com.example.demo.repository.TestRepository;

@Service
public class TestService {
	
	@Autowired
	TestRepository testRepository;

	
	public List<Test> test_init() {
		
		return testRepository.findAll();
	}
}
