package com.techelevator;

public class Candy extends Snack {
    private int moonPiesLeft = 5;
    private int wonkaBarsLeft = 5;
    private int crunchiesLeft = 5;
    private int cowtalesLeft = 5;

    public int getMoonpiesLeft() {
        return moonPiesLeft;
    }

    public int getWonkaBarsLeft() {
        return wonkaBarsLeft;
    }

    public int getCrunchiesLeft() {
        return crunchiesLeft;
    }

    public int getCowtalesLeft() {
        return cowtalesLeft;
    }

    public double getMoonPiePrice() {
        double moonPiePrice = 1.80;
        return moonPiePrice;
    }

    public double getCowtalesPrice() {
        double cowtalesPrice = 1.50;
        return cowtalesPrice;
    }

    public double getWonkaBarsPrice() {
        double wonkaBarsPrice = 1.50;
        return wonkaBarsPrice;
    }

    public double getCrunchiesPrice() {
        double crunchiesPrice = 1.75;
        return crunchiesPrice;
    }

    public void completeCandyPurchase(String itemSelected) {
        if (itemSelected.equals("Moonpie")) {
            moonPiesLeft--;
        } else if (itemSelected.equals("Wonka Bar")) {
            wonkaBarsLeft--;
        } else if (itemSelected.equals("Crunchie")) {
            crunchiesLeft--;
        } else if (itemSelected.equals("Cowtales")) {
            cowtalesLeft--;
        }
    }

}
