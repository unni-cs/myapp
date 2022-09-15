package com.agile.customerapp.services;

import org.springframework.stereotype.Service;

@Service
public class EligibilityService {
	
	private VehicleService vehicleService;
	private CreditService creditService;
	
	public EligibilityService() {
		vehicleService = new VehicleService();
		creditService = new CreditService();
	}
	
	public boolean isEligible(String vehicleId, String customerId) {
		
		int minCreditScore = vehicleService.getMinCreditScore(vehicleId);
		
		if(minCreditScore == -1)
			return false;
		
		int customerCredit = creditService.getCreditScore(customerId);
		
		return customerCredit >= minCreditScore;		
	}
}
