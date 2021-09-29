package com.techelevator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Inventory {
    /** PROPERTIES */
    private final Map<String, String> itemTypeMap = new HashMap<>();
    private final Map<String, String> itemSelectedMap = new HashMap<>();
    private final String inventoryFile = "capstone/vendingmachine.csv";
    private int unitsRemaining;
    /*  getCanonicalPath()
     *  platform specific method: directory path needs to conform to Unix:MacOS (/) or PC (\\)
     *  private final String inventoryFile = "C:\\Users\\18325\\Desktop\\CapStone Backup\\capstone\\vendingmachine.csv";
     *  private final String inventoryFile = "/Users/chexpeare/MeritAmerica/PairProgrammingBackup/capstone/vendingmachine.csv";
     */

    /** CONSTRUCTOR */
    public Inventory() {
    }

    /** METHODS */
    public void displayInventory() throws IOException {
        File inputFile = new File(inventoryFile);
        String canonical = inputFile.getCanonicalPath();
        FileReader readerFile = new FileReader(canonical);
        BufferedReader reader = new BufferedReader(readerFile);
        String currentLine = reader.readLine();

        while (currentLine != null) {
            String[] splitItemLine = currentLine.split("\\|");
            System.out.print(   "\033[33m" + splitItemLine[0] + "\033[32m" + "|" +
                                "\033[34m" + splitItemLine[1] + "\033[32m" + "|" +
                                "\033[35m" + splitItemLine[2] + "\033[32m" + "|" +
                                "\033[32m" + splitItemLine[3] + "\033[38m");

//          INVENTORY: CHIPS
            if(splitItemLine[3].equals("Chip")) {
                Chips chips = new Chips();

                switch (splitItemLine[1]) {
                    case "Potato Crisps":
                        unitsRemaining = chips.getPotatoCrispsLeft();
                        itemSelectedPrint(unitsRemaining);
                        break;
                    case "Stackers":
                        unitsRemaining = chips.getStackersLeft();
                        itemSelectedPrint(unitsRemaining);
                        break;
                    case "Grain Waves":
                        unitsRemaining = chips.getGrainWavesLeft();
                        itemSelectedPrint(unitsRemaining);
                        break;
                    case "Cloud Popcorn":
                        unitsRemaining = chips.getCloudPopcornLeft();
                        itemSelectedPrint(unitsRemaining);
                        break;
                }
            }

//          INVENTORY: CANDY
            if (splitItemLine[3].equals("Candy")) {
                Candy candy = new Candy();

                switch (splitItemLine[1]) {
                    case "Moonpie":
                        unitsRemaining = candy.getMoonpiesLeft();
                        itemSelectedPrint(unitsRemaining);
                        break;
                    case "Cowtales":
                        unitsRemaining = candy.getCowtalesLeft();
                        itemSelectedPrint(unitsRemaining);
                        break;
                    case "Wonka Bar":
                        unitsRemaining = candy.getWonkaBarsLeft();
                        itemSelectedPrint(unitsRemaining);
                        break;
                    case "Crunchie":
                        unitsRemaining = candy.getCrunchiesLeft();
                        itemSelectedPrint(unitsRemaining);
                        break;
                }
            }

//          INVENTORY: DRINKS
            if(splitItemLine[3].equals("Drink")) {
                Drinks drinks = new Drinks();

                switch (splitItemLine[1]) {
                    case "Cola":
                        unitsRemaining = drinks.getColaLeft();
                        itemSelectedPrint(unitsRemaining);
                        break;
                    case "Dr. Salt":
                        unitsRemaining = drinks.getDrSaltLeft();
                        itemSelectedPrint(unitsRemaining);
                        break;
                    case "Mountain Melter":
                        unitsRemaining = drinks.getMountainMelterLeft();
                        itemSelectedPrint(unitsRemaining);
                        break;
                    case "Heavy":
                        unitsRemaining = drinks.getHeavyLeft();
                        itemSelectedPrint(unitsRemaining);
                        break;
                }
            }

//          INVENTORY: GUM
            if(splitItemLine[3].equals("Gum")) {
                Gum gum = new Gum();

                switch (splitItemLine[1]) {
                    case "U-Chews":
                        unitsRemaining = gum.getuChewsLeft();
                        itemSelectedPrint(unitsRemaining);
                        break;
                    case "Little League Chew":
                        unitsRemaining = gum.getLittleLeaugeChewLeft();
                        itemSelectedPrint(unitsRemaining);
                        break;
                    case "Chiclets":
                        unitsRemaining = gum.getChicletsLeft();
                        itemSelectedPrint(unitsRemaining);
                        break;
                    case "Triplemint":
                        unitsRemaining = gum.getTriplemintLeft();
                        itemSelectedPrint(unitsRemaining);
                        break;
                }
            }
            currentLine = reader.readLine();
        }
        System.out.println("\033[38m");     // Return text color to white
    }

    public void getInventory() throws IOException{
        File inputFile = new File(inventoryFile);
        String canonical = inputFile.getCanonicalPath();
        FileReader readerFile = new FileReader(canonical);
        BufferedReader reader = new BufferedReader(readerFile);
        String currentLine = reader.readLine();

        while(currentLine != null) {
            String[] splitItemLine = currentLine.split("\\|");
            itemSelectedMap.put(splitItemLine[0], splitItemLine[1]);
            itemTypeMap.put(splitItemLine[0], splitItemLine[3]);
            currentLine = reader.readLine();
        }
    }

    private void itemSelectedPrint(int unitsRemaining) {
        if (unitsRemaining == 5) {
            System.out.println("|" + unitsRemaining);
        } else {
            System.out.println("|" + "\033[31m" + unitsRemaining + "\033[32m");
        }

    }

    public Map<String, String> getItemSelectedMap() {
        return itemSelectedMap;
    }
    public Map<String, String> getItemTypeMap() {
        return itemTypeMap;
    }

}




