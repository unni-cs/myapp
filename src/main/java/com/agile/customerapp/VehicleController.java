package com.agile.customerapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agile.customerapp.models.Vehicle;
import com.agile.customerapp.services.VehicleService;

@RestController
public class VehicleController {
	private VehicleService vehicleService;
	
	@Autowired
	public VehicleController(VehicleService vehicleService) {
		this.vehicleService = vehicleService;
	}
	
	@GetMapping("/api/vehicles")
	public ResponseEntity<List<Vehicle>> getVehicles() {
		
		List<Vehicle> vehicles = vehicleService.getVehicles();	
		
		return ResponseEntity.ok(vehicles);
	}
	
	
	
}
