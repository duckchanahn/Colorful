package com.example.demo.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.TestService;

import io.swagger.annotations.ApiOperation;

@RestController
public class TestController {
	
	@Autowired
	TestService testService;
	
	@PostMapping("/test/personalcolor")
	@ApiOperation("퍼스널컬러 테스트")
	public String testPersonalColor(@RequestBody HashMap<String, Object> param) {
		return testService.connectPersonalColorTest((int)param.get("userId"), (byte[])param.get("image_binary"));
	}

}
