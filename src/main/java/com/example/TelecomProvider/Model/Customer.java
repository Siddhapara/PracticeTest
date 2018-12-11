package com.example.TelecomProvider.Model;

import java.util.HashMap;

public class Customer {
	
	private int customerId;
	private String customerName;
	private HashMap<Long,String> contactNumber;
	
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
	public HashMap<Long, String> getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(HashMap<Long, String> contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	
}
