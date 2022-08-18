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
    private String userId;
    private String personalColor;
    private String psycologicalColor;

    public Customer() {
        this.customerId = 0;
        this.customerName = "";
        this.userId =  "";
        this.personalColor = "";
        this.psycologicalColor = "";
    }

    public Customer(int customerId, String customerName, String userId, String personalColor, String psycologicalColor) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.userId = userId;
        this.personalColor = personalColor;
        this.psycologicalColor = psycologicalColor;
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

    public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPersonalColor() {
        return personalColor;
    }

    public void setPersonalColor(String personalColor) {
        this.personalColor = personalColor;
    }

    public String getPsycologicalColor() {
        return psycologicalColor;
    }

    public void setPsycologicalColor(String psycologicalColor) {
        this.psycologicalColor = psycologicalColor;
    }
}
