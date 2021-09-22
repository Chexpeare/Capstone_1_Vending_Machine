package com.techelevator;

public class Gum {
    private int uChewsLeft = 5;
    private int littleLeaugeChewLeft = 5;
    private int chicletsLeft = 5;
    private int triplemintLeft = 5;

    public int getuChewsLeft() {
        return uChewsLeft;
    }

    public int getLittleLeaugeChewLeft() {
        return littleLeaugeChewLeft;
    }

    public int getChicletsLeft() {
        return chicletsLeft;
    }

    public int getTriplemintLeft() {
        return triplemintLeft;
    }

    public double getUChewsPrice() {
        double uChewsPrice = 0.0;
        return uChewsPrice;
    }

    public double getLittleLeaugeChewPrice() {
        double littleLeagueChewPrice = 0.0;
        return littleLeagueChewPrice;
    }

    public double getChicletsPrice() {
        double chicletsPrice = 0.0;
        return chicletsPrice;
    }

    public double getTriplemintPrice() {
        double tripleMintPrice = 0.0;
        return tripleMintPrice;
    }

    public void completeGumPurchase(String itemSelected) {
        if(itemSelected.equals("U-Chews")) {
            uChewsLeft--;
        }else if(itemSelected.equals("Little League Chew")) {
            littleLeaugeChewLeft--;
        }else if(itemSelected.equals("Chiclets")) {
            chicletsLeft--;
        }else if(itemSelected.equals("Triplement")) {
            triplemintLeft--;
        }
    }
}
