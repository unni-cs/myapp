package com.agile.customerapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.agile.customerapp.models.Checkout;
import com.agile.customerapp.models.CheckoutResponse;
import com.agile.customerapp.services.EligibilityService;
import com.agile.customerapp.services.InventoryService;

@RestController
public class CheckoutController {

private EligibilityService eligibilityService;
private InventoryService inventoryService;
	
	@Autowired
	public CheckoutController(EligibilityService eligibilityService, InventoryService inventoryService) {
		this.eligibilityService = eligibilityService;
		this.inventoryService = inventoryService;
	}
	
	@PostMapping("/api/checkout")
	@ResponseBody
	public ResponseEntity<CheckoutResponse> checkout(@RequestBody Checkout checkout) {
		
		CheckoutResponse response = new CheckoutResponse();
		response.customerId = checkout.customerId;
		response.vehicleId = checkout.vehicleId;
		
		boolean isAvailable = inventoryService.isAvailable(checkout.vehicleId);
		
		boolean isEligible = eligibilityService.isEligible(checkout.vehicleId,checkout.customerId);
		
		response.checkoutStatus = isAvailable && isEligible ? "Success" : "Failed" ;
		response.Message = getCheckoutFailureReason(isAvailable, isEligible);
		
		return ResponseEntity.ok(response);
	}
	
	private String getCheckoutFailureReason(boolean isAvailable, boolean isEligible) {
		
		if(!isAvailable && !isEligible) {
			return "Vehicle not available and Customer not eligible due to low credit!";
		}
		else if(!isAvailable) {
			return "Vehicle not available";
		}
		else if(!isEligible) {
			return "Customer not eligible due to low credit!";
		}
		else {
			return "Successful";
		}
	}
}
