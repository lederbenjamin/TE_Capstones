package com.techelevator;

public class Gum extends Item {

	public Gum(double price, String itemName) {
		super(price, itemName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void soundEffect() {
		System.out.print("Chew Chew, Yum!");
	}

}
//@Override the toString method. allows us to write out crunch crunch munch munch
	//