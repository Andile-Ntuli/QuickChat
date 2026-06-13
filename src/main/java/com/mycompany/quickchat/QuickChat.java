/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.quickchat;

import java.util.Scanner;
import org.json.simple.JSONArray;

public class QuickChat {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Login login = new Login();

        System.out.println("=== QuickChat ===");
        System.out.print("First name: ");
        String fName = sc.nextLine();
        System.out.print("Last name: ");
        String lName = sc.nextLine();
        System.out.print("Username: ");
        String u = sc.nextLine();
        System.out.print("Password: ");
        String p = sc.nextLine();
        System.out.print("Cell (+27...): ");
        String c = sc.nextLine();

        System.out.println(login.registerUser(fName, lName, u, p, c));

        if (login.loginUser(u, p)) {
            System.out.println(login.returnLoginStatus(true));
            int choice;
            do {
                System.out.println("\nMain Menu → 1) Send Message  2) Stored Messages  3) Quit");
                choice = sc.nextInt();
                sc.nextLine(); // consume newline

                if (choice == 1) {
                    System.out.print("Enter ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter recipient: ");
                    String r = sc.nextLine();
                    System.out.print("Enter message: ");
                    String t = sc.nextLine();
                    Message msg = new Message(id, r, t);

                    System.out.print("Choose action (send/store/disregard): ");
                    String action = sc.nextLine();
                    System.out.println(msg.sendMessage(action));

                } else if (choice == 2) {
                    System.out.println("Stored Menu → a) Longest  b) Search by ID  c) Search by recipient  d) Delete by hash  e) Report");
                    String sub = sc.nextLine();
                    switch (sub) {
                        case "a":
                            System.out.println("Longest stored message: " + Message.longestMessage());
                            break;
                        case "b":
                            System.out.print("Enter ID: ");
                            System.out.println(Message.findByID(sc.nextLine()));
                            break;
                        case "c":
                            System.out.print("Enter recipient: ");
                            JSONArray results = Message.findByRecipient(sc.nextLine());
                            System.out.println("Messages: " + results);
                            break;
                        case "d":
                            System.out.print("Enter hash: ");
                            System.out.println(Message.deleteByHash(sc.nextLine()));
                            break;
                        case "e":
                            Message.showReport();
                            break;
                        default:
                            System.out.println("Invalid option.");
                    }
                }
            } while (choice != 3);
            System.out.println("Goodbye!");
        } else {
            System.out.println(login.returnLoginStatus(false));
        }

        sc.close();
    }
}
