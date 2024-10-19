/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.login;

import javax.swing.JOptionPane;

/**
 *
 * @author RC_Student_lab
 */
public class Login {
     
    
    public static void main(String[] args) {
         // Prompt the user for first name, last name, username, and password using JOptionPane
        String firstname = JOptionPane.showInputDialog(null, "Enter your first name:");
        String lastname = JOptionPane.showInputDialog(null, "Enter your last name:");
        String username = JOptionPane.showInputDialog(null, "Enter your username:");
        String password = JOptionPane.showInputDialog(null, "Enter your password:");

        // Create an instance of Register with the username, password, first name, and last name
        Register register = new Register(username, password, firstname, lastname);

        // Call the method to register the user and show the result using JOptionPane
        String registrationResult = Register.registerUser(username, password);
        JOptionPane.showMessageDialog(null, registrationResult);

        // Check if registration was successful before proceeding to login
        if (!registrationResult.contains("successfully")) {
            JOptionPane.showMessageDialog(null, "Registration failed. Please check your username and password format.");
            System.exit(0);  // Exit if registration fails
        }

        // Prompt the user for login credentials using JOptionPane
        String loginUsername = JOptionPane.showInputDialog(null, "Enter your username for login:");
        String loginPassword = JOptionPane.showInputDialog(null, "Enter your password for login:");

        // Verify the login credentials and show the login status using JOptionPane
        String loginStatus = register.returnLoginStatus(loginUsername, loginPassword);
        JOptionPane.showMessageDialog(null, loginStatus);

        // Proceed if login is successful
        if (loginStatus.startsWith("Welcome")) {
            JOptionPane.showMessageDialog(null, "Welcome to EasyKanban!");

            // Main menu loop
            while (true) {
                String menuOption = JOptionPane.showInputDialog(null,
                        "Select an option:\n1) Add Tasks\n2) Show Report (Coming Soon)\n3) Quit");
                switch (menuOption) {
                    case "1":
                        Task.addTasks();  // Call method from Task class to add tasks
                        break;
                    case "2":
                        JOptionPane.showMessageDialog(null, "Coming Soon");
                        break;
                    case "3":
                        JOptionPane.showMessageDialog(null, "Exiting application. Total task hours: " + Task.returnTotalHours() + " hours.");
                        System.exit(0);
                    default:
                        JOptionPane.showMessageDialog(null, "Invalid option! Please select again.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Login failed! Exiting application.");
            System.exit(0);  // Exit after failed login
        }
    }
}