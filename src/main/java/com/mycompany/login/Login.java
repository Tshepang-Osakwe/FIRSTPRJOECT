package com.mycompany.login;
import java.util.*;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 * Login class for managing user registration, login, and menu interaction.
 * This is the main entry point of the EasyKanban application.
 */
public class Login {  
    public static void main(String[] args) {
        // Created a scanner object to take input from the user
        Scanner take_input = new Scanner(System.in);
        
        // Configure dialog to appear on top for user prompts
        final JDialog dialog = new JDialog();
        dialog.setAlwaysOnTop(true);

        // Prompt the user for registration details: first name, last name, username, and password
        System.out.println("Enter your firstname:");
        String firstname = take_input.nextLine();
        
        System.out.println("Enter your lastname:");
        String lastname = take_input.nextLine();
        
        System.out.println("Enter your username:");
        String username = take_input.nextLine();
        
        System.out.println("Enter your password:");
        String password = take_input.nextLine();
        
        // Register the user by creating an instance of the Register class with the provided details
        Register register = new Register(username, password, firstname, lastname);
        
        // Attempt to register the user and capture the result
        String registrationResult = Register.registerUser(username, password);
        System.out.println(registrationResult);
        
        // If registration fails, inform the user and exit
        if (!registrationResult.contains("successfully")) {
            System.out.println("Registration failed. Please check your username and password format.");
            System.exit(0);  // Exit if registration fails
        }
     
        // Prompt the user for login credentials after successful registration
        System.out.println("Please log in:");
        System.out.println("Enter your username:");
        String loginUsername = take_input.nextLine();
        
        System.out.println("Enter your password:");
        String loginPassword = take_input.nextLine();
        
        // Verify the login credentials and capture the login status
        String loginStatus = register.returnLoginStatus(loginUsername, loginPassword);
        System.out.println(loginStatus);

        // Proceed to main menu if login is successful
        if (loginStatus.startsWith("Welcome")) {
            JOptionPane.showMessageDialog(null, "Welcome to EasyKanban!");

            // Main menu loop for task management
            while (true) {
                // Display menu options to the user
                String menuOption = JOptionPane.showInputDialog(null,
                        "Select an option:\n1) Add Tasks\n2) Show Report (Coming Soon)\n3) Quit");
                
                // Process user selection
                switch (menuOption) {
                    case "1":
                        // Option to add tasks; calls Task class's addTasks method
                        Task.addTasks();
                        break;
                    case "2":
                        // Placeholder for future report functionality
                        JOptionPane.showMessageDialog(null, "Coming Soon");
                        break;
                    case "3":
                        // Exit application and display total hours of all tasks before closing
                        JOptionPane.showMessageDialog(null, "Exiting application. Total task hours: " + Task.returnTotalHours() + " hours.");
                        System.exit(0);
                    default:
                        // Handle invalid menu option
                        JOptionPane.showMessageDialog(null, "Invalid option! Please select again.");
                }
            }
        } else {
            // Inform the user of a failed login and exit
            JOptionPane.showMessageDialog(null, "Login failed! Exiting application.");
            System.exit(0);  // Exit after failed login
        }
        dialog.dispose();  // Close dialog box at the end of the session
    }
}
