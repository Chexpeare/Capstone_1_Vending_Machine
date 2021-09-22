package com.techelevator;

import com.techelevator.view.Menu;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String MAIN_MENU_HIDDEN_OPTION_SALES_REPORT = "";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS,
														MAIN_MENU_OPTION_PURCHASE,
														MAIN_MENU_OPTION_EXIT };
	private final Menu menu;
	private final String inputDataFile = "/capstone/vendingmachine.csv";

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() throws IOException {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				Inventory inventory = new Inventory();
				inventory.displayInventory();
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
				Purchase purchase = new Purchase(menu);
				purchase.run();
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				System.exit(0);
			} else if (choice.equals((MAIN_MENU_HIDDEN_OPTION_SALES_REPORT))) {
// TODO: SALES REPORT CODE
// Provide a "Hidden" menu option on the main menu ("4") that writes to a sales report that shows the total sales
// since the machine was started. The name of the file must include the date and time so each sales report is uniquely named.
				SalesReport salesReport = new SalesReport(menu);
				System.out.println("// TODO: Sales Report");
			}
		}
	}

	public static void main(String[] args) throws IOException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
