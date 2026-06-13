/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickchat;

/**
 *
 * @author junio
 */

public class Login {

     private String storedUsername;
    private String storedPassword;
    private String storedCell;
    private String firstName;
    private String lastName;

    public Login() {} 

    // Register user with basic checks
    public String registerUser(String fName, String lName, String username, String password, String cell) {
        this.firstName = fName;
        this.lastName = lName;
        this.storedUsername = username;
        this.storedPassword = password;
        this.storedCell = cell;

        if(!checkUserName(username)) {
            return "Oops! Username must have an underscore and be max 5 chars.";
        }
        if(!checkPasswordComplexity(password)) {
            return "Password too weak. Needs 8+ chars, a capital, number, and special symbol.";
        }
        if(!checkCellPhoneNumber(cell)) {
            return "Cell number wrong format. Must start with +27 and be at least 11 digits.";
        }
        return "User registered successfully.";
    }

    // Simple checks
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity(String password) {
        boolean longEnough = password.length() >= 8;
        boolean hasCapital = password.matches(".*[A-Z].*");
        boolean hasNumber = password.matches(".*[0-9].*");
        boolean hasSpecial = password.matches(".*[^a-zA-Z0-9].*");
        return longEnough && hasCapital && hasNumber && hasSpecial;
    }

    public boolean checkCellPhoneNumber(String cell) { 
        return cell.startsWith("+27") && cell.length() >= 11;
    }

    // Login check
    public boolean loginUser(String username, String password) {
        return username.equals(storedUsername) && password.equals(storedPassword);
    }

    // Friendly welcome message
    public String returnLoginStatus(boolean loggedIn) {
        if(loggedIn) {
            return "Welcome " + firstName + " " + lastName + "! You’re logged in.\n" +
                   "Now you can use QuickChat features (Send, Store, Disregard, Reports).";
        } else {
            return "Login failed. Try again.";
        }
    }
}