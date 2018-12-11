package com.example.TelecomProvider.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.example.TelecomProvider.Model.Customer;


@Service
public class CustomerService {
	
	HashSet<Customer> customerRecords=new HashSet<>();
	
	/*Here we are adding customer record in collection
	  New record added when it is not in DB(Collection) 
	  if it is Collection then it will get updated
	*/
	public String addCustomerDetails(Customer customer) {	
		if(Objects.isNull(customer))
			throw new Error("PLEASE ENTER CUSTOMER DETAILS");
	
		Customer c =customerRecords
				    .stream()
				    .filter(c1->c1.getCustomerId()==customer.getCustomerId())
			        .findAny()
				    .orElse(null);
		if(Objects.isNull(c)) {
			customerRecords.add(customer);
			return "New record added";
		}
		else{
			c.setCustomerName(customer.getCustomerName());
			c.getContactNumber().putAll(customer.getContactNumber());
			return "Existing Record Updated";
		}
		
	}
	
	
	/*Here we are retrieving customer records from 
	  collection
	*/
	public HashSet<Customer> getAllCustomer() {
		return customerRecords;
	}
	
	
	
	/*Requirement:1 
	  Here we are retrieving all phone numbers from 
	  collection
	*/
	public HashMap<Long,String> getAllPhoneNubers(){
		HashMap<Long,String> phoneNumber=new HashMap<>();
		customerRecords.forEach(c1 -> {
			phoneNumber.putAll(c1.getContactNumber());
		});
		return phoneNumber;
	}

	
	/*Requirement:2 
	  Here we are retrieving phone numbers of specific person from 
	  collection
	*/
	public HashMap<Long, String> getNumberOfCustomer(Integer customerId) {
		HashMap<Long,String> phoneNumber=new HashMap<>();
		if(Objects.isNull(customerId))
			throw new Error("PLEASE ENTER CUSTOMER ID");
		
		customerRecords.forEach(c1 -> {
			if(c1.getCustomerId()==customerId)
			phoneNumber.putAll(c1.getContactNumber());
		});
		return phoneNumber;
	}
	
	
	/*Requirement:3
	  Here we are Activated phoneNumber which passes as argument 
	  collection
	*/
	public String activatePhoneNumber(Long contactNumber){
		HashMap<Long,String> phoneNumber=new HashMap<>();
		if(Objects.isNull(contactNumber))
			throw new Error("PLEASE ENTER CONTACT NUMBER");
		
		customerRecords.forEach(c1 ->{
			phoneNumber.putAll(c1.getContactNumber());
			c1.getContactNumber().computeIfPresent(contactNumber,(k,V)->V="Activated");
		});
		if(phoneNumber.containsKey(contactNumber))
			return "Record Updated";
		else
			return "Record Not Found";
	}
	
}
