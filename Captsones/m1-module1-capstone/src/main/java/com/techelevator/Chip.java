package com.techelevator;

public class Chip extends Item {

	public Chip(double price, String itemName) {
		super(price, itemName);
		
	}
	
	@Override
	public void soundEffect() {
		System.out.print("Crunch Crunch, Yum!");
	}

	}
	
	//@Override the toString method. allows us to write out crunch crunch munch munch
	//
	


