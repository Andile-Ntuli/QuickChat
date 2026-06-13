/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

// Message handles sending, storing, searching, deleting
package com.mycompany.quickchat;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Message {

    private String id;
    private String recipient;
    private String text;
    private String hash;

    // JSON arrays
    private static JSONArray sent = new JSONArray();
    private static JSONArray stored = new JSONArray();
    private static JSONArray disregarded = new JSONArray();
    private static JSONArray hashes = new JSONArray();
    private static JSONArray ids = new JSONArray();

    // Maximums
    private static final int MAX_MESSAGES = 100;

    public Message(String id, String recipient, String text) {
        this.id = id;
        this.recipient = recipient;
        this.text = text;
        this.hash = makeHash();
        if (ids.size() < MAX_MESSAGES) ids.add(id);
        if (hashes.size() < MAX_MESSAGES) hashes.add(hash);
    }

    // Build a simple hash
    public String makeHash() {
        String[] words = text.split(" ");
        return id.substring(0,2) + ":" + words[0].toUpperCase() + words[words.length-1].toUpperCase();
    }

    // Convert this message into a JSON object
    public JSONObject toJSON() {
        JSONObject obj = new JSONObject();
        obj.put("id", id);
        obj.put("recipient", recipient);
        obj.put("text", text);
        obj.put("hash", hash);
        return obj;
    }

    // Decide what to do with the message
    public String sendMessage(String option) {
        JSONObject obj = toJSON();
        switch(option.toLowerCase()) {
            case "send":
                if (sent.size() < MAX_MESSAGES) {
                    sent.add(obj);
                    return "Message sent!";
                }
                return "Sent messages full!";
            case "store":
                if (stored.size() < MAX_MESSAGES) {
                    stored.add(obj);
                    return "Message stored for later.";
                }
                return "Stored messages full!";
            case "disregard":
                if (disregarded.size() < MAX_MESSAGES) {
                    disregarded.add(obj);
                    return "Message disregarded.";
                }
                return "Disregarded messages full!";
            default:
                return "Invalid choice.";
        }
    }

    // Return total messages (sent + stored + disregarded)
    public static short returnTotalMessages() {
        return (short)(sent.size() + stored.size() + disregarded.size());
    }

    // Show longest stored message
    public static String longestMessage() {
        String longest = "";
        for (Object o : stored) {
            JSONObject m = (JSONObject) o;
            String txt = (String) m.get("text");
            if (txt.length() > longest.length()) {
                longest = txt;
            }
        }
        return longest.isEmpty() ? "No stored messages yet." : longest;
    }

    // Search by ID across both sent and stored
    public static String findByID(String id) { 
        for (Object o : stored) {
            JSONObject m = (JSONObject) o;
            if (id.equals(m.get("id"))) {
                return "Recipient: " + m.get("recipient") + " | Message: " + m.get("text");
            }
        }
        for (Object o : sent) {
            JSONObject m = (JSONObject) o;
            if (id.equals(m.get("id"))) {
                return "Recipient: " + m.get("recipient") + " | Message: " + m.get("text");
            }
        }
        return "Message ID not found.";
    }

    // Search by recipient across both sent and stored
    public static JSONArray findByRecipient(String recipient) {
        JSONArray results = new JSONArray();
        for (Object o : stored) {
            JSONObject m = (JSONObject) o;
            if (recipient.equals(m.get("recipient"))) {
                results.add(m.get("text"));
            }
        }
        for (Object o : sent) {
            JSONObject m = (JSONObject) o;
            if (recipient.equals(m.get("recipient"))) {
                results.add(m.get("text"));
            }
        }
        if (results.isEmpty()) {
            results.add("No messages for that recipient.");
        }
        return results;
    }

    // Delete by hash (only makes sense for stored)
    public static String deleteByHash(String hash) {
        for (int i = 0; i < stored.size(); i++) {
            JSONObject m = (JSONObject) stored.get(i);
            if (hash.equals(m.get("hash"))) {
                String deleted = (String) m.get("text");
                stored.remove(i);
                return "Message: \"" + deleted + "\" successfully deleted.";
            }
        }
        return "No message with that hash.";
    }

    // Report of all stored + sent messages
    public static void showReport() {
        System.out.println("=== Messages Report ===");
        for (Object o : stored) {
            JSONObject m = (JSONObject) o;
            System.out.println("[STORED] ID: " + m.get("id") + " | Hash: " + m.get("hash") +
                               " | Recipient: " + m.get("recipient") + " | Text: " + m.get("text"));
        }
        for (Object o : sent) {
            JSONObject m = (JSONObject) o;
            System.out.println("[SENT] ID: " + m.get("id") + " | Hash: " + m.get("hash") +
                               " | Recipient: " + m.get("recipient") + " | Text: " + m.get("text"));
        }
    }

    // Reset method for unit tests
    public static void reset() {
        sent.clear();
        stored.clear();
        disregarded.clear();
        hashes.clear();
        ids.clear();
    }
}
