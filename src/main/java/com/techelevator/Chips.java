package com.techelevator;

public class Chips extends Snack {
    private int potatoCrispsLeft = 5;
    private int stackersLeft = 5;
    private int grainWavesLeft = 5;
    private int cloudPopcornLeft = 5;

    private double potatoCrispsPrice = 3.05;
    private double stackersPrice = 1.45;
    private double grainWavesPrice = 2.75;
    private double cloudPopcornPrice = 3.65;

    public void completeChipsPurchase(String itemSelected) {
        switch (itemSelected) {
            case "Potato Crisps":
                this.potatoCrispsLeft--;
                break;
            case "Stackers":
                this.stackersLeft--;
                break;
            case "Grain Waves":
                this.grainWavesLeft--;
                break;
            case "Cloud Popcorn":
                this.cloudPopcornLeft--;
                break;
        }
    }

    /** Remaining: GETTERS & SETTERS */
    public int getPotatoCrispsLeft() {
        return this.potatoCrispsLeft;
    }
    public void setPotatoCrispsLeft(int potatoCrispsLeft) {
        this.potatoCrispsLeft = potatoCrispsLeft;
    }

    public int getStackersLeft() {
        return stackersLeft;
    }
    public void setStackersLeft(int stackersLeft) {
        this.stackersLeft = stackersLeft;
    }

    public int getGrainWavesLeft() {
        return grainWavesLeft;
    }
    public void setGrainWavesLeft(int grainWavesLeft) {
        this.grainWavesLeft = grainWavesLeft;
    }

    public int getCloudPopcornLeft() {
        return cloudPopcornLeft;
    }
    public void setCloudPopcornLeft(int cloudPopcornLeft) {
        this.cloudPopcornLeft = cloudPopcornLeft;
    }

    /** Price: GETTERS & SETTERS */
    public double getPotatoCrispsPrice() {
        return potatoCrispsPrice;
    }
    public void setPotatoCrispsPrice(double potatoCrispsPrice) {
        this.potatoCrispsPrice = potatoCrispsPrice;
    }

    public double getStackersPrice() {
        return stackersPrice;
    }
    public void setStackersPrice(double stackersPrice) {
        this.stackersPrice = stackersPrice;
    }

    public double getGrainWavesPrice() {
        return grainWavesPrice;
    }
    public void setGrainwavesPrice(double grainwavesPrice) {
        this.grainWavesPrice = grainwavesPrice;
    }

    public double getCloudPopcornPrice() {
        return cloudPopcornPrice;
    }
    public void setCloudPopcornPrice(double cloudPopcornPrice) {
        this.cloudPopcornPrice = cloudPopcornPrice;
    }

}
