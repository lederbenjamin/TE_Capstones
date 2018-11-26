package com.techelevator;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private DecimalFormat df = new DecimalFormat("0.00");
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";

	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };
	private static final String[] PURCHASING_MENU_OPTIONS = { "Feed Money", "Select Product", "Finish Transaction" };

	private Menu menu;
	private VendingMachine vendingmachine = new VendingMachine();

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() throws FileNotFoundException {

		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				vendingmachine.displayItems();
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
				purchaseFlow();
			}
		}
	}

	public void purchaseFlow() throws FileNotFoundException {
		String choice = "";
		while (!choice.equals("Finish Transaction")) {
			choice = (String) menu.getChoiceFromOptions(PURCHASING_MENU_OPTIONS);
			if (choice.equals("Feed Money")) {
				System.out.println("How much money do you insert?");
				//if ((menu.userProvidesFunds() == 1.00) || (menu.userProvidesFunds() == 2.00) || (menu.userProvidesFunds() == 5.00)
						//|| (menu.userProvidesFunds() == 10.00)) {
				vendingmachine.addFunds(menu.userProvidesFunds());
				System.out.println("Current Balance : $" + df.format(vendingmachine.getCurrentFunds()));
				//} else
					//System.out.println("Please enter a whole dollar amount...");
			} else if (choice.equals("Select Product")) { //Why does the number of if,else, system.out affect number of times input must be retyped???
				System.out.println("Please choose your product.");
				if (vendingmachine.getKeys().contains(menu.userSelectsProduct())) {
					if (vendingmachine.getCurrentFunds() >= vendingmachine.retrievePrice(menu.userSelectsProduct())) {
						System.out.println(vendingmachine.releaseItem(menu.userSelectsProduct()));
						System.out.println("Current Balance : $" + df.format(vendingmachine.getCurrentFunds()));
					} else
						System.out.println("\n INSUFFICIENT FUNDS");
				} else
					System.out.println("PLEASE SELECT AVAILABLE ITEM");

				} 
				else {
				System.out.println("$" + df.format(vendingmachine.getCurrentFunds()) + " in change provided.");
				for (Item item : vendingmachine.getItemsSold()) {
					System.out.println("\n" + item.getItemName() + " will now be dispensed.");
					item.soundEffect();
				}
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
