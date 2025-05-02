package com.pluralsight;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;


public class LedgerMenu { //fixme: ledger not displaying
    public static ArrayList<LedgerEntry> ledgerEntries;

    public LedgerMenu() {// fixme: suspect the issue is somewhere between 9-14
        ledgerEntries = Main.readLedgerFromCsv("src/main/resources/transactions.csv");
    }

    public static void displayAllEntries(ArrayList<LedgerEntry> ledgerEntries) {
        for (LedgerEntry ledgerEntry: ledgerEntries) {
            // todo : add other fields from ledgerEntry
            System.out.println(ledgerEntry.getDate() + " " + ledgerEntry.getTime() + " "+ ledgerEntry.getDescription()+ " "+ ledgerEntry.getVendor() + " " + ledgerEntry.getAmount());
        }
    }

    public static void displayDeposits(ArrayList<LedgerEntry> ledgerEntries) {
        for (LedgerEntry l: ledgerEntries) {
            if (l.getAmount() > 0) {
                System.out.println(l.getDate() + " " + l.getTime());
            }

        }
    }

    public static void displayPayments(ArrayList<LedgerEntry> ledgerEntries) {
        for(LedgerEntry l: ledgerEntries) {
            if (l.getAmount() <0) {
                System.out.println(l.getDate() + " " + l.getTime());
            }
        }
    }

    public static void displayMonthToDateEntries(ArrayList<LedgerEntry> ledgerEntries) {
        for (LedgerEntry l: ledgerEntries) {
            LocalDate month = LocalDate.parse(l.getDate(), DateTimeFormatter.ofPattern("MM"));
            System.out.println(month);

        }
    }


    public static void displayPreviousMonthEntries(ArrayList<LedgerEntry> ledgerEntries) {// todo: does not work, tried to be advanced and failed
        for (LedgerEntry l: ledgerEntries) {
            for (int i = 0; i <= 12; i--) {
                LocalDate previousMonth = LocalDate.parse(l.getDate());
                System.out.println("\nPrevious Month Entries: " + previousMonth);
            }
        }
    }

    public static void displayYearToDateEntries(ArrayList<LedgerEntry> ledgerEntries) {//todo: does not work, tried to be advanced and failed
        LocalDate today = LocalDate.now();
        LocalDate firstDayOfYear = today.withDayOfYear(1); // January 1st of the current year

        System.out.println("\nYear-To-Date Entries:");

    }

    public static void displayPreviousYearEntries(ArrayList<LedgerEntry> ledgerEntries) {// todo: does not work, tried to be advanced and failed
        LocalDate today = LocalDate.now();
        LocalDate firstDayOfPreviousYear = today.minusYears(1).withDayOfYear(1);
        LocalDate lastDayOfPreviousYear = today.minusYears(1).withDayOfYear(today.minusYears(1).lengthOfYear());

        System.out.println("\nPrevious Year Entries:");


    }

    public static void searchByVendor(ArrayList<LedgerEntry> ledgerEntries, String vendorName) {// fixme: partially works, tried to be advanced and failed

    }

    public void displayLedgerMenu(Scanner scanner) {
        boolean running = true;
        String userInput;

        while (running) {
            System.out.println("\nLedger Menu:");
            System.out.println("A - Display All Entries");
            System.out.println("D - Display Deposits Only");
            System.out.println("P - Display Payments Only");
            System.out.println("R - Reports");
            System.out.println("H - Home");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice.toUpperCase()) {
                case "A":
                    displayAllEntries(ledgerEntries);
                    break;
                case "D":
                    displayDeposits(ledgerEntries);
                    break;
                case "P":
                    displayPayments(ledgerEntries);
                    break;
                case "R":
                    showReportsMenu(scanner, ledgerEntries);
                    break;
                case "H":
                    running = false; // Exit ledger menu
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static void showReportsMenu(Scanner scanner, ArrayList<LedgerEntry> ledgerEntries) {
        System.out.println("\nReports Menu:");
        System.out.println("1 - Month To Date");
        System.out.println("2 - Previous Month");
        System.out.println("3 - Year To Date");
        System.out.println("4 - Previous Year");
        System.out.println("5 - Search by Vendor");
        System.out.println("0 - Back");

        System.out.print("Enter your choice: ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                displayMonthToDateEntries(ledgerEntries);
                break;
            case "2":
                displayPreviousMonthEntries(ledgerEntries);
                break;
            case "3":
                displayYearToDateEntries(ledgerEntries);
                break;
            case "4":
                displayPreviousYearEntries(ledgerEntries);
                break;
            case "5":
                System.out.print("Enter vendor name: ");
                String vendor = scanner.nextLine();
                searchByVendor(ledgerEntries, vendor);
                break;
            case "0":
                return; // Go back to ledger menu
            default:
                System.out.println("Invalid report option. Please enter a valid choice.");
        }

    }
}