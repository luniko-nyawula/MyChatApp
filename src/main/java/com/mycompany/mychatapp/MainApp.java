package com.mycompany.mychatapp;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author St10518479
 */
import com.mycompany.mychatapp.Login;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String username;
        String password;
        String cellPhone;
        String firstName;
        String lastName;

        System.out.println("=== Registration ===");

        System.out.print("Enter first name: ");
        firstName = input.nextLine();

        System.out.print("Enter last name: ");
        lastName = input.nextLine();

        // Username loop
        while (true) {
            System.out.print("Enter username: ");
            username = input.nextLine();

            Login temp = new Login( username, "", "");

            if (temp.checkUserName()) {
                System.out.println("Username successfully captured.");
                break;
            } else {
                System.out.println("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.");
            }
        }

        // Password loop
        while (true) {
            System.out.print("Enter password: ");
            password = input.nextLine();

            Login temp = new Login( username, password, "");

            if (temp.checkPasswordComplexity()) {
                System.out.println("Password successfully captured.");
                break;
            } else {
                System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
            }
        }

        
        while (true) {
            System.out.print("Enter cell phone number (+27): ");
            cellPhone = input.nextLine();

            Login temp = new Login( username, password, cellPhone);

            if (temp.checkCellPhoneNumber()) {
                System.out.println("Cell phone number successfully added.");
                break;
            } else {
                System.out.println("Cell phone number incorrectly formatted or does not contain international code.");
            }
        }

        // Create final user object
        Login user = new Login( username, password, cellPhone);

        System.out.println("\n=== Login ===");

        // Login loop
        boolean loggedIn = false;

        while (!loggedIn) {
            System.out.print("Enter username: ");
            String enteredUsername = input.nextLine();

            System.out.print("Enter password: ");
            String enteredPassword = input.nextLine();

            boolean result = user.loginUser(enteredUsername, enteredPassword);

            System.out.println(user.returnLoginStatus(result));

            if (result) {
                loggedIn = true;
            }
        System.out.println("\nWelcome to QuickChat.");
        
        // Storage container array list to hold finalized valid messages
        ArrayList<Message> messageList = new ArrayList<>();
        int messageCounter = 0; // Tracks global sequence allocation
        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;
        
        // Rubric Item: "While loop - The application loop runs correctly and quits on correct input"
        while (keepRunning) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1) Send Messages");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Quit");
            System.out.print("Select an option (1-3): ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume trailing newline left in the stream
            
            switch (choice) {
                case 1:
                    // Rubric Item: Users define how many messages they wish to enter up front
                    System.out.print("How many messages do you wish to enter for this batch? ");
                    int totalBatchSize = scanner.nextInt();
                    scanner.nextLine(); // Clear scanner stream buffer
                    
                    // Rubric Item: "For loop is used to allow the user to enter the assigned number of messages"
                    for (int i = 0; i < totalBatchSize; i++) {
                        System.out.println("\n--- Composing Message " + (i + 1) + " of " + totalBatchSize + " ---");
                        
                        // Increment sequence count variable
                        messageCounter++;
                        Message currentMsg = new Message(messageCounter);
                        
                        // 1. Validate Recipient Input Loop
                        boolean validRecipient = false;
                        while (!validRecipient) {
                            System.out.print("Enter Recipient Cellphone Number (e.g., +27718693002): ");
                            currentMsg.setRecipient(scanner.nextLine());
                            
                            if (currentMsg.checkRecipientCell()) {
                                System.out.println("Cell phone number successfully captured.");
                                validRecipient = true;
                            } else {
                                System.out.println("Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.");
                            }
                        }
                        
                        // 2. Validate Message Text Character Constraints Loop
                        boolean validText = false;
                        while (!validText) {
                            System.out.print("Enter your message (Max 250 characters): ");
                            String userText = scanner.nextLine();
                            
                            if (userText.length() <= 250) {
                                currentMsg.setMessageText(userText);
                                System.out.println("Message ready to send.");
                                validText = true;
                            } else {
                                int excess = userText.length() - 250;
                                System.out.println("Message exceeds 250 characters by " + excess + " characters; please reduce the size.");
                            }
                        }
                        
                        // Process the custom string manipulation hash string assignment
                        currentMsg.createMessageHash();
                        
                        // 3. Prompt selection action options menu loop
                        System.out.println("\nSelect an action for this message item:");
                        System.out.println("  1. Send Message");
                        System.out.println("  2. Disregard Message");
                        System.out.println("  3. Store Message to send later");
                        System.out.print("Choice: ");
                        int actionChoice = scanner.nextInt();
                        scanner.nextLine(); // Clean buffer stream
                        
                        if (actionChoice == 1) {
                            System.out.println("Message successfully sent.");
                            messageList.add(currentMsg);
                        } else if (actionChoice == 2) {
                            System.out.println("Press 0 to delete the message.");
                            String confirm = scanner.nextLine();
                            if (confirm.equals("0")) {
                                System.out.println("Message disregarded.");
                            }
                        } else if (actionChoice == 3) {
                            System.out.println("Message successfully stored.");
                            messageList.add(currentMsg);
                        }
                    }
                    break;
                    
                case 2:
                    // Rubric requirement: "Show recently sent messages - displays 'Coming Soon.'"
                    System.out.println("Coming Soon.");
                    break;
                    
                case 3:
                    // Gracefully flip state tracking condition flag to break loop run cycle
                    System.out.println("Exiting Application Menu Loop...");
                    keepRunning = false;
                    break;
                    
                default:
                    System.out.println("Invalid selection option. Please choose an item between 1 and 3.");
            }
        }
        
        // Rubric Item: "Message details display correctly - The messages details are displayed in the correct order"
        System.out.println("\n==================================================");
        System.out.println("        FINAL SUMMARY REPORT OF CURRENT BATCH       ");
        System.out.println("==================================================");
        
        for (Message m : messageList) {
            System.out.println("Message ID: " + m.getMessageID());
            System.out.println("Message Hash: " + m.getMessageHash());
            System.out.println("Recipient: " + m.getRecipient());
            System.out.println("Message: " + m.getMessageText());
            System.out.println("--------------------------------------------------");
        }
        
        // Rubric Item: Total number accumulated displayed once all messages sent
        System.out.println("Total Accumulated Messages Processed: " + messageList.size());
         
        scanner.close();
    }
}
        
        
 
}
