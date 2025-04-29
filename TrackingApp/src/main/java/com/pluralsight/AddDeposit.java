package com.pluralsight;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AddDeposit {



    private static void addDeposit(Scanner scanner) {
        //Add scanner into the parameters of addDeposit method so that it uses the same-(cont.)-
        //Scanner object created in the main program
        //Reads user's input efficiently without calling scanner each time
        System.out.println("Enter deposit details: ");
        //Get current date and time
        LocalDateTime now = LocalDateTime.now();
        //Define formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //Format the current date and time
        String formattedDateTime = now.format(formatter);


        //With our formatter established we can now start taking in date and time down to the second
        System.out.println("Date: " );
        String currentDate = scanner.next();
        currentDate = formattedDateTime;

        //Prompt users for their description
        System.out.println("Description: ");
        String description = scanner.nextLine();

        //Prompt users for the amount and ensure it's a valid number
        System.out.println("Amount: ");
        double amount = Double.parseDouble(scanner.nextLine());

        String depositRecord = formattedDateTime + "," + description + "," + amount + "\n";

        String filepath = "capstone-1/TrackingApp/src/main/resources/transactions.csv/";

        try (FileWriter writer = new FileWriter(filepath, true)) {
            writer.append(depositRecord);
            System.out.println("Deposit information saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving deposit: " + e.getMessage());
        }






    }


}
