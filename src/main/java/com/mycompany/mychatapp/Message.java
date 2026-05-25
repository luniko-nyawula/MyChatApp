/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mychatapp;

/**
 *
 * @author 10518479
 */
 import java.util.Random;

public class Message {
    // Fields required by the assignment spec sheets
    private String messageID;
    private int numMessagesSent;
    private String recipient;
    private String messageText;
    private String messageHash;

    // Constructor - initializing values when a new Message object is created
    public Message(int count) {
        this.numMessagesSent = count;
        this.messageID = generateRandomID();
    }

    // A simple 10-digit random number generator for the tracking ID
    private String generateRandomID() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(rand.nextInt(10));
        }
        return sb.toString();
    }

    // 1. Validates that the message ID is not longer than 10 characters
    public boolean checkMessageID() {
        return this.messageID.length() <= 10;
    }

    // 2. Validates recipient cellphone number formats
    public boolean checkRecipientCell() {
        if (this.recipient == null) return false;
        // Must be longer than 10 characters and start with an international code (like '+')
        return this.recipient.length() > 10 && this.recipient.startsWith("+");
    }

    // 3. Generates the custom Hash string
    public String createMessageHash() {
        // Spec requirements: First two numbers of message ID, a colon ':', 
        // number of the message, a colon ':', first word and last word in ALL CAPS.
        String idPart = this.messageID.substring(0, 2);
        
        // Split the message by spaces to find the first and last words
        String[] words = this.messageText.trim().split("\\s+");
        String firstWord = words.length > 0 ? words[0] : "";
        String lastWord = words.length > 0 ? words[words.length - 1] : "";
        
        // Cleaning punctuation from the first and last words to keep it looking nice
        firstWord = firstWord.replaceAll("[^a-zA-Z]", "");
        lastWord = lastWord.replaceAll("[^a-zA-Z]", "");

        this.messageHash = idPart + ":" + this.numMessagesSent + ":" + (firstWord + lastWord).toUpperCase();
        return this.messageHash;
    }

    // Getters and Setters to access and change values safely
    public String getMessageID() { return messageID; }
    public int getNumMessagesSent() { return numMessagesSent; }
    
    public String getRecipient() { return recipient; }
    public void setRecipient(String recipient) { this.recipient = recipient; }

    public String getMessageText() { return messageText; }
    public void setMessageText(String messageText) { this.messageText = messageText; }

    public String getMessageHash() { return messageHash; }
}