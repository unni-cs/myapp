package com.agile.customerapp;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agile.customerapp.models.HealthStatus;

@RestController
public class HealthCheckController {

	@GetMapping("/api/healthcheck")
	public ResponseEntity<HealthStatus> healthCheck() {
		
		HealthStatus healthStatus = new HealthStatus();		
		healthStatus.Status = "Healthy";
		healthStatus.Version = "1.0";
		
		return ResponseEntity.ok(healthStatus);
	}
}
