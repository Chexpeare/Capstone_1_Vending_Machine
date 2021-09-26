package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import com.techelevator.view.Menu;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Date;

/** Purchase.java - Pushed from Backup */
public class Purchase {
    private static final String MAIN_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String MAIN_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String MAIN_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
    private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_FEED_MONEY,
                                                        MAIN_MENU_OPTION_SELECT_PRODUCT ,
                                                        MAIN_MENU_OPTION_FINISH_TRANSACTION};
    private float balance;
    private double change;
    private static double totalSales = 0.0;
    private static int chipsCounter = 0;
    private static int candyCounter = 0;
    private static int drinksCounter = 0;
    private static int gumCounter = 0;
    private final Menu menu;
    private String itemSelected;
    private String itemType;
    private String itemKey;
//    private String lowKey;
    private int nickels;
    private int dimes;
    private int quarters;
    private static final File logFile = new File("/Users/chexpeare/MeritAmerica/PairProgrammingBackup/capstone/log.txt");
    private static final Date date = new Date();

    protected double deposit;
    protected int chipsRemaining;
    protected int candyRemaining;
    protected int drinkRemaining;
    protected int gumRemaining;

    public Purchase (Menu menu) {
        this.balance =0;
        this.change = 0;
        this.menu = menu;
    }

    public void run () throws IOException {
        while (true) {
            System.out.printf('\n' + "Current Money Provided: $" + "%.2f", getCurrentBalance());
            System.out.println("\n");
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
                    case "Potato Crisps":
                        if (balance >= chips.getPotatoCrispsPrice() && (chips.getPotatoCrispsLeft() > 0)) {
                            chipsCounter++;
                            logFile(itemSelected + " " + itemKey + " $" + balance + " $" + (balance - chips.getPotatoCrispsPrice()));
                            balance -= chips.getPotatoCrispsPrice();
                            totalSales += chips.getPotatoCrispsPrice();
                            chipsRemaining = chips.completeChipsPurchase(itemSelected);
                            System.out.println("\nPotato Crisps remaining: " + chipsRemaining);

                        } else {
                            System.out.println("Not enough funds or item is sold out, add more or choose another item");
                        }
                        break;
                    case "Grain Waves":
                        if (balance >= chips.getGrainWavesPrice() && (chips.getGrainWavesLeft() > 0)) {
                            chipsCounter++;
                            logFile(itemSelected + " " + itemKey + " $" + balance + " $" + (balance - chips.getGrainWavesPrice()));
                            balance -= chips.getGrainWavesPrice();
                            totalSales += chips.getGrainWavesPrice();
                            chipsRemaining = chips.completeChipsPurchase(itemSelected);
                            System.out.println("\nGrain Waves remaining: " + chipsRemaining);
                        } else {
                            System.out.println("Not enough funds or item is sold out, add more or choose another item");
                        }
                        break;
                    case "Stackers":
                        if (balance >= chips.getStackersPrice() && (chips.getStackersLeft() > 0)) {
                            chipsCounter++;
                            logFile(itemSelected + " " + itemKey + " $" + balance + " $" + (balance - chips.getStackersPrice()));
                            balance -= chips.getStackersPrice();
                            totalSales += chips.getStackersPrice();
                            chipsRemaining = chips.completeChipsPurchase(itemSelected);
                            System.out.println("\nStackers remaining: " + chipsRemaining);
                        } else {
                            System.out.println("Not enough funds or item is sold out, add more or choose another item");
                        }
                        break;
                    case "Cloud Popcorn":
                        if (balance >= chips.getCloudPopcornPrice() && (chips.getCloudPopcornLeft() > 0)) {
                            chipsCounter++;
                            logFile(itemSelected + " " + itemKey + " $" + balance + " $" + (balance - chips.getCloudPopcornPrice()));
                            balance -= chips.getCloudPopcornPrice();
                            totalSales += chips.getCloudPopcornPrice();
                            chipsRemaining = chips.completeChipsPurchase(itemSelected);
                            System.out.println("\nCloud Popcorn remaining: " + chipsRemaining);
                        } else {
                            System.out.println("Not enough funds or item is sold out, add more or choose another item");
                        }
                        break;
                }
                break;

            // Start of Candy
            case "Candy":
                Candy candy = new Candy();
                switch (itemSelected) {
                    case "Moonpie":
                        if (balance >= candy.getMoonPiePrice() && candy.getMoonpiesLeft() > 0) {
                            candyCounter++;
                            logFile(itemSelected + " " + itemKey + " $" + balance + " $" + (balance - candy.getMoonPiePrice()));
                            balance -= candy.getMoonPiePrice();
                            totalSales += candy.getMoonPiePrice();
                            candyRemaining = candy.completeCandyPurchase(itemSelected);
                            System.out.println("\nMoonpie: " + candyRemaining);
                        } else {
                            System.out.println("Not enough funds or item is sold out, add more or choose another item");
                        }
                        break;
                    case "Cowtales":
                        if (balance >= candy.getCowtalesPrice() && (candy.getCowtalesLeft() > 0)) {
                            candyCounter++;
                            logFile(itemSelected + " " + itemKey + " $" + balance + " $" + (balance - candy.getCowtalesPrice()));
                            balance -= candy.getCowtalesPrice();
                            totalSales += candy.getCowtalesPrice();
                            candyRemaining = candy.completeCandyPurchase(itemSelected);
                            System.out.println("\nCowtales remaining: " + candyRemaining);
                        } else {
                            System.out.println("Not enough funds or item is sold out, add more or choose another item");
                        }
                        break;
                    case "Crunchie":
                        if (balance >= candy.getCrunchiesPrice() && (candy.getCrunchiesLeft() > 0)) {
                            candyCounter++;
                            logFile(itemSelected + " " + itemKey + " $" + balance + " $" + (balance - candy.getCrunchiesPrice()));
                            balance -= candy.getCrunchiesPrice();
                            totalSales += candy.getCrunchiesPrice();
                            candyRemaining = candy.completeCandyPurchase(itemSelected);
                            System.out.println("\nCrunchies remaining: " + candyRemaining);
                        } else {
                            System.out.println("Not enough funds or item is sold out, add more or choose another item");
                        }
                        break;
                    case "Wonka Bar":
                        if (balance >= candy.getWonkaBarsPrice() && (candy.getWonkaBarsLeft() > 0)) {
                            candyCounter++;
                            logFile(itemSelected + " " + itemKey + " $" + balance + " $" + (balance - candy.getWonkaBarsPrice()));
                            balance -= candy.getWonkaBarsPrice();
                            totalSales += candy.getWonkaBarsPrice();
                            candyRemaining = candy.completeCandyPurchase(itemSelected);
                            System.out.println("\nWonka Bar: " + candyRemaining);
                        } else {
                            System.out.println("Not enough funds or item is sold out, add more or choose another item");
                        }
                        break;
                }
                break;

            //Start of Drinks
            case "Drink":
                Drinks drinks = new Drinks();
                switch (itemSelected) {
                    case "Cola":
                        if (balance >= drinks.getColaPrice() && (drinks.getColaLeft() > 0)) {
                            drinksCounter++;
                            logFile(itemSelected + " " + itemKey + " $" + balance + " $" + (balance - drinks.getColaPrice()));
                            balance -= drinks.getColaPrice();
                            totalSales += drinks.getColaPrice();
                            drinkRemaining = drinks.completeDrinksPurchase(itemSelected);
                            System.out.println("\nCola: " + drinkRemaining);
                        } else {
                            System.out.println("Not enough funds or item is sold out, add more or choose another item");
                        }
                        break;
                    case "Dr. Salt":
                        if (balance >= drinks.getDrSaltPrice() && (drinks.getDrSaltLeft() > 0)) {
                            drinksCounter++;
                            logFile(itemSelected + " " + itemKey + " $" + balance + " $" + (balance - drinks.getDrSaltPrice()));
                            balance -= drinks.getDrSaltPrice();
                            totalSales += drinks.getDrSaltPrice();
                            drinkRemaining = drinks.completeDrinksPurchase(itemSelected);
                            System.out.println("\nDr. Salt: " + drinkRemaining);
                        } else {
                            System.out.println("Not enough funds or item is sold out, add more or choose another item");
                        }
                        break;
                    case "Mountain Melter":
                        if (balance >= drinks.getMountainMelterPrice() && (drinks.getMountainMelterLeft() > 0)) {
                            drinksCounter++;
                            logFile(itemSelected + " " + itemKey + " $" + balance + " $" + (balance - drinks.getMountainMelterPrice()));
                            balance -= drinks.getMountainMelterPrice();
                            totalSales += drinks.getMountainMelterPrice();
                            drinkRemaining = drinks.completeDrinksPurchase(itemSelected);
                            System.out.println("\nMountain Melter: " + drinkRemaining);
                        } else {
                            System.out.println("Not enough funds or item is sold out, add more or choose another item");
                        }
                        break;
                    case "Heavy":
                        if (balance >= drinks.getHeavyPrice() && (drinks.getHeavyLeft() > 0)) {
                            drinksCounter++;
                            logFile(itemSelected + " " + itemKey + " $" + balance + " $" + (balance - drinks.getHeavyPrice()));
                            balance -= drinks.getHeavyPrice();
                            totalSales += drinks.getHeavyPrice();
                            drinkRemaining = drinks.completeDrinksPurchase(itemSelected);
                            System.out.println("\nHeavy: " + drinkRemaining);
                        } else {
                            System.out.println("Not enough funds item is sold out, add more or choose another item");
                        }
                        break;
                }
                break;

            // Start of Gum
            case "Gum":
                Gum gum = new Gum();
                switch (itemSelected) {
                    case "U-Chews":
                        if (balance >= gum.getUChewsPrice() && (gum.getuChewsLeft() > 0)) {
                            gumCounter++;
                            logFile(itemSelected + " " + itemKey + " $" + balance + " $" + (balance - gum.getUChewsPrice()));
                            balance -= gum.getUChewsPrice();
                            totalSales += gum.getUChewsPrice();
                            gumRemaining = gum.completeGumPurchase(itemSelected);
                            System.out.println("\nU-Chews: " + gumRemaining);
                        } else {
                            System.out.println("Not enough funds or item is sold out, add more or choose another item");
                        }
                        break;
                    case "Little League Chew":
                        if (balance >= gum.getLittleLeaugeChewPrice() && (gum.getLittleLeaugeChewLeft() > 0)) {
                            gumCounter++;
                            logFile(itemSelected + " " + itemKey + " $" + balance + " $" + (balance - gum.getLittleLeaugeChewPrice()));
                            balance -= gum.getLittleLeaugeChewPrice();
                            totalSales += gum.getLittleLeaugeChewPrice();
                            gumRemaining = gum.completeGumPurchase(itemSelected);
                            System.out.println("\nLittle League Chew: " + gumRemaining);
                        } else {
                            System.out.println("Not enough funds or item is sold out, add more or choose another item");
                        }
                        break;
                    case "Chiclets":
                        if (balance >= gum.getChicletsPrice() && (gum.getChicletsLeft() > 0)) {
                            gumCounter++;
                            logFile(itemSelected + " " + itemKey + " $" + balance + " $" + (balance - gum.getChicletsPrice()));
                            balance -= gum.getChicletsPrice();
                            totalSales += gum.getChicletsPrice();
                            gumRemaining = gum.completeGumPurchase(itemSelected);
                            System.out.println("\nChiclets: " + gumRemaining);
                        } else {
                            System.out.println("Not enough funds or item is sold out, add more or choose another item");
                        }
                        break;
                    case "Triplemint":
                        if (balance >= gum.getTriplemintPrice() && (gum.getTriplemintLeft() > 0)) {
                            gumCounter++;
                            logFile(itemSelected + " " + itemKey + " $" + balance + " $" + (balance - gum.getTriplemintPrice()));
                            balance -= gum.getTriplemintPrice();
                            totalSales += gum.getTriplemintPrice();
                            gumRemaining = gum.completeGumPurchase(itemSelected);
                            System.out.println("\nTriplemint: " + gumRemaining);
                        } else {
                            System.out.println("Not enough funds or item is sold out, add more or choose another item");
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
        logFile("GIVE CHANGE $" + balance + " $" + "0.00");

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

        System.out.println("Transaction Completed" + '\n');
        System.out.printf('\n' + "Your change is " + "$%.2f" + '\n' , totalChange);
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

    /** WRITE TO: log.txt*/
    private static void logFile(String message) throws IOException {
        try (PrintWriter logWriter = new PrintWriter(new FileWriter(logFile, true))) {
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
}