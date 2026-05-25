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
        }

        input.close();
    }
}

