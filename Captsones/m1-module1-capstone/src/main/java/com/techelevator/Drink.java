package com.techelevator;

public class Drink extends Item {

	public Drink(double price, String itemName) {
		super(price, itemName);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void soundEffect() {
		System.out.print("Glug Glug, Yum!");
	}

}
//@Override the toString method. allows us to write out crunch crunch munch munch
	//
