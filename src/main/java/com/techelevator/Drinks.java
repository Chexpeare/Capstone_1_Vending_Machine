package com.techelevator;

public class Drinks extends Snack {
    private int colaLeft = 5;
    private int drSaltLeft = 5;
    private int mountainMelterLeft = 5;
    private int heavyLeft = 5;

    public int getColaLeft() {
        return colaLeft;
    }

    public int getDrSaltLeft() {
        return drSaltLeft;
    }

    public int getMountainMelterLeft() {
        return mountainMelterLeft;
    }

    public int getHeavyLeft() {
        return heavyLeft;
    }

    public double getColaPrice() {
        double colaPrice = 1.25;
        return colaPrice;
    }

    public double getDrSaltPrice() {
        double drSaltPrice = 1.50;
        return drSaltPrice;
    }

    public double getMountainMelterPrice() {
        double mountainMelterPrice = 1.50;
        return mountainMelterPrice;
    }

    public double getHeavyPrice() {
        double heavyPrice = 1.50;
        return heavyPrice;
    }

    public void completeDrinksPurchase(String itemSelected) {
        if(itemSelected.equals("Cola")) {
            colaLeft--;
        }else if(itemSelected.equals("Dr. Salt")) {
            drSaltLeft--;
        }else if(itemSelected.equals("Mountain Melter")) {
            mountainMelterLeft--;
        }else if(itemSelected.equals("Heavy")) {
            heavyLeft--;
        }
    }

}
