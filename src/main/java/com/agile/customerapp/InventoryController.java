package com.agile.customerapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agile.customerapp.models.InventoryItem;
import com.agile.customerapp.services.InventoryService;

@RestController
public class InventoryController {
	
	private InventoryService inventoryService;
	
	@Autowired
	public InventoryController(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}

	@GetMapping("/api/inventory")
	public ResponseEntity<List<InventoryItem>> getInventory() {
		
		List<InventoryItem> inventoryItems = inventoryService.getItems();	
		
		return ResponseEntity.ok(inventoryItems);
	}	
}
