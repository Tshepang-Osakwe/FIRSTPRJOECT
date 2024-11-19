package com.mycompany.login;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
    }

    @Test
    public void testCheckPasswordComplexity() {
        System.out.println("checkPasswordComplexity");
        String password = "Ch&&sec@ke99!";
        boolean expResult = true;
        boolean result = Register.checkPasswordComplexity(password);
        assertEquals(expResult, result);
    }

    @Test
    public void testRegisterUser() {
        System.out.println("registerUser");
        String username = "kyl_1";
        String password = "Ch&&sec@ke99!";
        String firstname = "Kyle";
        String lastname = "Smith";
        String expResult = "Username successfully captured.\nPassword successfully captured.";
        String result = Register.registerUser(username, password, firstname, lastname);
        assertEquals(expResult, result);
    }

    @Test
    public void testLoginUser() {
        System.out.println("loginUser");
        String username = "kyl_1";
        String password = "Ch&&sec@ke99!";
        Register.registerUser(username, password, "Kyle", "Smith");
        boolean expResult = true;
        boolean result = Register.loginUser(username, password);
        assertEquals(expResult, result);
    }

    @Test
    public void testReturnLoginStatus() {
        System.out.println("returnLoginStatus");
        String username = "kyl_1";
        String password = "Ch&&sec@ke99!";
        String firstname = "Kyle";
        String lastname = "Smith";

        Register.registerUser(username, password, firstname, lastname);
        String expResult = "Welcome " + firstname + " " + lastname + ", it is great to see you again.";
        String result = Register.returnLoginStatus(username, password);
        assertEquals(expResult, result);
    }
}
