package com.techelevator;

import com.techelevator.view.Menu;
import java.io.IOException;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String MAIN_MENU_OPTION_SALES_REPORT = "";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE,
														MAIN_MENU_OPTION_EXIT, MAIN_MENU_OPTION_SALES_REPORT };
	private final Menu menu;
//	private final String inputDataFile = "/capstone/vendingmachine.csv";

	/** CONSTRUCTOR */
	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public static void main(String[] args) throws IOException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}

	public void run() throws IOException {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			switch (choice) {
				case MAIN_MENU_OPTION_DISPLAY_ITEMS: // display vending machine items (call Inventory.java)
					Inventory inventory = new Inventory();
					inventory.displayInventory();
					break;
				case MAIN_MENU_OPTION_PURCHASE: // do purchase (call Purchase.java)
					Purchase purchase = new Purchase(menu);
					purchase.run();
					break;
				case MAIN_MENU_OPTION_EXIT:	// Exit the program
					System.exit(0);
				case (MAIN_MENU_OPTION_SALES_REPORT): // generate a sales report (call SalesReport.java)
					/** TODO: OPTIONAL SALES REPORT CODE
					 Provide a "Hidden" menu option on the main menu ("4") that writes to a sales report that shows
					 the total sales since the machine was started. The name of the file must include the date and
					 time so each sales report is uniquely named.
					 */
					SalesReport salesReport = new SalesReport(menu);
					System.out.println("(Optional) Choice #4 is hidden and reserved for a Sales Report");
					break;
			}
		}
	}

}
