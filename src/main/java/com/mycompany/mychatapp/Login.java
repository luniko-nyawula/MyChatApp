/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mychatapp;

/**
 *
 * @author ST10518479
 */
public class Login {

    String username;
    String password;
    String cellPhoneNumber;
  
   
    public Login(String username, String password, String cellPhoneNumber) {
    
        this.username = username;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
    }

    // Check username
    public boolean checkUserName() {
        return username.contains("_") && username.length() <= 5;
    }

    // Check password complexity
    public boolean checkPasswordComplexity() {
        boolean hasUpper = false;
        boolean hasNumber = false;
       boolean hasSpecial = false;

        if (password.length() >= 8) {
            for (int i = 0; i < password.length(); i++) {
                char ch = password.charAt(i);

                if (Character.isUpperCase(ch)) {
                    hasUpper = true;
                } else if (Character.isDigit(ch)) {
                    hasNumber = true;
                } else if (!Character.isLetterOrDigit(ch)) {
                    hasSpecial = true;
                }
            }
        }

        return hasUpper && hasNumber && hasSpecial;
    }

    // checking out cellphone number
    public boolean checkCellPhoneNumber() {
        if (cellPhoneNumber.startsWith("+27") && cellPhoneNumber.length() <= 12 ) {
             return true;
        } else {
              return false;
        }
       
    }
 
    public String registerUser(){

        if (!checkUserName()) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }

        if (!checkPasswordComplexity()) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }

        if (!checkCellPhoneNumber()) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }
        this.username = username;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;        
        return "Username successfully captured.\nPassword successfully captured.\nCell phone number successfully added.";
    }
    public boolean loginUser(String enteredUsername, String thisPassword) {
        if (username.equals(enteredUsername) && password.equals(thisPassword)) {
              return true;
        } else {
            return false;
        }
    }

    // This is the return login
    public String returnLoginStatus(boolean success) {
        if (success) {
            return "Welcome " + username + " it is great to see you again. ";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}
