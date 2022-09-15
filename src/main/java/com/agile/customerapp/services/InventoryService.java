package com.agile.customerapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.agile.customerapp.models.InventoryItem;

@Service
public class InventoryService {
	
	private List<InventoryItem> inventoryItems;
	
	public InventoryService() {
		inventoryItems = new ArrayList<>();
		setInventoryItems();
	}
	
	private void setInventoryItems() {
        InventoryItem inventoryItem = new InventoryItem();
        inventoryItem.setVehicleId("vehicle-1");
        inventoryItem.setInStockCount(17);

        InventoryItem inventoryItem2 = new InventoryItem();
        inventoryItem2.setVehicleId("vehicle-2");
        inventoryItem2.setInStockCount(39);

        InventoryItem inventoryItem3 = new InventoryItem();
        inventoryItem3.setVehicleId("vehicle-3");
        inventoryItem3.setInStockCount(0);

        InventoryItem inventoryItem4 = new InventoryItem();
        inventoryItem4.setVehicleId("vehicle-4");
        inventoryItem4.setInStockCount(8);

        inventoryItems.add(inventoryItem);
        inventoryItems.add(inventoryItem2);
        inventoryItems.add(inventoryItem3);
        inventoryItems.add(inventoryItem4);
    }
	
	public List<InventoryItem> getItems(){
		return inventoryItems;
	}
	
	public int getCount(String vehicle) {
		for (InventoryItem inventory : inventoryItems) {
            if (inventory.getVehicleId().equalsIgnoreCase(vehicle)) {
                return inventory.getInStockCount();
            }
        }
		
		return 0;
	}
	
	public boolean isAvailable(String vehicle) {
		return getCount(vehicle) > 0;
	}
}
