package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    private String customerName;
    private String personalColor;
    private String psychologiclaColor;

    public Customer() {
        this.customerId = 0;
        this.customerName = "";
        this.personalColor = "";
        this.psychologiclaColor = "";
    }

    public Customer(int customerId, String customerName, String personalColor, String psychologiclaColor) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.personalColor = personalColor;
        this.psychologiclaColor = psychologiclaColor;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPersonalColor() {
        return personalColor;
    }

    public void setPersonalColor(String personalColor) {
        this.personalColor = personalColor;
    }

    public String getPsychologiclaColor() {
        return psychologiclaColor;
    }

    public void setPsychologiclaColor(String psychologiclaColor) {
        this.psychologiclaColor = psychologiclaColor;
    }
}
