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
 * Simple JUnit tests for Login class
 * @author junio
 */
public class LoginTest {
    
    @BeforeAll
    public static void setUpClass() {
        System.out.println("Starting Login tests...");
    }
    
    @AfterAll
    public static void tearDownClass() {
        System.out.println("All Login tests done.");
    }
    
    @BeforeEach
    public void setUp() {
        // runs before each test
    }
    
    @AfterEach
    public void tearDown() {
        // runs after each test
    }

    @Test
    public void testRegisterUser() {
        System.out.println("registerUser");
        Login l = new Login();
        String result = l.registerUser("Andile", "Ntuli", "Bhu_", "Pass123!", "+27649963977");
        assertTrue(result.contains("successfully"), "User should register successfully.");
    }

    @Test
    public void testLoginUserSuccess() {
        System.out.println("loginUser success");
        Login l = new Login();
        l.registerUser("Andile", "Ntuli", "Bhu_", "Pass123!", "+27649963977");
        boolean ok = l.loginUser("an_", "Pass123!");
        assertTrue(ok, "Login should succeed with correct credentials.");
    }

    @Test
    public void testLoginUserFail() {
        System.out.println("loginUser fail");
        Login l = new Login();
        l.registerUser("Andile", "Ntuli", "Bhu_", "Pass123!", "+27649963977");
        boolean ok = l.loginUser("wrong", "wrong");
        assertFalse(ok, "Login should fail with wrong credentials.");
    }

    @Test
    public void testReturnLoginStatus() {
        System.out.println("returnLoginStatus");
        Login l = new Login();
        l.registerUser("Andile", "Ntuli", "Bhu_", "Pass123!", "+27649963977");
        l.loginUser("an_", "Pass123!");
        String msg = l.returnLoginStatus(true);
        assertTrue(msg.contains("Welcome"), "Login status should contain welcome message.");
    }
}
