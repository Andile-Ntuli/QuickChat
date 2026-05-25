/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickchat;

/**
 *
 * @author junio
 */
public class Message {
    String messageID;
    String recipient;
    String messageText;
    int numSent;

    public Message(String id, String rec, String text, int num) {
        this.messageID = id;
        this.recipient = rec;
        this.messageText = text;
        this.numSent = num;
    }

    public String display() {
        return "Message ID: " + messageID +
               "\nRecipient: " + recipient +
               "\nMessage: " + messageText +
               "\nTotal Sent: " + numSent;
    }

    public String sendMessage() {
        if(messageText.length() > 250) {
            return "Message too long!";
        }
        return "Message sent.";
    }
}
    

