package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="psycologicaltest_answer")
public class PsycologicalTestQuestion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int questionId;
	
	private String content;
	private String type;
	
	public PsycologicalTestQuestion() {
		super();
		
		this.questionId = 0;
		this.content = "";
		this.type = "";
	}
	
	
	public PsycologicalTestQuestion(int questionId, String content, String type) {
		super();
		
		this.questionId = questionId;
		this.content = content;
		this.type = type;
	}


	public int getQuestionId() {
		return questionId;
	}


	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}
	

}
