package com.example.demo.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Constants.Constants;
import com.example.demo.model.Test;
import com.example.demo.service.TestService;

import io.swagger.annotations.ApiOperation;

@RestController
public class HomeController {
	
	@Autowired
	TestService testService;

	@Autowired
	Constants constants;

	
	@GetMapping(path = "/test")
	@ApiOperation("test")
	@ResponseStatus(HttpStatus.OK)
	public String test() {
		
		return "test";
	}
	
	@GetMapping(path = "/test/flask")
	@ApiOperation("test flask")
	@ResponseStatus(HttpStatus.OK)
	public String testFlask() {
		RestTemplate restTemplate = new RestTemplate();
		
		return restTemplate.getForEntity(constants.TEST_CONNECT_URL, String.class).toString();
	}
	
}
