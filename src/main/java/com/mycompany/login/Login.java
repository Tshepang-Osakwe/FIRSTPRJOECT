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

            // Attempt to register the user
            registrationResult = Register.registerUser(username, password, firstname, lastname);
            System.out.println(registrationResult);

            if (registrationResult.contains("successfully")) {
                break;
            } else {
                System.out.println("Registration failed! Please try again.");
                System.exit(0); // Exit the program immediately if registration fails
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
                    "Select an option:\n1) Add Tasks\n2) Show Report\n3) Quit");

            if (menuOption == null) { // Handle cancellation
                JOptionPane.showMessageDialog(null, "Exiting application.");
                System.exit(0);
            }

            switch (menuOption) {
                case "1":
                    Task.addTasks(); // Add tasks
                    break;
                case "2":
                    String reportOption = JOptionPane.showInputDialog(null,
                            "Select a report option:\n1) Display 'Done' Tasks\n2) Longest Task\n3) Search by Task Name\n4) Search by Developer\n5) Delete a Task\n6) Full Task Report");

                    if (reportOption == null) {
                        JOptionPane.showMessageDialog(null, "Returning to main menu.");
                        continue;
                    }

                    switch (reportOption) {
                        case "1":
                            Task.displayDoneTasks();
                            break;
                        case "2":
                            Task.displayLongestTask();
                            break;
                        case "3":
                            String searchName = JOptionPane.showInputDialog("Enter Task Name to Search:");
                            if (searchName != null) {
                                Task.searchTaskByName(searchName);
                            }
                            break;
                        case "4":
                            String searchDev = JOptionPane.showInputDialog("Enter Developer Name to Search:");
                            if (searchDev != null) {
                                Task.searchTasksByDeveloper(searchDev);
                            }
                            break;
                        case "5":
                            String deleteName = JOptionPane.showInputDialog("Enter Task Name to Delete:");
                            if (deleteName != null) {
                                Task.deleteTask(deleteName);
                            }
                            break;
                        case "6":
                            Task.displayTaskReport();
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Invalid option! Returning to main menu.");
                    }
                    break;
                case "3":
                    JOptionPane.showMessageDialog(null, "Exiting application. Total task hours: " + Task.returnTotalHours() + " hours.");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option! Please select again.");
            }
        }
    }
}

// Placeholder Register class for validation
class Register {
    public static String registerUser(String username, String password, String firstname, String lastname) {
        // Simulated registration logic
        if (username != null && password != null && !username.isEmpty() && !password.isEmpty()) {
            return "User registered successfully!";
        }
        return "Registration failed. Invalid input.";
    }

    public static boolean loginUser(String username, String password) {
        // Simulated login validation
        return username.equals("testUser") && password.equals("testPass");
    }
}
