package com.pluralsight;

public class LedgerEntry {
    private String date;
    private String time;
    private String vendor;
    private String description;
    private double amount;

    public LedgerEntry(){

    }

    public LedgerEntry(String date, String time, String vendor, String description, double amount){
        this.date = date;
        this.time = time;
        this.vendor = vendor;
        this.description = description;
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
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