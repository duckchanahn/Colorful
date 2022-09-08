package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
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
		System.out.println("퍼스널컬러 테스트 입장! ==================");
		String result = testService.connectPersonalColorTest((int)param.get("customerId"), (String)param.get("binary"));
		System.out.println("!! 결과 !! " + result);
		return result;
	}
	
	@PostMapping("/test/personal/result")
	@ApiOperation("퍼스널컬러 테스트 결과 저장")
	@ResponseBody
	public int updatePersonalResult(int customerId, String result) {
		System.out.println("퍼스널컬러 결과 저장 입장! ==================");
		System.out.println("customerId : " + customerId + ", " + "result : " + result);
		return testService.updatePersonalResult(customerId, result);
	}
	
	@GetMapping("/test/psycological/question")
	@ApiOperation("심리컬러 질문지 받아오기")
	@ResponseBody
	public List<PsycologicalTestQuestion> getPsycologicalQuestion() {
		System.out.println("심리컬러 질문 받기 입장! ==================");
		return testService.getPsycologicalQuestion();
	}
	
	@GetMapping("/test/psycological/answer")
	@ApiOperation("심리컬러 답변 받아오기")
	@ResponseBody
	public List<PsycologicalTestAnswer> getPsycologicalAnswer() {
		System.out.println("심리컬러 답변 받기 입장! ==================");
		return testService.getPsycologicalAnswer();
	}
	
	@PostMapping("/test/psycological/result")
	@ApiOperation("심리컬러 결과 저장")
	@ResponseBody
	public int updatePsycologicalResult(int customerId, String result) {
		System.out.println("심리컬러 결과 저장 입장! ==================");
		System.out.println("customerId : " + customerId + ", " + "result : " + result);
		return testService.updatePsycologicalResult(customerId, result);
	}
	
}
