/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.quickchat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author junio
 */
public class LoginTest {
    
    @BeforeAll
    public static void setUpClass() {}
    
    @AfterAll
    public static void tearDownClass() {}
    
    @BeforeEach
    public void setUp() {}
    
    @AfterEach
    public void tearDown() {}

    @Test
    public void testRegisterUser() {
        System.out.println("registerUser");
        Login l = new Login();
        String result = l.registerUser("Andile", "Ntuli", "Bhu_", "Pass123!", "+27649963977");
        assertTrue(result.contains("successfully"));
    }

    @Test
    public void testLoginUser() {
        System.out.println("loginUser");
        Login l = new Login();
        l.registerUser("Andile", "Ntuli", "Bhu_", "Pass123!", "+27649963977");
        boolean ok = l.loginUser("Bhu_", "Pass123!");
        assertTrue(ok);
    }

    @Test
    public void testReturnLoginStatus() {
        System.out.println("returnLoginStatus");
        Login l = new Login();
        l.registerUser("Andile", "Ntuli", "Bhu_", "Pass123!", "+27649963977");
        l.loginUser("Bhu_", "Pass123!");
        String msg = l.returnLoginStatus();
        assertTrue(msg.contains("Welcome"));
    }
}