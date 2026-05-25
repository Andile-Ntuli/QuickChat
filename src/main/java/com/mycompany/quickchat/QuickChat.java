/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.quickchat;

import java.util.Scanner; 

public class QuickChat {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Login app = new Login();

        int choice;

        // OUTER LOOP: Main menu
        do {
            System.out.println("\n===== QUICKCHAT MENU =====");
            System.out.println("1. Register User");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            System.out.print("Choose option: ");
            choice = input.nextInt();
            input.nextLine();

            switch(choice) {
                case 1:
                    // Registration
                    System.out.print("Enter first name: ");
                    String fName = input.nextLine();

                    System.out.print("Enter last name: ");
                    String lName = input.nextLine();

                    System.out.print("Enter username: ");
                    String username = input.nextLine();

                    System.out.print("Enter password: ");
                    String password = input.nextLine();

                    System.out.print("Enter cell number: ");
                    String cell = input.nextLine();

                    System.out.println(app.registerUser(fName, lName, username, password, cell));
                    break;

                case 2:
                    // Login
                    System.out.print("Enter username: ");
                    String u = input.nextLine();

                    System.out.print("Enter password: ");
                    String p = input.nextLine();

                    if(app.loginUser(u, p)) {
                        System.out.println(app.returnLoginStatus());

                        // INNER LOOP: Message menu
                        int msgChoice;
                        do {
                            System.out.println("\n===== MESSAGE MENU =====");
                            System.out.println("1. Send Message");
                            System.out.println("2. Show Recent Messages");
                            System.out.println("3. Quit Messages");

                            msgChoice = input.nextInt();
                            input.nextLine();

                            switch(msgChoice) {
                                case 1:
                                    System.out.print("Enter message ID: ");
                                    String id = input.nextLine();

                                    System.out.print("Enter recipient number: ");
                                    String recipient = input.nextLine();

                                    System.out.print("Enter message: ");
                                    String text = input.nextLine();

                                    Message msg = new Message(id, recipient, text, 1);
                                    System.out.println(msg.display());
                                    break;

                                case 2:
                                    System.out.println("Coming Soon.");
                                    break;

                                case 3:
                                    System.out.println("Exiting message menu...");
                                    break;

                                default:
                                    System.out.println("Invalid option.");
                            }
                        } while(msgChoice != 3);

                    } else {
                        System.out.println("Username or password incorrect.");
                    }
                    break;

                case 3:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        } while(choice != 3);

        input.close();
    }
}
    