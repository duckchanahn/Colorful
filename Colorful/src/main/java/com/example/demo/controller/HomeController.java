package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Test;
import com.example.demo.service.TestService;

import io.swagger.annotations.ApiOperation;

@RestController
public class HomeController {
	
	@Autowired
	TestService testService;

	
	@PostMapping(path = "/")
	@ApiOperation("test")
	@ResponseStatus(HttpStatus.OK)
	public List<Test> test() {
		
		return null;
	}
	
}
