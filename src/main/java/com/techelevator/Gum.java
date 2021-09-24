package com.techelevator;

public class Gum extends Snack {
    private int uChewsLeft = 5;
    private int littleLeagueChewLeft = 5;
    private int chicletsLeft = 5;
    private int triplemintLeft = 5;

    double uChewsPrice = 0.85;
    double littleLeagueChewPrice = 0.95;
    double chicletsPrice = 0.75;
    double tripleMintPrice = 0.75;

    public int completeGumPurchase(String itemSelected) {
        switch (itemSelected) {
            case "U-Chews":
                uChewsLeft--;
                return uChewsLeft;
            case "Little League Chew":
                littleLeagueChewLeft--;
                return littleLeagueChewLeft;
            case "Chiclets":
                chicletsLeft--;
                return chicletsLeft;
            case "Triplemint":
                triplemintLeft--;
                return triplemintLeft;
            default:
                break;
        }
        return 0;
    }

    /** Remaining: GETTERS & SETTERS */
    public int getuChewsLeft() {
        return uChewsLeft;
    }
    public void setuChewsLeft(int uChewsLeft) {
        this.uChewsLeft = uChewsLeft;
    }

    public int getLittleLeaugeChewLeft() {
        return littleLeagueChewLeft;
    }
    public void setLittleLeaugeChewLeft(int littleLeaugeChewLeft) {
        this.littleLeagueChewLeft = littleLeaugeChewLeft;
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
