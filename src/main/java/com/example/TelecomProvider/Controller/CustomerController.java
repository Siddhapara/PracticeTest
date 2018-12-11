package com.example.TelecomProvider.Controller;

import java.util.HashMap;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.TelecomProvider.Model.Customer;
import com.example.TelecomProvider.Service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService cService;
	
	@PostMapping("/addCustomer")
	public String addCustomer(@RequestBody Customer customer){
		return cService.addCustomerDetails(customer);
	}
	
	@GetMapping("/getAllCustomer")
	public HashSet<Customer> getAllCustomer(){
		return cService.getAllCustomer();
	}
	
	@GetMapping("/getAllPhoneNumber")
	public HashMap<Long,String> getAllPhoneNumber(){
		return cService.getAllPhoneNubers();
	}
	
	@PostMapping("/getPhoneNumberOfSingleCustomer")
	public HashMap<Long,String> getNumberOfCustomer(int customerId){
		return cService.getNumberOfCustomer(customerId);
	}
	
	@PostMapping("/activatePhoneNumber")
	public String activatePhoneNumber(Long phoneNumber) {
		return cService.activatePhoneNumber(phoneNumber);
	}
}
