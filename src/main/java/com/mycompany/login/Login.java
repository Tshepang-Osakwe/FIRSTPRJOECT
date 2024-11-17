package com.mycompany.login;

import java.util.Scanner;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class Login {
    public static void main(String[] args) {
        Scanner take_input = new Scanner(System.in);
        final JDialog dialog = new JDialog();
        dialog.setAlwaysOnTop(true);

        // Registration process
        String registrationResult;
        while (true) {
            System.out.println("======== Register Your Account ========");
            System.out.println("Enter your firstname: ");
            String firstname = take_input.nextLine();

            System.out.println("Enter your lastname: ");
            String lastname = take_input.nextLine();

            System.out.println("Enter your username: ");
            String username = take_input.nextLine();

            System.out.println("Enter your password: ");
            String password = take_input.nextLine();

            // Attempt to register the user using the updated Register class
            registrationResult = Register.registerUser(username, password, firstname, lastname);
            System.out.println(registrationResult);

            // Exit or break based on registration success
            if (registrationResult.contains("successfully")) {
                break;
            } else {
                System.out.println("Registration failed! Please try again.");
                System.exit(0);  // Exit the program immediately if registration fails
            }
        }

        // Login process
        System.out.println("======== Log In to Your Account ========");
        while (true) {
            System.out.print("Enter your username: ");
            String loginUsername = take_input.nextLine();

            System.out.print("Enter your password: ");
            String loginPassword = take_input.nextLine();

            // Validate login credentials
            if (Register.loginUser(loginUsername, loginPassword)) {
                System.out.println("Login successful!");
                JOptionPane.showMessageDialog(null, "Welcome to EasyKanban!");
                break;
            } else {
                System.out.println("Login failed. Please try again.");
            }
        }

        // Main menu
        while (true) {
            String menuOption = JOptionPane.showInputDialog(null,
                    "Select an option:\n1) Add Tasks\n2) Show Report (Coming Soon)\n3) Quit");

            switch (menuOption) {
                case "1":
                    Task.addTasks();  // Call method to add tasks
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null, "Coming Soon");
                    break;
                case "3":
                    JOptionPane.showMessageDialog(null, "Exiting application. Total task hours: " + Task.returnTotalHours() + " hours.");
                    System.exit(0);  // Exit the program
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option! Please select again.");
            }
        }
    }
}
