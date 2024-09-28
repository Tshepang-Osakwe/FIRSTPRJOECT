/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.login;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */
public class RegisterTest {
    
    public RegisterTest() {
    }
    
   
    @Test
    public void testCheckUsername() {
        System.out.println("checkUsername");
        String username = "kyl_1";
        boolean expResult = true;
        boolean result = Register.checkUsername(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.  
    }
    /**
     * Test of checkPasswordComplexity method, of class Register.
     */
    @Test
    public void testCheckPasswordComplexity() {
        System.out.println("checkPasswordComplexity");
        String password = "Ch&&sec@ke99!";
        boolean expResult = true;
        boolean result = Register.checkPasswordComplexity(password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail
    }

    /**
     * Test of registerUser method, of class Register.
     */
    @Test
    public void testRegisterUser() {
        System.out.println("registerUser");
        String username = "kyl_1";
        String password = "Ch&&sec@ke99!";
        String expResult = "Username successfully captured.\nPassword successfully captured.";
        String result = Register.registerUser(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
 
    }
    
}
