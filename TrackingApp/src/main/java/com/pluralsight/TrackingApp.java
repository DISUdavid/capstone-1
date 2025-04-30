package com.pluralsight;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TrackingApp {

    static ArrayList<LedgerEntry> ledger = new ArrayList<>();
    static String ledgerPath = "src/main/resources/transactions.csv";


    public static void main(String[] args) {

        //Create a home screen that takes user input
        ledger = readLedgerFromCsv(ledgerPath);

        System.out.println("Welcome to TrackingApp Home Screen!");

        boolean running = true;
        // Create identifiers and options for the home screen
        while (running) {
            System.out.println("D - Add Deposit");
            System.out.println("P - Make Payment");
            System.out.println("L - Display Ledger");
            System.out.println("X - Exit Application");
            System.out.print("Select your option: ");
            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.next();

            //Create loop that'll prompt users input


            if (userInput.equalsIgnoreCase("D")) {
                System.out.println("Would you like add deposit information?");
                break;
            } else if (userInput.equalsIgnoreCase("P")) {
                System.out.println("Would you like to make a payment through use of debit?");
                break;
            }
            if (userInput.equalsIgnoreCase("L")) {
                System.out.println("Would like to display Ledger Screen?");
                break;
            }
            if (userInput.equalsIgnoreCase("X")) {
                System.out.println("Goodbye User!");
                break;
            } else ;
            {
                System.out.println("Invalid input. Try Again");
            }

            scanner.close();

        }
    }

    private static ArrayList<LedgerEntry> readLedgerFromCsv(String ledgerPath) {
        return null;
    }
}
