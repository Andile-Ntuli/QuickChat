/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.quickchat;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author A.Ntuli
 */
public class TestQuicKChat { 
    
      // checking username rule
    @Test
    public void testUserNameOk() {
        Login l = new Login("Andile", "Ntuli", "an_", "Pass123!", "+27649963977");
        assertTrue(l.checkUserName());
    }
    
    @Test
    public void testUserNameFail() {
        Login l = new Login("Andile", "Ntuli", "andile", "Pass123!", "+27649963977");
        assertFalse(l.checkUserName());
    }
    
    // password tests
    @Test
    public void testPasswordGood() {
        Login l = new Login("Andile", "Ntuli", "an_", "Pass123!", "+27649963977");
        assertTrue(l.checkPasswordComplexity());
    }
    
    @Test
    public void testPasswordNoNum() {
        Login l = new Login("Andile", "Ntuli", "an_", "Password!", "+27649963977");
        assertFalse(l.checkPasswordComplexity());
    }
    
    @Test
    public void testPasswordNoSpecial() {
        Login l = new Login("Andile", "Ntuli", "an_", "Password1", "+27649963977");
        assertFalse(l.checkPasswordComplexity());
    }
    
    // cell number tests
    @Test
    public void testCellGood() {
        Login l = new Login("Andile", "Ntuli", "an_", "Pass123!", "+27649963977");
        assertTrue(l.checkCellPhoneNumber());
    }
    
    @Test
    public void testCellBad() {
        Login l = new Login("Andile", "Ntuli", "an_", "Pass123!", "0649963977");
        assertFalse(l.checkCellPhoneNumber());
    }
    
    // login tests
    @Test
    public void testLoginOk() {
        Login l = new Login("Andile", "Ntuli", "an_", "Pass123!", "+27649963977");
        assertTrue(l.loginUser("an_", "Pass123!"));
    }
    
    @Test
    public void testLoginWrong() {
        Login l = new Login("Andile", "Ntuli", "an_", "Pass123!", "+27649963977");
        assertFalse(l.loginUser("wrong", "Pass123!"));
    }
    
    // login message tests
    @Test
    public void testLoginMsgOk() {
        Login l = new Login("Andile", "Ntuli", "an_", "Pass123!", "+27649963977");
        String msg = l.returnLoginStatus(true);
        assertTrue(msg.contains("Welcome"));
    }
    
    @Test
    public void testLoginMsgFail() {
        Login l = new Login("Andile", "Ntuli", "an_", "Pass123!", "+27649963977");
        String msg = l.returnLoginStatus(false);
        assertEquals("Username or password incorrect, please try again.", msg);
    }
}   
  // JUnit testing is basically a way of checking whether your Java code actually  works the way you
// epected it to, without ahaving to the whole program everytime.Instead of typing inputsand guessing if
// your methods behave correctly, you write small automated tests that call your methods amd compare the actual
// results to the  result you expecte.      
    
    

