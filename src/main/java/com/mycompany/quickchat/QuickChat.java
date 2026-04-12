/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.quickchat;

import java.util.Scanner; 

class Login{
    
    String fName;
    String lName;
    String storedUsername;
    String storedPassword;
    String storedCellNumber;
    
    Scanner input = new Scanner(System.in);
    
    public Login( String fName, String lName,String username, String password, String cellNumber){
    this.fName = fName;
    this.lName = lName;
    this.storedUsername = username;
    this.storedPassword = password;   
    this.storedCellNumber = cellNumber;
}

// Username must have underascore and be 5 chars or less
public boolean checkUserName(){
    if(storedUsername.contains("_") && storedUsername.length() <= 5){
        System.out.println("Username successfully captured.");
        return true;
    }else{
        System.out.println("Username is not correctly formatted; please enusre that your username contains an underscore and is no more than five character in length");
        return false;
        
    }  
}

// Process complexity check(simplified, student-style)
public boolean checkPasswordComplexity(){
    
    boolean longEnough = storedPassword.length() >= 8;
    
    boolean hasCapital = false;
    for(char c : storedPassword.toCharArray()){
        if (Character.isUpperCase(c)){
            hasCapital = true;
            break;
        }
    }
    
    boolean hasNumber = false;
    for(char c : storedPassword.toCharArray()){
        hasNumber = true;
        break;
    }       

boolean hasSpecial = storedPassword.matches(".*[^a-zA-Z0-9 ].*");

if(longEnough && hasCapital && hasNumber && hasSpecial){
System.out.println("Password successfully captured.");
return true;
}else {
System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number and  a special character");
return false;
}

}

// Cell number must start with + and be correct length
public boolean checkCellPhoneNumber(){ 
    
    if(storedCellNumber.startsWith("+") && storedCellNumber.length() <= 12){
        System.out.println("Cell number successfully captured.");
        return true;
    }else {
        System.out.println("Cell number is incorrectly fornatted or does not contain an international code; please correct the number and try again");
        return false;
    }
}

// Registration message
public String registerUser(){
    
    if(!checkUserName()){
        return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than 5 characters in length.";      
    }
    if(!checkPasswordComplexity()){
        return"Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number and special charcters.";
    }
    
    if(!checkCellPhoneNumber()){
        return "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.";
    }
    return "User registred successfully.";
}

// Login check
public boolean loginUser(String enteredUsername, String enteredPassword){
    return enteredUsername.equals(storedUsername) && enteredPassword.equals(storedPassword);
}

// Login status message
public String returnLoginStatus(boolean loginSuccess){
    if(loginSuccess){
        return "Welcome " + fName + ", " + lName + "it is great to see you again.";
    }
    return "Username or password incorrect, please try again.";
}

}

/**
 *
 * @author A.Ntuli
 */
public class QuickChat {
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("===== CREATE ACCOUNT =====");
        
        System.out.println("Enter First Name: ");
        String fName = input.nextLine();
        
        System.out.println("Enter Last Name: ");
        String lName = input.nextLine();
        
        System.out.println("Enter Username: ");
        String username = input.nextLine();
        
        System.out.println("Enter Password: ");
        String password = input.nextLine();
        
        System.out.println("Enter Cell Number(with international code): ");
        String cellNumber = input.nextLine();
        
        // Store everything in ONE login object
        Login app = new Login(fName, lName, username, password, cellNumber);
        
        int choice;
        
        do{
            System.out.println("\n===== QUICKCHAT MENU =====");
            System.out.println("1. Register User");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            
             System.out.println("Choose option");
             choice = input.nextInt();
             input.nextLine();//clear leftover newline
             
             switch(choice){
                 case 1:
                      System.out.println(app.registerUser());
                      break;
                      
                 case 2:
                      System.out.println("Enter Username: ");
                      String u = input.nextLine();
                      
                       System.out.println("Enter Password: ");
                       String p = input.nextLine();
                       
                       boolean success = app.loginUser(u, p);
                       break;
                       
                 case 3:
                     System.out.println("Goodbye!");
                     break;
                     
                 default:
                     System.out.println("Invalid option.");
                       
             }
        }while ( choice != 3);
        
        input.close(); 
    }
}
 
// JUnit testing is basically a way of checking whether your Java code actually  works the way you
// epected it to, without ahaving to the whole program everytime.Instead of typing inputsand guessing if
// your methods behave correctly, you write small automated tests that call your methods amd compare the actual
// results to the  result you expecte.
