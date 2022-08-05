package com.example.demo.service;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Constants.Constants;
import com.example.demo.model.PsycologicalTestAnswer;
import com.example.demo.model.PsycologicalTestQuestion;
import com.example.demo.repository.TestRepository;

@Service
public class TestService {
	
	@Autowired
	TestRepository testRepository;
	
	@Autowired
	Constants constants;

	@Transactional(readOnly = false)
	public String connectPersonalColorTest(int customerId, String image_binary) {
		RestTemplate restTemplate = new RestTemplate();
		JSONObject json = new JSONObject();
		json.put("binary", image_binary);
		
		ResponseEntity<String> result = restTemplate.postForEntity(constants.PERSONALCOLOR_TEST_URL, json, String.class);
		
		String personalColor = result.getBody();
		System.out.println("personalColor : " + personalColor);
		testRepository.saveByUserId(customerId, personalColor);
		
		return personalColor;
	}

	public void testPersonalColor(String customerId, String personalColor) {
		
	}

	public List<PsycologicalTestQuestion> getPsycologicalQuestion() {
		List<PsycologicalTestQuestion> questions = this.testRepository.getPsycologicalQuestion();
		return questions;
	}
	
	public List<PsycologicalTestAnswer> getPsycologicalAnswer() {
		List<PsycologicalTestAnswer> answers = this.testRepository.getPsycologicalAnswer();
		return answers;
	}
	
}
