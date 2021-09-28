package com.techelevator;

import java.io.*;
import com.techelevator.view.Menu;
import java.util.Scanner;
import java.util.Date;

/** Purchase.java - Pushed from Backup */
public class Purchase {
    private static final String MAIN_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String MAIN_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String MAIN_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
    private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_FEED_MONEY,
            MAIN_MENU_OPTION_SELECT_PRODUCT ,
            MAIN_MENU_OPTION_FINISH_TRANSACTION};
    private static final String logFilePath = "capstone/log.txt";
    private static final Date date = new Date();
    private static double totalSales = 0.0;
    private static double itemPrice = 0.0;
    private static int chipsCounter = 0;
    private static int candyCounter = 0;
    private static int drinksCounter = 0;
    private static int gumCounter = 0;
    private final Menu menu;
    private String itemSelected;
    private String itemType;
    private String itemKey;
    //    private String lowKey;
    private float balance;
    private double change;
    private int nickels;
    private int dimes;
    private int quarters;

    protected double deposit;
    protected int itemsRemaining;
    protected String soldOutString = " SOLD OUT.\nPlease select another product or press [3] to finish your transaction.";
    protected String addFundsString = "Please add additional funds or press [3] to finish your transaction.";

    /** CONSTRUCTOR */
    public Purchase (Menu menu) {
        this.balance =0;
        this.change = 0;
        this.menu = menu;
    }

    public void run () throws IOException {
        while (true) {
            System.out.printf('\n' + "Current Balance: $" + "%.2f", getCurrentBalance());
//            System.out.println("\n");
            String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

            switch (choice) {
                case MAIN_MENU_OPTION_FEED_MONEY:
                    feedMoney();
                    break;
                case MAIN_MENU_OPTION_SELECT_PRODUCT:
                    selectProduct(new Inventory());
                    break;
                case MAIN_MENU_OPTION_FINISH_TRANSACTION:
                    finishTransaction();
                    return;
            }
        }
    }

    /** feedMoney() */
    public void feedMoney() throws IOException {
        Scanner userInput = new Scanner(System.in);
        System.out.print("How much money would you like to deposit: ");
        deposit = userInput.nextDouble();
//        System.out.println("Current Money Provided: $" + deposit);

        if (deposit > 0) {
            balance += deposit;
            logFile("$"+ deposit + "  " + "$" + balance);
        } else {
            System.out.println("\nInvalid Deposit");
            logFile("INVALID DEPOSIT");
        }
    }

    /** START: selectProduct() */
    public void selectProduct(Inventory inventory) throws IOException {
        inventory.getInventory();

        Scanner userInput = new Scanner(System.in);
        System.out.print("Item to purchase (Enter product key): ");
        itemKey = userInput.nextLine();
//        lowKey = itemKey.toLowerCase();

        if (!(itemKey.equals("A1") || itemKey.equals("A2") ||itemKey.equals("A3") ||itemKey.equals("A4")
                ||itemKey.equals("B1") ||itemKey.equals("B2") ||itemKey.equals("B3") ||itemKey.equals("B4")
                ||itemKey.equals("C1") ||itemKey.equals("C2") ||itemKey.equals("C3") ||itemKey.equals("C4")
                ||itemKey.equals("D1") ||itemKey.equals("D2") ||itemKey.equals("D3") ||itemKey.equals("D4"))) {
            System.out.println("Invalid Key, Try again");
            itemKey =null;
            itemSelected = null;
            itemType = null;
            return;
        }

        itemSelected = inventory.getItemSelectedMap().get(itemKey);
        itemType = inventory.getItemTypeMap().get(itemKey);

        switch (itemType) {
            // Start of Chips
            case "Chip":
                Chips chips = new Chips();
                switch (itemSelected) {
                    case "Potato Crisps": // A1
                        if ( (balance >= chips.getPotatoCrispsPrice()) && (chips.getPotatoCrispsLeft() > 0) ) {
                            chipsCounter++;
                            itemPrice = chips.getPotatoCrispsPrice();
                            logFile(itemKey + "|" + itemSelected + "|" + "Current Balance: " + "$"+ balance  + "|"
                                    + "New Balance: $" + (balance - itemPrice));
                            balance -= itemPrice;
                            totalSales += itemPrice;
                            itemsRemaining = chips.completeChipsPurchase(itemSelected);
                            itemsRemainingFormat();
                        } else if ( (balance < itemPrice) && (chips.getPotatoCrispsLeft() > 0) ) {
                            addFundsFormat();
                        } else if ( (balance >= itemPrice) && (chips.getPotatoCrispsLeft() == 0) ) {
                            soldOutFormat();
                        }
                        break;
                    case "Grain Waves":
                        if ( (balance >= chips.getGrainWavesPrice()) && (chips.getGrainWavesLeft() > 0) ) {
                            chipsCounter++;
                            itemPrice = chips.getGrainWavesPrice();
                            logFile(itemKey + "|" + itemSelected + "|" + "Current Balance: " + "$"+ balance  + "|"
                                    + "New Balance: $" + (balance - itemPrice));
                            balance -= itemPrice;
                            totalSales += itemPrice;
                            itemsRemaining = chips.completeChipsPurchase(itemSelected);
                            itemsRemainingFormat();
                        } else if ( (balance < itemPrice) && (chips.getGrainWavesLeft() > 0) ) {
                            addFundsFormat();
                        } else if ( (balance >= itemPrice) && (chips.getGrainWavesLeft() == 0) ) {
                            soldOutFormat();
                        }
                        break;
                    case "Stackers":
                        if ( (balance >= chips.getStackersPrice()) && (chips.getStackersLeft() > 0) ) {
                            chipsCounter++;
                            itemPrice = chips.getStackersPrice();
                            logFile(itemKey + "|" + itemSelected + "|" + "Current Balance: " + "$"+ balance  + "|"
                                    + "New Balance: $" + (balance - itemPrice));
                            balance -= itemPrice;
                            totalSales += itemPrice;
                            itemsRemaining = chips.completeChipsPurchase(itemSelected);
                            itemsRemainingFormat();
                        } else if ( (balance < itemPrice) && (chips.getStackersLeft() > 0) ) {
                            addFundsFormat();
                        } else if ( (balance >= itemPrice) && (chips.getStackersLeft() == 0) ) {
                            soldOutFormat();
                        }
                        break;
                    case "Cloud Popcorn":
                        if ( (balance >= chips.getCloudPopcornPrice()) && (chips.getCloudPopcornLeft() > 0) ) {
                            chipsCounter++;
                            itemPrice = chips.getCloudPopcornPrice();
                            logFile(itemKey + "|" + itemSelected + "|" + "Current Balance: " + "$"+ balance  + "|"
                                    + "New Balance: $" + (balance - itemPrice));
                            balance -= itemPrice;
                            totalSales += itemPrice;
                            itemsRemaining = chips.completeChipsPurchase(itemSelected);
                            itemsRemainingFormat();
                        } else if ( (balance < itemPrice) && (chips.getCloudPopcornLeft() > 0) ) {
                            addFundsFormat();
                        } else if ( (balance >= itemPrice) && (chips.getCloudPopcornLeft() == 0) ) {
                            soldOutFormat();
                        }
                        break;
                }
                break;

            // Start of Candy
            case "Candy":
                Candy candy = new Candy();
                switch (itemSelected) {
                    case "Moonpie":
                        if ( (balance >= candy.getMoonPiePrice()) && (candy.getMoonpiesLeft() > 0) ) {
                            candyCounter++;
                            itemPrice = candy.getMoonPiePrice();
                            logFile(itemKey + "|" + itemSelected + "|" + "Current Balance: " + "$"+ balance  + "|"
                                    + "New Balance: $" + (balance - itemPrice));
                            balance -= itemPrice;
                            totalSales += itemPrice;
                            itemsRemaining = candy.completeCandyPurchase(itemSelected);
                            itemsRemainingFormat();
                        } else if ( (balance < itemPrice) && (candy.getMoonpiesLeft() > 0) ) {
                            addFundsFormat();
                        } else if ( (balance >= itemPrice) && (candy.getMoonpiesLeft() == 0) ) {
                            soldOutFormat();
                        }
                        break;
                    case "Cowtales":
                        if ( (balance >= candy.getCowtalesPrice()) && (candy.getCowtalesLeft() > 0) ) {
                            candyCounter++;
                            itemPrice = candy.getCowtalesPrice();
                            logFile(itemKey + "|" + itemSelected + "|" + "Current Balance: " + "$"+ balance  + "|"
                                    + "New Balance: $" + (balance - itemPrice));
                            balance -= itemPrice;
                            totalSales += itemPrice;
                            itemsRemaining = candy.completeCandyPurchase(itemSelected);
                            itemsRemainingFormat();
                        } else if ( (balance < itemPrice) && (candy.getCowtalesLeft() > 0) ) {
                            addFundsFormat();
                        } else if ( (balance >= itemPrice) && (candy.getCowtalesLeft() == 0) ) {
                            soldOutFormat();
                        }
                        break;
                    case "Crunchie":
                        if ( (balance >= candy.getCrunchiesPrice()) && (candy.getCrunchiesLeft() > 0) ) {
                            candyCounter++;
                            itemPrice = candy.getCrunchiesPrice();
                            logFile(itemKey + "|" + itemSelected + "|" + "Current Balance: " + "$"+ balance  + "|"
                                    + "New Balance: $" + (balance - itemPrice));
                            balance -= itemPrice;
                            totalSales += itemPrice;
                            itemsRemaining = candy.completeCandyPurchase(itemSelected);
                            itemsRemainingFormat();
                        } else if ( (balance < itemPrice) && (candy.getCrunchiesLeft() > 0) ) {
                            addFundsFormat();
                        } else if ( (balance >= itemPrice) && (candy.getCrunchiesLeft() == 0) ) {
                            soldOutFormat();
                        }
                        break;
                    case "Wonka Bar":
                        if ( (balance >= candy.getWonkaBarsPrice()) && (candy.getWonkaBarsLeft() > 0) ) {
                            candyCounter++;
                            itemPrice = candy.getWonkaBarsPrice();
                            logFile(itemKey + "|" + itemSelected + "|" + "Current Balance: " + "$"+ balance  + "|"
                                    + "New Balance: $" + (balance - itemPrice));
                            balance -= itemPrice;
                            totalSales += itemPrice;
                            itemsRemaining = candy.completeCandyPurchase(itemSelected);
                            itemsRemainingFormat();
                        } else if ( (balance < itemPrice) && (candy.getWonkaBarsLeft() > 0) ) {
                            addFundsFormat();
                        } else if ( (balance >= itemPrice) && (candy.getWonkaBarsLeft() == 0) ) {
                            soldOutFormat();
                        }
                        break;
                }
                break;

            //Start of Drinks
            case "Drink":
                Drinks drinks = new Drinks();
                switch (itemSelected) {
                    case "Cola":
                        if ( (balance >= drinks.getColaPrice()) && (drinks.getColaLeft() > 0) ) {
                            drinksCounter++;
                            itemPrice = drinks.getColaPrice();
                            logFile(itemKey + "|" + itemSelected + "|" + "Current Balance: " + "$"+ balance  + "|"
                                    + "New Balance: $" + (balance - itemPrice));
                            balance -= itemPrice;
                            totalSales += itemPrice;
                            itemsRemaining = drinks.completeDrinksPurchase(itemSelected);
                            itemsRemainingFormat();
                        } else if ( (balance < itemPrice) && (drinks.getColaLeft() > 0) ) {
                            addFundsFormat();
                        } else if ( (balance >= itemPrice) && (drinks.getColaLeft() == 0) ) {
                            soldOutFormat();
                        }
                        break;
                    case "Dr. Salt":
                        if ( (balance >= drinks.getDrSaltPrice()) && (drinks.getDrSaltLeft() > 0) ) {
                            drinksCounter++;
                            itemPrice = drinks.getDrSaltPrice();
                            logFile(itemKey + "|" + itemSelected + "|" + "Current Balance: " + "$"+ balance  + "|"
                                    + "New Balance: $" + (balance - itemPrice));
                            balance -= itemPrice;
                            totalSales += itemPrice;
                            itemsRemaining = drinks.completeDrinksPurchase(itemSelected);
                            itemsRemainingFormat();
                        } else if ( (balance < itemPrice) && (drinks.getDrSaltLeft() > 0) ) {
                            addFundsFormat();
                        } else if ( (balance >= itemPrice) && (drinks.getDrSaltLeft() == 0) ) {
                            soldOutFormat();
                        }
                        break;
                    case "Mountain Melter":
                        if ( (balance >= drinks.getMountainMelterPrice()) && (drinks.getMountainMelterLeft() > 0) ) {
                            drinksCounter++;
                            itemPrice = drinks.getMountainMelterPrice();
                            logFile(itemKey + "|" + itemSelected + "|" + "Current Balance: " + "$"+ balance  + "|"
                                    + "New Balance: $" + (balance - itemPrice));
                            balance -= itemPrice;
                            totalSales += itemPrice;
                            itemsRemaining = drinks.completeDrinksPurchase(itemSelected);
                            itemsRemainingFormat();
                        } else if ( (balance < itemPrice) && (drinks.getMountainMelterLeft() > 0) ) {
                            addFundsFormat();
                        } else if ( (balance >= itemPrice) && (drinks.getMountainMelterLeft() == 0) ) {
                            soldOutFormat();
                        }
                        break;
                    case "Heavy":
                        if ( (balance >= drinks.getHeavyPrice()) && (drinks.getHeavyLeft() > 0) ) {
                            drinksCounter++;
                            itemPrice = drinks.getHeavyPrice();
                            logFile(itemKey + "|" + itemSelected + "|" + "Current Balance: " + "$"+ balance  + "|"
                                    + "New Balance: $" + (balance - itemPrice));
                            balance -= itemPrice;
                            totalSales += itemPrice;
                            itemsRemaining = drinks.completeDrinksPurchase(itemSelected);
                            itemsRemainingFormat();
                        } else if ( (balance < itemPrice) && (drinks.getHeavyLeft() > 0) ) {
                            addFundsFormat();
                        } else if ( (balance >= itemPrice) && (drinks.getHeavyLeft() == 0) ) {
                            soldOutFormat();
                        }
                        break;
                }
                break;

            // Start of Gum
            case "Gum":
                Gum gum = new Gum();
                switch (itemSelected) {
                    case "U-Chews":
                        if ( (balance >= gum.getUChewsPrice()) && (gum.getuChewsLeft() > 0) ) {
                            gumCounter++;
                            itemPrice = gum.getUChewsPrice();
                            logFile(itemKey + "|" + itemSelected + "|" + "Current Balance: " + "$"+ balance  + "|"
                                    + "New Balance: $" + (balance - itemPrice));
                            balance -= itemPrice;
                            totalSales += itemPrice;
                            itemsRemaining = gum.completeGumPurchase(itemSelected);
                            itemsRemainingFormat();
                        } else if ( (balance < itemPrice) && (gum.getuChewsLeft() > 0) ) {
                            addFundsFormat();
                        } else if ( (balance >= itemPrice) && (gum.getuChewsLeft() == 0) ) {
                            soldOutFormat();
                        }
                        break;
                    case "Little League Chew":
                        if ( (balance >= gum.getLittleLeaugeChewPrice()) && (gum.getLittleLeaugeChewLeft() > 0) ) {
                            gumCounter++;
                            itemPrice = gum.getLittleLeaugeChewPrice();
                            logFile(itemKey + "|" + itemSelected + "|" + "Current Balance: " + "$"+ balance  + "|"
                                    + "New Balance: $" + (balance - itemPrice));
                            balance -= itemPrice;
                            totalSales += itemPrice;
                            itemsRemaining = gum.completeGumPurchase(itemSelected);
                            itemsRemainingFormat();
                        } else if ( (balance < itemPrice) && (gum.getLittleLeaugeChewLeft() > 0) ) {
                            addFundsFormat();
                        } else if ( (balance >= itemPrice) && (gum.getLittleLeaugeChewLeft() == 0) ) {
                            soldOutFormat();
                        }
                        break;
                    case "Chiclets":
                        if ( (balance >= gum.getChicletsPrice()) && (gum.getChicletsLeft() > 0) ) {
                            gumCounter++;
                            itemPrice = gum.getChicletsPrice();
                            logFile(itemKey + "|" + itemSelected + "|" + "Current Balance: " + "$"+ balance  + "|"
                                    + "New Balance: $" + (balance - itemPrice));
                            balance -= itemPrice;
                            totalSales += itemPrice;
                            itemsRemaining = gum.completeGumPurchase(itemSelected);
                            itemsRemainingFormat();
                        } else if ( (balance < itemPrice) && (gum.getChicletsLeft() > 0) ) {
                            addFundsFormat();
                        } else if ( (balance >= itemPrice) && (gum.getChicletsLeft() == 0) ) {
                            soldOutFormat();
                        }
                        break;
                    case "Triplemint":
                        if ( (balance >= gum.getTriplemintPrice()) && (gum.getTriplemintLeft() > 0) ) {
                            gumCounter++;
                            itemPrice = gum.getTriplemintPrice();
                            logFile(itemKey + "|" + itemSelected + "|" + "Current Balance: " + "$"+ balance  + "|"
                                    + "New Balance: $" + (balance - itemPrice));
                            balance -= itemPrice;
                            totalSales += itemPrice;
                            itemsRemaining = gum.completeGumPurchase(itemSelected);
                            itemsRemainingFormat();
                        } else if ( (balance < itemPrice) && (gum.getTriplemintLeft() > 0) ) {
                            addFundsFormat();
                        } else if ( (balance >= itemPrice) && (gum.getTriplemintLeft() == 0) ) {
                            soldOutFormat();
                        }
                        break;
                }
                break;
        }
    }
    /** END: selectProduct() */

    public void finishTransaction() throws IOException {
        nickels =0;
        dimes = 0;
        quarters = 0;
        double totalChange =0;
        double quarterRemainder;
        double dimesRemainder;
        logFile("Change given: $" + balance);

        if (balance > 0) {
            totalChange = balance;
            change = balance;
            balance =0;
        }

        totalChange = Math.ceil(totalChange * 100);
        quarterRemainder = totalChange%25;
        quarters = (int)(totalChange/25);
        dimesRemainder = quarterRemainder%10;
        dimes = (int)(quarterRemainder/10);
        nickels = (int)(dimesRemainder/5);
        totalChange /= 100;

        System.out.println("\nTransaction Completed" + '\n');
        System.out.printf("Your change is " + "$%.2f" + '\n' , totalChange);
        System.out.println("Quarters: " + quarters + "   " + "Dimes "+dimes+"   " +"Nickels " + nickels);

        for (int i = 0; i < candyCounter; i++) {
            System.out.println("Munch Munch, Yum!");
        }
        for (int i = 0; i < chipsCounter; i++) {
            System.out.println("Crunch Crunch, Yum!");
        }
        for (int i = 0; i < gumCounter; i++) {
            System.out.println("Chew Chew, Yum!");
        }
        for (int i = 0; i < drinksCounter; i++) {
            System.out.println("Glug Glug, Yum!");
        }
        candyCounter = 0;
        drinksCounter = 0;
        gumCounter = 0;
        chipsCounter = 0;
    }

    /** METHODS: logFile() WRITE TO log.txt
     * uses getCanonicalPath();
     */
    protected static void logFile(String message) throws IOException {
        File outputFile = new File(logFilePath);
        String canonical = outputFile.getCanonicalPath();

        try ( PrintWriter logWriter = new PrintWriter(new FileWriter(String.valueOf(canonical), true)) ) {
            logWriter.println(date + " " + message);
        } catch (IOException e) {
            System.out.println("Unable to write to file.");
        }
    }

    /** GETTERS */
    public double getCurrentBalance() {
        return balance;
    }
    public double getTotalSales() {
        return totalSales;
    }
    public double getChange() {
        return change;
    }
    public String getItemKey() {
        return itemKey;
    }
    public String getItemType() {
        return itemType;
    }
    public String getItemSelected() {
        return itemSelected;
    }
    public int getNickels() {
        return nickels;
    }
    public int getDimes() {
        return dimes;
    }
    public int getQuarters() {
        return quarters;
    }
    public void itemsRemainingFormat() {
        System.out.println(lineOfEquals());
        System.out.println(itemSelected + " remaining: " + itemsRemaining);
        System.out.println(lineOfEquals());
    }
    public void soldOutFormat() {
        System.out.println(lineOfEquals());
        System.out.println(itemSelected + soldOutString);
        System.out.println(lineOfEquals());
    }
    public void addFundsFormat() {
        System.out.println(lineOfEquals());
        System.out.println(addFundsString);
        System.out.println(lineOfEquals());
    }
    public String lineOfEquals() {
        return "======================================================================";
    }

}
