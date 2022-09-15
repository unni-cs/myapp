package com.agile.customerapp;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agile.customerapp.models.CustomerProfile;

@RestController
public class AuthController {
	
	@GetMapping("/api/login")
	public ResponseEntity<CustomerProfile> profile() {
		
		CustomerProfile customerProfile = new CustomerProfile();		
		customerProfile.name = "Healthy";
		customerProfile.email = "myemail@email.com";
		
		return ResponseEntity.ok(customerProfile);
	}
}
