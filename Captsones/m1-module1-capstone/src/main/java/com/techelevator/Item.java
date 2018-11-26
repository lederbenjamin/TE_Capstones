package com.techelevator;

public abstract class Item {
	private double price;
	private String itemName;
	private int quantity;
	private int itemsSold = 0;
	

	
	public Item (double price, String itemName) {
		quantity = 5;
		this.price = price;
		this.itemName = itemName;
	}


	public double getItemPrice() {
		return price;
	}


	public int getItemQuantity() {
		return quantity;
	}
	
	public void minusQuantity1() {
		quantity--;
		itemsSold++;
	}


	public String getItemName() {
		return itemName;
	}


	public int getItemsSold() {
		return itemsSold;
	}
	
	public abstract void soundEffect();

}
