package com.techelevator;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Inventory {
    /** PROPERTIES */
    private final Map<String, String> itemTypeMap = new HashMap<>();
    private final Map<String, String> itemSelectedMap = new HashMap<>();
    private final String inventoryFile = "/Users/chexpeare/MeritAmerica/PairProgrammingBackup/capstone/vendingmachine.csv";
//	private final String inputDataFile = "/capstone/vendingmachine.csv";

    /** CONSTRUCTOR */
    public Inventory() {

    }

    /** METHODS */
    public void displayInventory() throws IOException {
        File snackFile = new File(inventoryFile);
        FileReader inputFile = new FileReader(snackFile);
        BufferedReader reader = new BufferedReader(inputFile);
        String currentLine = reader.readLine();

        while (currentLine != null) {
            String[] splitItemLine = currentLine.split("\\|");
            System.out.print(splitItemLine[0] + "  " +  splitItemLine[1] + "  $" + splitItemLine[2]);

//          INVENTORY: CHIPS
            if(splitItemLine[3].equals("Chip")) {
                Chips chips = new Chips();

                if(splitItemLine[1].equals("Potato Crisps")) {
                    System.out.println("  " + chips.getPotatoCrispsLeft());
                }else if(splitItemLine[1].equals("Stackers")) {
                    System.out.println("  " +chips.getStackersLeft());
                }else if(splitItemLine[1].equals("Grain Waves")) {
                    System.out.println("  " +chips.getGrainWavesLeft());
                }else if(splitItemLine[1].equals("Cloud Popcorn")) {
                    System.out.println("  " +chips.getCloudPopcornLeft());
                }
            }

//          INVENTORY: CANDY
            if (splitItemLine[3].equals("Candy")) {
                Candy candy = new Candy();

                if (splitItemLine[1].equals("Moonpie")) {
                    System.out.println("  " +candy.getMoonpiesLeft());
                } else if (splitItemLine[1].equals("Cowtales")) {
                    System.out.println("  " +candy.getCowtalesLeft());
                } else if (splitItemLine[1].equals("Wonka Bar")) {
                    System.out.println("  " +candy.getWonkaBarsLeft());
                } else if (splitItemLine[1].equals("Crunchie")) {
                    System.out.println("  " +candy.getCrunchiesLeft());
                }
            }

//          INVENTORY: DRINKS
            if(splitItemLine[3].equals("Drink")) {
                Drinks drinks = new Drinks();

                if(splitItemLine[1].equals("Cola")) {
                    System.out.println("  " + drinks.getColaLeft());
                }else if(splitItemLine[1].equals("Dr. Salt")) {
                    System.out.println("  " + drinks.getDrSaltLeft());
                }else if(splitItemLine[1].equals("Mountain Melter")) {
                    System.out.println("  " + drinks.getMountainMelterLeft());
                }else if(splitItemLine[1].equals("Heavy")) {
                    System.out.println("  " + drinks.getHeavyLeft());
                }
            }

//          INVENTORY: GUM
            if(splitItemLine[3].equals("Gum")) {
                Gum gum = new Gum();

                if(splitItemLine[1].equals("U-Chews")) {
                    System.out.println("  " + gum.getuChewsLeft());
                }else if(splitItemLine[1].equals("Little League Chew")) {
                    System.out.println("  " + gum.getLittleLeaugeChewLeft());
                }else if(splitItemLine[1].equals("Chiclets")) {
                    System.out.println("  " + gum.getChicletsLeft());
                }else if(splitItemLine[1].equals("Triplemint")) {
                    System.out.println("  " + gum.getTriplemintLeft());
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
            String[] splitItemLine = currentLine.split("\\|");
            itemSelectedMap.put(splitItemLine[0], splitItemLine[1]);
            itemTypeMap.put(splitItemLine[0], splitItemLine[3]);
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













