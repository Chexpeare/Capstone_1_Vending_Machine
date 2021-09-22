package com.techelevator;

import java.io.*;
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class Inventory {
    /** PROPERTIES */
    private final Map<String, String> itemTypeMap = new HashMap<>();
    private final Map<String, String> itemSelectedMap = new HashMap<>();
    private String inventoryFile = "/Users/chexpeare/MeritAmerica/PairProgrammingBackup/capstone/vendingmachine.csv";

    /** CONSTRUCTORS */
    public Inventory() {

    }

    /** METHODS */
    public void displayInventory() throws IOException {
        File snackFile = new File(inventoryFile);
        BufferedReader reader = new BufferedReader(new FileReader(snackFile));
        String currentLine = reader.readLine();

        while (currentLine != null) {
            String[] splitUp = currentLine.split("\\|");
            System.out.print(splitUp[0] + "  " +  splitUp[1] + "  $" + splitUp[2]);

            /** INVENTORY: CANDY */
            if (splitUp[3].equals("Candy")) {
                Candy candy = new Candy();

                if (splitUp[1].equals("Moonpie")) {
                    System.out.println("  " +candy.getMoonpiesLeft());
                } else if (splitUp[1].equals("Cowtales")) {
                    System.out.println("  " +candy.getCowtalesLeft());
                } else if (splitUp[1].equals("Wonka Bar")) {
                    System.out.println("  " +candy.getWonkaBarsLeft());
                } else if (splitUp[1].equals("Crunchie")) {
                    System.out.println("  " +candy.getCrunchiesLeft());
                }
            }

            /** INVENTORY: CHIPS */
            if(splitUp[3].equals("Chip")) {
                Chips chips = new Chips();

                if(splitUp[1].equals("Potato Crisps")) {
                    System.out.println("  " + chips.getPotatoCrispsLeft());
                }else if(splitUp[1].equals("Stackers")) {
                    System.out.println("  " +chips.getStackersLeft());
                }else if(splitUp[1].equals("Grain Waves")) {
                    System.out.println("  " +chips.getGrainWavesLeft());
                }else if(splitUp[1].equals("Cloud Popcorn")) {
                    System.out.println("  " +chips.getCloudPopcornLeft());
                }
            }

            /** INVENTORY: GUM */
            if(splitUp[3].equals("Gum")) {
                Gum gum = new Gum();

                if(splitUp[1].equals("U-Chews")) {
                    System.out.println("  " + gum.getuChewsLeft());
                }else if(splitUp[1].equals("Little League Chew")) {
                    System.out.println("  " + gum.getLittleLeaugeChewLeft());
                }else if(splitUp[1].equals("Chiclets")) {
                    System.out.println("  " + gum.getChicletsLeft());
                }else if(splitUp[1].equals("Triplemint")) {
                    System.out.println("  " + gum.getTriplemintLeft());
                }
            }

            /** INVENTORY: DRINKS */
            if(splitUp[3].equals("Drink")) {
                Drinks drinks = new Drinks();

                if(splitUp[1].equals("Cola")) {
                    System.out.println("  " + drinks.getColaLeft());
                }else if(splitUp[1].equals("Dr. Salt")) {
                    System.out.println("  " + drinks.getDrSaltLeft());
                }else if(splitUp[1].equals("Mountain Melter")) {
                    System.out.println("  " + drinks.getMountainMelterLeft());
                }else if(splitUp[1].equals("Heavy")) {
                    System.out.println("  " + drinks.getHeavyLeft());
                }
            }
            currentLine = reader.readLine();
        }
    }

    public void getInventory() throws IOException{
        File snackFile = new File(inventoryFile);
        BufferedReader reader = new BufferedReader(new FileReader(snackFile));
        String currentLine = reader.readLine();

        while(currentLine != null) {
            String[] splitUp = currentLine.split("\\|");
            itemSelectedMap.put(splitUp[0], splitUp[1]);
            itemTypeMap.put(splitUp[0], splitUp[3]);
            currentLine = reader.readLine();
        }
    }

    public Map<String, String> getItemTypeMap() {
        return itemTypeMap;
    }

    public Map<String, String> getItemSelectedMap() {
        return itemSelectedMap;
    }
}













