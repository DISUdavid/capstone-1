package com.pluralsight;

public class LedgerEntry {

    private String currentDate;
    private String vendor;
    private String description;
    private double amount;

    public LedgerEntry(){

    }

    public LedgerEntry(String currentDate, String vendor, String description, double amount){
        this.currentDate = currentDate;
        this.vendor = vendor;
        this.description = description;
        this.amount = amount;
    }

    public String getCurrentDate() {
        return currentDate;
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
