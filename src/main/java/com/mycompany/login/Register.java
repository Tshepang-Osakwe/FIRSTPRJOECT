package com.mycompany.login;

public class Register {
    private static String registeredUsername = null;
    private static String registeredPassword = null;
    private static String firstname = null;
    private static String lastname = null;

    // Method to validate and register user
    public static String registerUser(String username, String password, String firstName, String lastName) {
        if (!checkUsername(username)) {
            return "Invalid username format.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password does not meet complexity requirements.";
        }
        registeredUsername = username;
        registeredPassword = password;
        firstname = firstName;
        lastname = lastName;
        return "Username successfully captured.\nPassword successfully captured.";
    }

    // Check username validity
    public static boolean checkUsername(String username) {
        return username.matches("[a-zA-Z0-9_]+");
    }

    // Check password complexity
    public static boolean checkPasswordComplexity(String password) {
        return password.matches(".*[A-Z].*") && password.matches(".*[a-z].*") &&
               password.matches(".*\\d.*") && password.matches(".*[!@#$%^&*()].*");
    }

    // Verify login credentials
    public static boolean loginUser(String username, String password) {
        return username.equals(registeredUsername) && password.equals(registeredPassword);
    }

    // Return login status
    public static String returnLoginStatus(String username, String password) {
        if (loginUser(username, password)) {
            return "Welcome " + firstname + " " + lastname + ", it is great to see you again.";
        }
        return "Login failed.";
    }
}
