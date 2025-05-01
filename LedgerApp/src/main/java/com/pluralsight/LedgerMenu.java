package com.pluralsight;

import java.util.Scanner;

public class LedgerMenu {
    public LedgerMenu() {}

    public void displayLedgerMenu(Scanner scanner) {
        boolean running = true;
        String userInput;

        // Create identifiers and options for the home screen
        while (running) {
            System.out.println("D - Add Deposit");
            System.out.println("P - Make Payment");
            System.out.println("L - Display Ledger");
            System.out.println("X - Exit Application");
            System.out.print("Select your option: ");
            userInput = scanner.nextLine();

            //Create loop that'll prompt users input
//            AddDeposit addDeposit = new AddDeposit();
//            MakePayment makePayment = new MakePayment();

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
