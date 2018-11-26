package com.techelevator;

public class Candy extends Item{

	public Candy(double price, String itemName) {
		super(price, itemName);
	}
	
	@Override
	public void soundEffect() {
		System.out.print("Munch Munch, Yum!");
	}
	

}