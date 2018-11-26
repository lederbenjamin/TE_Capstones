package com.techelevator;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.*;
import java.text.DecimalFormat;


public class VendingMachine {
	
	private double currentFunds;
	private double itemSales = 0;
	private Inventory inventory = new Inventory();
	List<Item> itemsSold = new ArrayList<Item>();
	
	public VendingMachine() {
		try {
			stock();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void displayItems () throws FileNotFoundException {
		String path = "/Users/bleder/Development/Pairs/team3-java-green-week4-pair-exercises/m1-module1-capstone";
		File file = new File(path, "vendingmachine.csv");
		Scanner myScanner = new Scanner(file);
		
		while(myScanner.hasNextLine()) {
			String line = myScanner.nextLine();
			String[] lineArray = line.split("\\|");
			
			System.out.println(String.format("%s %s %s", lineArray[0], lineArray[1], lineArray[2]));
		}
	}
		
	public void stock() throws FileNotFoundException {
		
		String path = "/Users/bleder/Development/Pairs/team3-java-green-week4-pair-exercises/m1-module1-capstone";
		File file = new File(path, "vendingmachine.csv");
		Scanner myScanner = new Scanner(file);
		
		while(myScanner.hasNextLine()) {
			Item item = null;
			String line = myScanner.nextLine();
			String[] lineArray = line.split("\\|");
			if(lineArray[0].contains("A")) {
				item = new Chip(Double.valueOf(lineArray[2]),lineArray[1]);
			inventory.addItem(lineArray[0], item);
				}
			else if(lineArray[0].contains("B")) {
				item = new Candy(Double.valueOf(lineArray[2]), lineArray[1]);
				inventory.addItem(lineArray[0], item);
			}
			else if(lineArray[0].contains("C")) {
				item = new Drink(Double.valueOf(lineArray[2]), lineArray[1]);
				inventory.addItem(lineArray[0], item);
			}
			else if(lineArray[0].contains("D")) {
				item = new Gum(Double.valueOf(lineArray[2]), lineArray[1]);
				inventory.addItem(lineArray[0], item);
			}
		}
	}

	public String releaseItem(String keyValue) {
		Item tempItem = inventory.inventoryMap.get(keyValue);
		if( tempItem.getItemQuantity() > 0) {
			currentFunds -= tempItem.getItemPrice();
			itemsSold.add(tempItem);
			return inventory.releaseItem(keyValue);
		}
		else
			return "OUT OF STOCK";

	}
	
	public double retrievePrice(String keyValue) {
		return inventory.getPrice(keyValue);
	}
	
	public List<Item> getItemsSold() {
		return itemsSold;
	}
	
	public void addFunds(double currentFunds) {
		this.currentFunds += currentFunds;
	}
	
	public double getCurrentFunds() {
		return currentFunds;
	}
	
	public void calculateItemSales(String keyValue) {
		double price = inventory.getPrice(keyValue);
		int itemsSold = inventory.getAmountSoldEachItem(keyValue);
		itemSales = price * itemsSold;
	}
	
	public double getItemSales() {
		return itemSales;
	}
	
	public boolean transactionApproval(String keyValue) {
		double price = inventory.getPrice(keyValue);
		if(currentFunds > price) {
			currentFunds -= price;
			return true;
		}
		else {
			
			return false;
		}
	}
		
	public Set<String> getKeys() {
		return inventory.getKeys();
	}
}


