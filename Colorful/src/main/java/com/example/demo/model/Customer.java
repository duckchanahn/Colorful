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
	
    private String token;
	private String customerName;
	private String userId;
    private String personalColor;
    private String psycologicalColor;
    private String loginType;

    
    public Customer() {
        this.customerId = 0;
        this.token = "";
        this.customerName = "";
        this.userId =  "";
        this.personalColor = "";
        this.psycologicalColor = "";
        this.loginType = "";
    }

    public Customer(int customerId, String token, String customerName, String userId, String personalColor, String psycologicalColor, String loginType) {
        this.customerId = customerId;
        this.token = token;
        this.customerName = customerName;
        this.userId = userId;
        this.personalColor = personalColor;
        this.psycologicalColor = psycologicalColor;
        this.loginType = loginType;
    }



    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }
    
}
