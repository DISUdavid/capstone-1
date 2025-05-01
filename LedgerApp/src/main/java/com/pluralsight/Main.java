package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArrayList<LedgerEntry> ledger = new ArrayList<>();
        String ledgerPath = "src/main/resources/transactions.csv";

            //Create a home screen that takes user input
            ledger = readLedgerFromCsv(ledgerPath);

            Scanner scanner = new Scanner(System.in);
            String userInput;

            System.out.println("Welcome to TrackingApp Home Screen!");

            boolean running = true;

            // Create identifiers and options for the home screen
            while (running) {
                System.out.println("D - Add Deposit");
                System.out.println("P - Make Payment");
                System.out.println("L - Display Ledger");
                System.out.println("X - Exit Application");
                System.out.print("Select your option: ");
                userInput = scanner.nextLine();

                //Create loop that'll prompt users input
                AddDeposit addDeposit = new AddDeposit();
                MakePayment makePayment = new MakePayment();
                LedgerMenu ledgerMenu = new LedgerMenu();

                if (userInput.equalsIgnoreCase("D")) {
                    System.out.println("Would you like add deposit information?");
                    addDeposit.addDeposit(scanner);
                    // break;
                } else if (userInput.equalsIgnoreCase("P")) {
                    System.out.println("Would you like to make a payment through use of debit?");
                    makePayment.makePayment(scanner);
                    // break;
                } else if (userInput.equalsIgnoreCase("L")) {
                    System.out.println("Would like to display Ledger Screen?");
                    ledgerMenu.displayLedgerMenu();
                    // break;
                } else if (userInput.equalsIgnoreCase("X")) {
                    running = false;
                    System.out.println("Goodbye User!");
                    // break;
                } else {
                    System.out.println("Invalid input. Try Again");
                }
            }
        }

//    private static ArrayList<LedgerEntry> readLedgerFromCsv(String ledgerPath) {
//        ArrayList<LedgerEntry> ledgerEntries = new ArrayList<>();
//
//        return ledgerEntries;
//    }

        public static ArrayList<LedgerEntry> readLedgerFromCsv(String ledgerPath) {
            ArrayList<LedgerEntry> ledgerEntries = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader(ledgerPath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split("\\|");
                    if (parts.length < 5) continue; // Skip invalid lines

                    String date = parts[0];
                    String time = parts[1];
                    String description = parts[2];
                    String vendor = parts[3];
                    double amount = Double.parseDouble(parts[4]); // Convert string to double

                    ledgerEntries.add(new LedgerEntry(date, time, description, vendor, amount)); // Add entry to list
                }
            } catch (IOException e) {
                System.out.println("Error reading ledger file: " + e.getMessage());
            }

            return ledgerEntries;
        }
}
