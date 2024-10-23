/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.login;
import java.util.*;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author RC_Student_lab
 */
public class Login {
     
    
    public static void main(String[] args) {
        // Created a scanner object to take input from the user
             Scanner take_input = new Scanner(System.in) ;
   final JDialog dialog = new JDialog();
   dialog.setAlwaysOnTop(true);
   //Prompt the user for firstname, lastname, username and password
    System.out.println("Enter your firstname:");
    String firstname = take_input.nextLine();
    
    System.out.println("Enter your lastname:");
    String lastname = take_input.nextLine();
    
    System.out.println("Enter your username:");
    String username = take_input.nextLine();
    
    System.out.println("Enter your password:");
    String password = take_input.nextLine();
        
     // Create an instance of Register with the username and password
        Register register = new Register(username, password, firstname, lastname);
        
        // Call the method to register the user and print the result
        String registrationResult = Register.registerUser(username, password);
        System.out.println(registrationResult);
          if (!registrationResult.contains("successfully")) {
            System.out.println("Registration failed. Please check your username and password format.");
            System.exit(0);  // Exit if registration fails
        }
     
        // Prompt the user for login credentials
        System.out.println("Please log in:");
        System.out.println("Enter your username:");
        String loginUsername = take_input.nextLine();
        
        System.out.println("Enter your password:");
        String loginPassword = take_input.nextLine();
        
        // Verify the login credentials and print the login status
       
       String loginStatus = register.returnLoginStatus(loginUsername, loginPassword);
        System.out.println(loginStatus);

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
        dialog.dispose();
    }
}