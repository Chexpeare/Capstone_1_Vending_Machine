package com.techelevator;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Inventory {
    /** PROPERTIES */
    private final Map<String, String> itemTypeMap = new HashMap<>();
    private final Map<String, String> itemSelectedMap = new HashMap<>();
    private final String inventoryFile = "capstone/vendingmachine.csv";
/*  getCanonicalPath()
    platform specific method: directory path needs to conform to MacOS (/)or PC (\\)
    private final String inventoryFile = "C:\\Users\\18325\\Desktop\\CapStone Backup\\capstone\\vendingmachine.csv";
    private final String inventoryFile = "/Users/chexpeare/MeritAmerica/PairProgrammingBackup/capstone/vendingmachine.csv";
*/

    /** CONSTRUCTOR */
    public Inventory() {
    }

    /** METHODS */
    public void displayInventory() throws IOException {
        File inputFile = new File(inventoryFile);
        FileReader readerFile = new FileReader(inputFile);
        BufferedReader reader = new BufferedReader(readerFile);
        String currentLine = reader.readLine();

        while (currentLine != null) {
            String[] splitItemLine = currentLine.split("\\|");
            System.out.print(splitItemLine[0] + "  " +  splitItemLine[1] + "  $" + splitItemLine[2]);

//          INVENTORY: CHIPS
            if(splitItemLine[3].equals("Chip")) {
                Chips chips = new Chips();

                switch (splitItemLine[1]) {
                    case "Potato Crisps":
                        System.out.println("  " + chips.getPotatoCrispsLeft());
                        break;
                    case "Stackers":
                        System.out.println("  " + chips.getStackersLeft());
                        break;
                    case "Grain Waves":
                        System.out.println("  " + chips.getGrainWavesLeft());
                        break;
                    case "Cloud Popcorn":
                        System.out.println("  " + chips.getCloudPopcornLeft());
                        break;
                }
            }

//          INVENTORY: CANDY
            if (splitItemLine[3].equals("Candy")) {
                Candy candy = new Candy();

                switch (splitItemLine[1]) {
                    case "Moonpie":
                        System.out.println("  " + candy.getMoonpiesLeft());
                        break;
                    case "Cowtales":
                        System.out.println("  " + candy.getCowtalesLeft());
                        break;
                    case "Wonka Bar":
                        System.out.println("  " + candy.getWonkaBarsLeft());
                        break;
                    case "Crunchie":
                        System.out.println("  " + candy.getCrunchiesLeft());
                        break;
                }
            }

//          INVENTORY: DRINKS
            if(splitItemLine[3].equals("Drink")) {
                Drinks drinks = new Drinks();

                switch (splitItemLine[1]) {
                    case "Cola":
                        System.out.println("  " + drinks.getColaLeft());
                        break;
                    case "Dr. Salt":
                        System.out.println("  " + drinks.getDrSaltLeft());
                        break;
                    case "Mountain Melter":
                        System.out.println("  " + drinks.getMountainMelterLeft());
                        break;
                    case "Heavy":
                        System.out.println("  " + drinks.getHeavyLeft());
                        break;
                }
            }

//          INVENTORY: GUM
            if(splitItemLine[3].equals("Gum")) {
                Gum gum = new Gum();

                switch (splitItemLine[1]) {
                    case "U-Chews":
                        System.out.println("  " + gum.getuChewsLeft());
                        break;
                    case "Little League Chew":
                        System.out.println("  " + gum.getLittleLeaugeChewLeft());
                        break;
                    case "Chiclets":
                        System.out.println("  " + gum.getChicletsLeft());
                        break;
                    case "Triplemint":
                        System.out.println("  " + gum.getTriplemintLeft());
                        break;
                }
            }
            currentLine = reader.readLine();
        }
    }

    public void getInventory() throws IOException{
        File inputFile = new File(inventoryFile);
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        String currentLine = reader.readLine();

        while(currentLine != null) {
            String[] splitItemLine = currentLine.split("\\|");
            itemSelectedMap.put(splitItemLine[0], splitItemLine[1]);
            itemTypeMap.put(splitItemLine[0], splitItemLine[3]);
            currentLine = reader.readLine();
        }
    }
    public Map<String, String> getItemSelectedMap() {
        return itemSelectedMap;
    }
    public Map<String, String> getItemTypeMap() {
        return itemTypeMap;
    }
}













