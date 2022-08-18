package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="psycologicaltest_answer")
public class PsycologicalTestAnswer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int answerId;
	
	private int questionId;
	private String content;
	private char type;
	
	public PsycologicalTestAnswer() {
		super();
		
		this.answerId = 0;
		this.questionId = 0;
		this.content = "";
		this.type = 0;
	}
	
	
	public PsycologicalTestAnswer(int answerId, int questionId, String content, char type) {
		super();
		
		this.answerId = answerId;
		this.questionId = questionId;
		this.content = content;
		this.type = type;
	}


	public int getAnswerId() {
		return answerId;
	}


	public void setAnswerId(int answerId) {
		this.answerId = answerId;
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


	public char getType() {
		return type;
	}


	public void setType(char type) {
		this.type = type;
	}
	

}
