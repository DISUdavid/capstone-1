package com.pluralsight;

public class LedgerEntry {

    private String currentDate;
    private String currentTime;
    private String vendor;
    private String description;
    private double amount;

    public LedgerEntry(){

    }

    public LedgerEntry(String currentDate, String currentTime, String vendor, String description, double amount){
        this.currentDate = currentDate;
        this.currentTime = currentTime;
        this.vendor = vendor;
        this.description = description;
        this.amount = amount;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }
    public String getVendor() {
        return vendor;
    }

}
