package com.agile.customerapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.agile.customerapp.services.CreditService;

@RestController
public class CreditController {

	private CreditService creditService;
	
	public CreditController(CreditService creditService) {
		this.creditService = creditService;
	}
	
	@GetMapping("/api/credit/{id}")
	@ResponseBody
	public int getCredit(@PathVariable String id) {
		
		return creditService.getCreditScore(id);
	}
}
