package com.techelevator;

public class Chips extends Snack {
    private int potatoCrispsLeft = 5;
    private int stackersLeft = 5;
    private int grainWavesLeft = 5;
    private int cloudPopcornLeft = 5;

    public int getPotatoCrispsLeft() {
        return potatoCrispsLeft;
    }

    public int getStackersLeft() {
        return stackersLeft;
    }

    public int getGrainWavesLeft() {
        return grainWavesLeft;
    }

    public int getCloudPopcornLeft() {
        return cloudPopcornLeft;
    }

    public double getPotatoCrispsPrice() {
        double potatoCrispsPrice = 3.05;
        return potatoCrispsPrice;
    }

    public double getStackersPrice() {
        double stackersPrice = 1.45;
        return stackersPrice;
    }

    public double getGrainWavesPrice() {
        double grainwavesPrice = 2.75;
        return grainwavesPrice;
    }

    public double getCloudPopcornPrice() {
        double cloudPopcornPrice = 3.65;
        return cloudPopcornPrice;
    }

    public void completeChipsPurchase(String itemSelected) {
        if (itemSelected.equals("Potato Crisps")) {
            potatoCrispsLeft--;
        } else if (itemSelected.equals("Stackers")) {
            stackersLeft--;
        } else if (itemSelected.equals("Grain Waves")) {
            grainWavesLeft--;
        } else if (itemSelected.equals("Cloud Popcorn")) {
            cloudPopcornLeft--;
        }
    }
}
