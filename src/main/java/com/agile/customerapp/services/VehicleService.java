package com.agile.customerapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.agile.customerapp.models.Vehicle;

@Service
public class VehicleService {

	private List<Vehicle> vehicles;
	private InventoryService inventoryService;
	
	public VehicleService() {
		vehicles = new ArrayList<>();
		inventoryService = new InventoryService();
		getAllVehicles();
	}
	
	private void getAllVehicles() {
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setVehicleId("vehicle-1");
        vehicle1.setDescription("Toyota Camry");
        vehicle1.setPrice("$22,000");
        vehicle1.setMinCreditScore(500);
        vehicle1.setInStockCount(inventoryService.getCount("vehicle-1"));

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setVehicleId("vehicle-2");
        vehicle2.setDescription("Honda Accord");
        vehicle2.setPrice("$25,000");
        vehicle2.setMinCreditScore(550);
        vehicle2.setInStockCount(inventoryService.getCount("vehicle-2"));

        Vehicle vehicle3 = new Vehicle();
        vehicle3.setVehicleId("vehicle-3");
        vehicle3.setDescription("Nissan Rogue");
        vehicle3.setPrice("$27,000");
        vehicle3.setMinCreditScore(700);
        vehicle3.setInStockCount(inventoryService.getCount("vehicle-83"));

        Vehicle vehicle4 = new Vehicle();
        vehicle4.setVehicleId("vehicle-4");
        vehicle4.setDescription("Tesla Model S");
        vehicle4.setPrice("$70,000");
        vehicle4.setMinCreditScore(775);
        vehicle4.setInStockCount(inventoryService.getCount("vehicle-4"));

        vehicles.add(vehicle1);
        vehicles.add(vehicle2);
        vehicles.add(vehicle3);
        vehicles.add(vehicle4);
    }
	
	public List<Vehicle> getVehicles(){
		return vehicles;
	}
	
	public int getMinCreditScore(String vehicleId) {
		for (Vehicle vehicle : vehicles) {
			if(vehicle.getVehicleId().equalsIgnoreCase(vehicleId))
				return vehicle.getMinCreditScore();
        }
		return -1;
	}
}
