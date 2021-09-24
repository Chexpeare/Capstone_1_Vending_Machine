package com.techelevator;

public class Drinks extends Snack {
    private int colaLeft = 5;
    private int drSaltLeft = 5;
    private int mountainMelterLeft = 5;
    private int heavyLeft = 5;

    private double colaPrice = 1.25;
    private double drSaltPrice = 1.50;
    private double mountainMelterPrice = 1.50;
    private double heavyPrice = 1.50;

    public int completeDrinksPurchase(String itemSelected) {
        switch (itemSelected) {
            case "Cola":
                colaLeft--;
                return colaLeft;
            case "Dr. Salt":
                drSaltLeft--;
                return drSaltLeft;
            case "Mountain Melter":
                mountainMelterLeft--;
                return mountainMelterLeft;
            case "Heavy":
                heavyLeft--;
                return heavyLeft;
            default:
                break;
        }
        return 0;
    }

    /** Remaining: GETTERS & SETTERS */
    public int getColaLeft() {
        return colaLeft;
    }
    public void setColaLeft(int colaLeft) {
        this.colaLeft = colaLeft;
    }

    public int getDrSaltLeft() {
        return drSaltLeft;
    }
    public void setDrSaltLeft(int drSaltLeft) {
        this.drSaltLeft = drSaltLeft;
    }

    public int getMountainMelterLeft() {
        return mountainMelterLeft;
    }
    public void setMountainMelterLeft(int mountainMelterLeft) {
        this.mountainMelterLeft = mountainMelterLeft;
    }

    public int getHeavyLeft() {
        return heavyLeft;
    }
    public void setHeavyLeft(int heavyLeft) {
        this.heavyLeft = heavyLeft;
    }

    /** Price: GETTERS & SETTERS */
    public double getColaPrice() {
        return colaPrice;
    }
    public void setColaPrice(double colaPrice) {
        this.colaPrice = colaPrice;
    }

    public double getDrSaltPrice() {
        return drSaltPrice;
    }
    public void setDrSaltPrice(double drSaltPrice) {
        this.drSaltPrice = drSaltPrice;
    }

    public double getMountainMelterPrice() {
        return mountainMelterPrice;
    }
    public void setMountainMelterPrice(double mountainMelterPrice) {
        this.mountainMelterPrice = mountainMelterPrice;
    }

    public double getHeavyPrice() {
        return heavyPrice;
    }
    public void setHeavyPrice(double heavyPrice) {
        this.heavyPrice = heavyPrice;
    }

}
