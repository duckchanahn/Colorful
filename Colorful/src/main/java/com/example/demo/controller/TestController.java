package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.PsycologicalTestAnswer;
import com.example.demo.model.PsycologicalTestQuestion;
import com.example.demo.service.TestService;

import io.swagger.annotations.ApiOperation;

@RestController
public class TestController {
	
	@Autowired
	TestService testService;
	
	@PostMapping("/test/personalcolor")
	@ApiOperation("퍼스널컬러 테스트")
	public String testPersonalColor(@RequestBody HashMap<String, Object> param) {
		
		System.out.println("start-----------------------------------------");
//		byte[] binary = Base64.getDecoder().decode((String) param.get("binary"));
//		String test = testService.connectPersonalColorTest((int)param.get("customerId"), (String)param.get("binary"));
//		System.out.println("binary : " + (String)param.get("binary"));
		
		return testService.connectPersonalColorTest((int)param.get("customerId"), (String)param.get("binary"));
	}
	
	@GetMapping("/test/psycological/question")
	@ApiOperation("심리컬러 질문지 받아오기")
	public List<PsycologicalTestQuestion> getPsycologicalQuestion() {
		return testService.getPsycologicalQuestion();
	}
	
	@GetMapping("	")
	@ApiOperation("심리컬러 답변 받아오기")
	public List<PsycologicalTestAnswer>getPsycologicalAnswer() {
		return testService.getPsycologicalAnswer();
	}
	
}
