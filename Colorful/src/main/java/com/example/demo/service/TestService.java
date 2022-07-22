package com.example.demo.service;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Constants.Constants;
import com.example.demo.repository.TestRepository;

@Service
public class TestService {
	
	@Autowired
	TestRepository testRepository;
	
	@Autowired
	Constants constants;

	@Transactional(readOnly = false)
	public String connectPersonalColorTest(int userId, byte[] image_binary) {
		RestTemplate restTemplate = new RestTemplate();
		JSONObject json = new JSONObject();
		json.put("image_binary", image_binary);
		
		ResponseEntity<String> result = restTemplate.postForEntity(constants.PERSONALCOLOR_TEST_URL, json, String.class);
		
		String personalColor = result.getBody();
		testRepository.saveByUserId(userId, personalColor);
		
		System.out.println(image_binary.length);
		System.out.println(personalColor);
		
		return personalColor;
	}

	public void testPersonalColor(String userId, String personalColor) {
		
	}
	
}
