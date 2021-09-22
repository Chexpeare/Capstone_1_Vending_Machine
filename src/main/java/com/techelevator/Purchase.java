package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import com.techelevator.view.Menu;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;
// import java.sql.Date;
// import org.mockito.asm.tree.TryCatchBlockNode;


public class Purchase {
    private static final String MAIN_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String MAIN_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String MAIN_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
    private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_FEED_MONEY,
                                                        MAIN_MENU_OPTION_SELECT_PRODUCT ,
                                                        MAIN_MENU_OPTION_FINISH_TRANSACTION};
    private float balance;
    private double deposit;
    private double change;
    private static double totalSales = 0.0;
    private static int candyCounter = 0;
    private static int drinksCounter = 0;
    private static int gumCounter = 0;
    private static int chipsCounter = 0;
    private Menu menu;
    private String itemSelected;
    private String itemType;
    private String itemKey;
    private int nickels;
    private int dimes;
    private int quarters;
    private static File logFile = new File("log.txt");
    private static java.util.Date date = new java.util.Date();

    public Purchase (Menu menu) {
        this.balance =0;
        this.change = 0;
        this.menu = menu;
    }

    public void run () throws IOException {
        while (true) {
            System.out.printf('\n' + "Current balance is: $" + "%.2f",getCurrentBalance());
            String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

            if (choice.equals(MAIN_MENU_OPTION_FEED_MONEY)) {
                feedMoney();
            } else if (choice.equals(MAIN_MENU_OPTION_SELECT_PRODUCT)) {
                selectProduct(new Inventory());
            } else if (choice.equals(MAIN_MENU_OPTION_FINISH_TRANSACTION)) {
                finishTransaction();
                return;
            }
        }
    }

    public void feedMoney() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("How much money would you like to deposit: ");
        deposit = input.nextDouble();

        if (deposit > 0) {
            balance += deposit;
            logFile("$"+deposit + "  " + "$" + balance);
        } else {
            System.out.println("Invalid Deposit");
            logFile("INVALID DEPOSIT");
        }
    }

    public void selectProduct(Inventory inventory) throws IOException {
        inventory.getInventory();

        Scanner input = new Scanner(System.in);
        System.out.println("Enter in the product key you'd like to purchase: ");
        itemKey = input.nextLine();

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

        // Start of Candy
        if (itemType.equals("Candy")) {
            Candy candy = new Candy();
            if (itemSelected.equals("Moonpie")) {
                if (balance >= candy.getMoonPiePrice() && candy.getMoonpiesLeft() > 0) {
                    candyCounter++;
                    logFile(itemSelected + " " + itemKey + " $" + balance + " $" + (balance - candy.getMoonPiePrice()));
                    balance -= candy.getMoonPiePrice();
                    totalSales += candy.getMoonPiePrice();
                    candy.completeCandyPurchase(itemSelected);

                } else {
                    System.out.println("Not enough funds or item is sold out, add more or choose another item");
                }
            }else if (itemSelected.equals("Cowtales")) {
                if (balance >= candy.getCowtalesPrice() && (candy.getCowtalesLeft() > 0)) {
                    candyCounter++;
                    logFile(itemSelected + " " + itemKey + " $" + balance + " $" + (balance - candy.getCowtalesPrice()));
                    balance -= candy.getCowtalesPrice();
                    totalSales += candy.getCowtalesPrice();
                    candy.completeCandyPurchase(itemSelected);
                } else {
                    System.out.println("Not enough funds or item is sold out, add more or choose another item");
                }
            } else if (itemSelected.equals("Crunchie")) {
                if (balance >= candy.getCrunchiesPrice() && (candy.getCrunchiesLeft() > 0)) {
                    candyCounter++;
                    logFile(itemSelected + " " + itemKey + " $" + balance + " $" + (balance - candy.getCrunchiesPrice()));
                    balance -= candy.getCrunchiesPrice();
                    totalSales += candy.getCrunchiesPrice();
                    candy.completeCandyPurchase(itemSelected);
                } else {
                    System.out.println("Not enough funds or item is sold out, add more or choose another item");
                }

            } else if (itemSelected.equals("Wonka Bar")) {
                if (balance >= candy.getWonkaBarsPrice() && (candy.getWonkaBarsLeft() > 0)) {
                    candyCounter++;
                    logFile(itemSelected + " " + itemKey + " $" + balance + " $" + (balance - candy.getWonkaBarsPrice()));
                    balance -= candy.getWonkaBarsPrice();
                    totalSales += candy.getWonkaBarsPrice();
                    candy.completeCandyPurchase(itemSelected);
                } else {
                    System.out.println("Not enough funds or item is sold out, add more or choose another item");
                }

            }
        // Start of Gum
        } else if (itemType.equals("Gum")) {
            Gum gum = new Gum();
            if (itemSelected.equals("U-Chews")) {
                if (balance >= gum.getUChewsPrice() && (gum.getuChewsLeft() > 0)) {
                    gumCounter++;
                    logFile(itemSelected + " " + itemKey + " $" + balance + " $" + (balance - gum.getUChewsPrice()));
                    balance -= gum.getUChewsPrice();
                    totalSales += gum.getUChewsPrice();
                    gum.completeGumPurchase(itemSelected);

                } else {
                    System.out.println("Not enough funds or item is sold out, add more or choose another item");
                }
            } else if (itemSelected.equals("Little League Chew")) {
                if (balance >= gum.getLittleLeaugeChewPrice() && (gum.getLittleLeaugeChewLeft() > 0)) {
                    gumCounter++;
                    logFile(itemSelected + " " + itemKey + " $" + balance + " $" + (balance - gum.getLittleLeaugeChewPrice()));
                    balance -= gum.getLittleLeaugeChewPrice();
                    totalSales += gum.getLittleLeaugeChewPrice();
                    gum.completeGumPurchase(itemSelected);
                } else {
                    System.out.println("Not enough funds or item is sold out, add more or choose another item");
                }
            } else if(itemSelected.equals("Chiclets")) {
                if (balance >= gum.getChicletsPrice() && (gum.getChicletsLeft() > 0)) {
                    gumCounter++;
                    logFile(itemSelected + " " + itemKey + " $" + balance + " $" + (balance - gum.getChicletsPrice()));
                    balance -= gum.getChicletsPrice();
                    totalSales += gum.getChicletsPrice();
                    gum.completeGumPurchase(itemSelected);
                } else {
                    System.out.println("Not enough funds or item is sold out, add more or choose another item");
                }
            } else if (itemSelected.equals("Triplemint")) {
                if (balance >= gum.getTriplemintPrice() && (gum.getTriplemintLeft() > 0)) {
                    gumCounter++;
                    logFile(itemSelected + " " + itemKey + " $" + balance + " $" + (balance - gum.getTriplemintPrice()));
                    balance -= gum.getTriplemintPrice();
                    totalSales += gum.getTriplemintPrice();
                    gum.completeGumPurchase(itemSelected);
                } else {
                    System.out.println("Not enough funds or item is sold out, add more or choose another item");
                }
            }

        // Start of Chips
        } else if (itemType.equals("Chip")) {
            Chips chips = new Chips();
            if (itemSelected.equals("Potato Crisps")) {
                if (balance >= chips.getPotatoCrispsPrice() && (chips.getPotatoCrispsLeft() > 0)) {
                    chipsCounter++;
                    logFile(itemSelected + " " + itemKey + " $" + balance + " $" + (balance - chips.getPotatoCrispsPrice()));
                    balance -= chips.getPotatoCrispsPrice() ;
                    totalSales += chips.getPotatoCrispsPrice();
                    chips.completeChipsPurchase(itemSelected);

                } else {
                    System.out.println("Not enough funds or item is sold out, add more or choose another item");
                }
            } else if (itemSelected.equals("Grain Waves")) {
                if (balance >= chips.getGrainWavesPrice() && (chips.getGrainWavesLeft() > 0)) {
                    chipsCounter++;
                    logFile(itemSelected + " " + itemKey + " $" + balance + " $" + (balance - chips.getGrainWavesPrice()));
                    balance -= chips.getGrainWavesPrice();
                    totalSales += chips.getGrainWavesPrice();
                    chips.completeChipsPurchase(itemSelected);
                } else {
                    System.out.println("Not enough funds or item is sold out, add more or choose another item");
                }
            } else if (itemSelected.equals("Stackers")) {
                if (balance >= chips.getStackersPrice() && (chips.getStackersLeft() > 0)) {
                    chipsCounter++;
                    logFile(itemSelected + " " + itemKey + " $" + balance + " $" + (balance - chips.getStackersPrice()));
                    balance -= chips.getStackersPrice();
                    totalSales += chips.getStackersPrice();
                    chips.completeChipsPurchase(itemSelected);
                } else {
                    System.out.println("Not enough funds or item is sold out, add more or choose another item");
                }

            } else if (itemSelected.equals("Cloud Popcorn")) {
                if (balance >= chips.getCloudPopcornPrice() && (chips.getCloudPopcornLeft() > 0)) {
                    chipsCounter++;
                    logFile(itemSelected + " " + itemKey + " $" + balance + " $" + (balance - chips.getCloudPopcornPrice()));
                    balance -= chips.getCloudPopcornPrice();
                    totalSales += chips.getCloudPopcornPrice();
                    chips.completeChipsPurchase(itemSelected);
                } else {
                    System.out.println("Not enough funds or item is sold out, add more or choose another item");
                }
            }

        //Start of Drinks
        } else if (itemType.equals("Drink")){
            Drinks drinks = new Drinks();
            if (itemSelected.equals("Cola")) {
                if (balance >= drinks.getColaPrice() && (drinks.getColaLeft() > 0)) {
                    drinksCounter++;
                    logFile(itemSelected + " " + itemKey + " $" + balance + " $" + (balance - drinks.getColaPrice()));
                    balance -= drinks.getColaPrice();
                    totalSales += drinks.getColaPrice();
                    drinks.completeDrinksPurchase(itemSelected);
                } else {
                    System.out.println("Not enough funds or item is sold out, add more or choose another item");
                }
            } else if (itemSelected.equals("Dr. Salt")) {
                if (balance >= drinks.getDrSaltPrice() && (drinks.getDrSaltLeft() > 0)) {
                    drinksCounter++;
                    logFile(itemSelected + " " + itemKey + " $" + balance + " $" + (balance - drinks.getDrSaltPrice()));
                    balance -= drinks.getDrSaltPrice();
                    totalSales += drinks.getDrSaltPrice();
                    drinks.completeDrinksPurchase(itemSelected);
                } else {
                    System.out.println("Not enough funds or item is sold out, add more or choose another item");
                }
            } else if (itemSelected.equals("Mountain Melter")) {
                if (balance >= drinks.getMountainMelterPrice() && (drinks.getMountainMelterLeft() > 0)) {
                    drinksCounter++;
                    logFile(itemSelected + " " + itemKey + " $" + balance + " $" + (balance - drinks.getMountainMelterPrice()));
                    balance -= drinks.getMountainMelterPrice();
                    totalSales += drinks.getMountainMelterPrice();
                    drinks.completeDrinksPurchase(itemSelected);
                } else {
                    System.out.println("Not enough funds or item is sold out, add more or choose another item");
                }
            } else if (itemSelected.equals("Heavy")) {
                if (balance >= drinks.getHeavyPrice() && (drinks.getHeavyLeft() > 0)) {
                    drinksCounter++;
                    logFile(itemSelected + " " + itemKey + " $" + balance + " $" + (balance - drinks.getHeavyPrice()));
                    balance -=drinks.getHeavyPrice();
                    totalSales += drinks.getHeavyPrice();
                    drinks.completeDrinksPurchase(itemSelected);
                } else {
                    System.out.println("Not enough funds item is sold out, add more or choose another item");
                }
            }
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

    private static void logFile(String message) throws IOException {
        try (PrintWriter logWriter = new PrintWriter(new FileWriter(logFile, true))) {
            logWriter.println(date.toString() + " " + message);
            } catch (FileNotFoundException e) {
        }
    }

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