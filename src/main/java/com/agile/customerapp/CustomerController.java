package com.agile.customerapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agile.customerapp.models.Customer;
import com.agile.customerapp.services.CustomerService;

@RestController
public class CustomerController {
	
	private CustomerService customerService;
	
	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping("/api/customers")
	public ResponseEntity<Iterable<Customer>> getCustomers() {
		
		Iterable<Customer> customers = customerService.getCustomers();
		
		return ResponseEntity.ok(customers);
	}
}
