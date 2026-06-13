/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.quickchat;

import org.json.simple.JSONArray;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {

    @BeforeEach
    public void setup() {
        Message.reset(); // clear JSON arrays before each test
    }

    @Test
    public void testSendMessagesArray() {
        Message m1 = new Message("QB1", "+27834557896", "Did you get the cake?");
        Message m2 = new Message("QB2", "+27838845657", "It is dinner time!");
        assertEquals("Message sent!", m1.sendMessage("send"));
        assertEquals("Message sent!", m2.sendMessage("send"));
        assertEquals(2, Message.returnTotalMessages());
        assertTrue(Message.findByID("QB1").contains("Did you get the cake?"));
        assertTrue(Message.findByID("QB2").contains("It is dinner time!"));
    }

    @Test
    public void testLongestMessage() {
        Message m1 = new Message("QB3", "+27838845657", "Short msg");
        Message m2 = new Message("QB4", "+27838845657", "Where are you? You are late! I have asked you to be on time.");
        m1.sendMessage("store");
        m2.sendMessage("store");
        assertEquals("Where are you? You are late! I have asked you to be on time.", Message.longestMessage());
    }

    @Test
    public void testFindByID() {
        Message m = new Message("QB5", "0433884567", "It is dinner time!");
        m.sendMessage("store");
        String result = Message.findByID("QB5");
        assertTrue(result.contains("It is dinner time!"));
    }

    @Test
    public void testFindByRecipient() {
        Message m1 = new Message("QB6", "+27838845657", "Where are you? You are late! I have asked you to be on time.");
        Message m2 = new Message("QB7", "+27838845657", "OK, I am leaving without you.");
        m1.sendMessage("store");
        m2.sendMessage("store");
        JSONArray results = Message.findByRecipient("+27838845657");
        assertTrue(results.contains("Where are you? You are late! I have asked you to be on time."));
        assertTrue(results.contains("OK, I am leaving without you."));
    }

    @Test
    public void testDeleteByHash() {
        Message m = new Message("QB8", "+27838845657", "Where are you? You are late! I have asked you to be on time.");
        m.sendMessage("store");
        String hash = m.makeHash();
        String result = Message.deleteByHash(hash);
        assertTrue(result.contains("successfully deleted"));
        assertEquals("No stored messages yet.", Message.longestMessage());
    }

    @Test
    public void testMaximumLimit() {
        for (int i = 0; i < 100; i++) {
            Message m = new Message("ID" + i, "+2783000000", "Msg " + i);
            assertEquals("Message sent!", m.sendMessage("send"));
        }
        Message extra = new Message("ID101", "+2783000000", "Overflow");
        assertEquals("Sent messages full!", extra.sendMessage("send"));
    }
}
