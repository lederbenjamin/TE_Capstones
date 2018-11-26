package com.techelevator;
import java.util.*;


public class Inventory {
	
	public HashMap<String, Item> inventoryMap = new HashMap<String, Item>();
	

	public Inventory() {}
	
	public void addItem(String keyValue, Item itemObject) {
		inventoryMap.put(keyValue, itemObject);
	}
	
	public int getCurrentStockOfItem(String keyValue) {
		Item tempItem = inventoryMap.get(keyValue);
		int stock = tempItem.getItemQuantity();
		return stock;
	}
	
	public int getAmountSoldEachItem(String keyValue) {
		Item tempItem = inventoryMap.get(keyValue);
		int soldStock = tempItem.getItemsSold();
		return soldStock;
	}
	
	public double getPrice(String keyValue) {
		Item priceItem = inventoryMap.get(keyValue);
		double price = priceItem.getItemPrice();
		return price;
	}
	
	public String getName(String keyValue) {
		Item priceItem = inventoryMap.get(keyValue);
		String name = priceItem.getItemName();
		return name;
	}

	public String releaseItem(String keyValue) {
		Item tempItem = inventoryMap.get(keyValue);
		if(tempItem.getItemQuantity() > 0) {
			tempItem.minusQuantity1();
			inventoryMap.put(keyValue, tempItem);
		}
		String name = tempItem.getItemName();
		return name;
	}
	
	public Set<String> getKeys() {
		return inventoryMap.keySet();
	}

}
