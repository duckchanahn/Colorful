package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="test")
public class Test {

	public Test() {
		super();
		
		this.testId = 0;
		this.testContent = "";
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int testId;
	
	String testContent;
	
	public Test(int testId, String testContent) {
		super();
		this.testId = testId;
		this.testContent = testContent;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public String getTestContent() {
		return testContent;
	}

	public void setTestContent(String testContent) {
		this.testContent = testContent;
	}
	
	
	
}