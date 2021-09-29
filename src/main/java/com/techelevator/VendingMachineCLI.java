package com.techelevator;

import com.techelevator.view.Menu;
import java.io.IOException;
import java.util.Date;

//import static jdk.tools.jaotc.LogPrinter.logFile;

/** VendingMachineCLI.java
 * 		This CLI (Command Line Interface):
 * 		1. Instantiates a menu object and a vending machine object calling that menu object.
 * 		2. Run method calls the menu, passes all options for to display and return a choice: menu.getChoiceFromOptions().
 * 		3. Menu returns user's choice and this vending machine then instantiates a class
 * 			and calls the respective methods within that new class:
 * 			Case 1: Inventory and displayInvetory()
 * 			Case 2: Purchase with its own instantiated menu object and then run the object
 * 			Case 3: Exits the program
 * 			Case 4: (Hidden) Calls SalesReport.java, which generates a report
 */
public class VendingMachineCLI {
	/** PROPERTIES */
	private static final String MENU_OPTION_DISPLAY_VM_ITEMS = "Display Vending Machine Items";
	private static final String MENU_OPTION_PURCHASE = "Purchase";
	private static final String MENU_OPTION_EXIT = "Exit";
	private static final String MENU_OPTION_SALES_REPORT = "";
	private static final String[] MENU_OPTIONS = { MENU_OPTION_DISPLAY_VM_ITEMS, MENU_OPTION_PURCHASE,
			MENU_OPTION_EXIT, MENU_OPTION_SALES_REPORT };
	private final Menu menu;
	private static final Date date = new Date();

	/** CONSTRUCTOR */
	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public static void main(String[] args) throws IOException {
		logLaunchComments(args);

		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}

	public void run() throws IOException {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MENU_OPTIONS);

			switch (choice) {
				case MENU_OPTION_DISPLAY_VM_ITEMS: // display vending machine items (call Inventory.java)
					Inventory inventory = new Inventory();
					inventory.displayInventory();
					break;
				case MENU_OPTION_PURCHASE: // do purchase (call Purchase.java)
					Purchase purchase = new Purchase(menu);
					purchase.run();
					break;
				case MENU_OPTION_EXIT:	// Exit the program
					System.out.println("Thank you for shopping the Vendo-Matic 800!");
					Purchase.logFile("Exiting program.");
					Purchase.logFile("Process ended normally.");
					System.exit(0);
				case MENU_OPTION_SALES_REPORT: // generate a sales report (call SalesReport.java)
					/** TODO: OPTIONAL SALES REPORT CODE
					 Provide a "Hidden" menu option on the main menu ("4") that writes to a sales report that shows
					 the total sales since the machine was started. The name of the file must include the date and
					 time so each sales report is uniquely named.
					 */
					SalesReport salesReport = new SalesReport(menu);
					salesReport.displayReport();

					System.exit(0);   // break;
			}
		}
	}

	/** METHODS */
	private static void logLaunchComments(String[] args) throws IOException {
		Purchase.logFile("*****************************************************");
		Purchase.logFile("******** New Launch Event: VendingMachineCLI ********");
		Purchase.logFile("*****************************************************");
	}

}

