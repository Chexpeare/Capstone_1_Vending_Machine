package com.techelevator;

public class Gum extends Snack {
    private int uChewsLeft = 5;
    private int littleLeaugeChewLeft = 5;
    private int chicletsLeft = 5;
    private int triplemintLeft = 5;

    double uChewsPrice = 0.85;
    double littleLeagueChewPrice = 0.95;
    double chicletsPrice = 0.75;
    double tripleMintPrice = 0.75;

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

    /** Remaining: GETTERS & SETTERS */
    public int getuChewsLeft() {
        return uChewsLeft;
    }
    public void setuChewsLeft(int uChewsLeft) {
        this.uChewsLeft = uChewsLeft;
    }

    public int getLittleLeaugeChewLeft() {
        return littleLeaugeChewLeft;
    }
    public void setLittleLeaugeChewLeft(int littleLeaugeChewLeft) {
        this.littleLeaugeChewLeft = littleLeaugeChewLeft;
    }

    public int getChicletsLeft() {
        return chicletsLeft;
    }
    public void setChicletsLeft(int chicletsLeft) {
        this.chicletsLeft = chicletsLeft;
    }

    public int getTriplemintLeft() {
        return triplemintLeft;
    }
    public void setTriplemintLeft(int triplemintLeft) {
        this.triplemintLeft = triplemintLeft;
    }

    /** Price: GETTERS & SETTERS */
    public double getUChewsPrice() {
        return uChewsPrice;
    }
    public void setuChewsPrice(double uChewsPrice) {
        this.uChewsPrice = uChewsPrice;
    }

    public double getLittleLeaugeChewPrice() {
        return littleLeagueChewPrice;
    }
    public void setLittleLeagueChewPrice(double littleLeagueChewPrice) {
        this.littleLeagueChewPrice = littleLeagueChewPrice;
    }

    public double getChicletsPrice() {
        return chicletsPrice;
    }
    public void setChicletsPrice(double chicletsPrice) {
        this.chicletsPrice = chicletsPrice;
    }

    public double getTriplemintPrice() {
        return tripleMintPrice;
    }
    public void setTripleMintPrice(double tripleMintPrice) {
        this.tripleMintPrice = tripleMintPrice;
    }

}
