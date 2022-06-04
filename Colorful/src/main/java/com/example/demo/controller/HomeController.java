package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
public class HomeController {

	
	@GetMapping(path = "/")
	@ApiOperation("test")
	@ResponseStatus(HttpStatus.OK)
	public String test() {
		return "test";
	}
	
}
