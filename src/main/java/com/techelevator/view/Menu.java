package com.techelevator.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Menu.java
 * Implements (InputStream input, OutputStream output): Java byte stream abstract classes that describe input/output.
 * Java defines two types of streams: byte and character.
 *
 * Byte streams:
 * 1. handle input and output of bytes.
 * 2. used when reading or writing binary data.
 *
 * Character streams provide a convenient means for handling input/output of characters.
 * They use Unicode and, therefore, can be internationalized.
 *
 * https://www.demo2s.com/java/java-outputstream-copy-inputstream-input-outputstream-output.html
 */

public class Menu {
	private final Scanner in;
	private final PrintWriter out;

	/** CONSTRUCTOR */
	// Instantiated by VendingMachineCLI main()
	public Menu(InputStream input, OutputStream output) {
		this.in = new Scanner(input);
		this.out = new PrintWriter(output);
	}

	/** METHODS */
	// Method 1: POE - This method is called by VendingMachineCLI which passes MAIN_MENU_OPTIONS and returns the
	// choice made by the user.
	public Object getChoiceFromOptions(Object[] options) {
		Object choice = null;
		while (choice == null) {
			displayMenuOptions(options);
			choice = getChoiceFromUserInput(options);
		}
		return choice;
	}

	// Method 2: called by getChoiceFromOptions() above
	// Creates list of options based on MAIN_MENU_OPTIONS in VendingMachineCLI
	private void displayMenuOptions(Object[] options) {
		out.println();
		int arrayLength = options.length;

		if (arrayLength <= 3) {		// Prints purchase menu options
			for (int i = 0; i < (options.length); i++) {
				int optionNum = i + 1;
				out.println("[" + optionNum + "] " + options[i]);
			}
		} else {
			for (int i = 0; i < (options.length - 1); i++) {	// Prints main menu options with hidden #4
				int optionNum = i + 1;
				out.println("[" + optionNum + "] " + options[i]);
			}
		}
		out.print(System.lineSeparator() + "Please make a selection: ");
		out.flush();
	}

	// Method 3: called by getChoiceFromOptions() once the user makes a choice
	private Object getChoiceFromUserInput(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.parseInt(userInput);
			// int selectedOption = Integer.valueOf(userInput);  <--- Original code
			if (selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch (NumberFormatException e) {
			// Display of error message is delegated to the following if statement
		}
		if (choice == null) {
			out.println(System.lineSeparator() + "*** " + userInput + " is not a valid option ***" + System.lineSeparator());
		}
		return choice;
	}
}

