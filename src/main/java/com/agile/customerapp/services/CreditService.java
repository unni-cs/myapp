package com.agile.customerapp.services;

import org.springframework.stereotype.Service;

@Service
public class CreditService {
	
	public CreditService() {
		
	}

	public int getCreditScore(String customer) {
		
		int creditScore;
		switch (customer) {
        case "customer-1":
            creditScore = 500;
            break;
        case "customer-2":
            creditScore = 489;
            break;
        case "customer-3":
            creditScore = 843;
            break;
        case "customer-4":
            creditScore = 755;
            break;
        case "customer-5":
            creditScore = 687;
            break;
        case "customer-6":
            creditScore = 565;
            break;
        case "customer-7":
            creditScore = 682;
            break;
        default:
        	creditScore = 0;
        	break;
		}
		
		return creditScore;
	}
}
