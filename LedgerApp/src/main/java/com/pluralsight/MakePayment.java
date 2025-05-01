package com.pluralsight;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MakePayment {

    public void makePayment(Scanner scanner){
        System.out.println("Enter payment details: ");
        //Get current date and time
        LocalDateTime now = LocalDateTime.now();
        //Define formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //Format the current date and time
        String formattedDateTime = now.format(formatter);

        //With our formatter established we can now start taking in date and time down to the second
//        System.out.println("Date: " );
//        String currentDate = scanner.nextLine();
//        currentDate = formattedDateTime;

        //Prompt users for their description
        System.out.println("Description: ");
        String description = scanner.nextLine();

        System.out.println("Vendor: ");
        String vendor = scanner.nextLine();

        //Prompt users for the amount and ensure it's a valid number
        System.out.println("Amount: ");
        double amount = Double.parseDouble(scanner.nextLine());

        //Ensure amounts as a negative value for payments
        String paymentRecord = formattedDateTime + "|" + description + "|" + vendor + "|" +(-amount) + "\n";
        String filepath = "src/main/resources/transactions.csv/";

        try (FileWriter writer = new FileWriter(filepath, true)) {
            writer.append(paymentRecord);
            System.out.println("Payment information saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving deposit: " + e.getMessage());
        }

    }
}