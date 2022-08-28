package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="palette")
public class Palette {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int paletteId;
	String name;
	String due;
	int customerId;
	
	public Palette() {
		super();
		
		this.paletteId = 0;
		this.name = "";
		this.due = "";
		this.customerId = 0;
	}
	
	public Palette(int paletteId, String name, String due, int customerId) {
		super();
		
		this.paletteId = paletteId;
		this.name = name;
		this.due = due;
		this.customerId = customerId;
	}

	public int getPaletteId() {
		return paletteId;
	}

	public void setPaletteId(int paletteId) {
		this.paletteId = paletteId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDue() {
		return due;
	}

	public void setDue(String due) {
		this.due = due;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
}
