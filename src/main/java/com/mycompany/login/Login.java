/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.login;
import java.util.*;
/**
 *
 * @author RC_Student_lab
 */
public class Login {
      // Static variables to hold the registered username and password
    private static String registeredUsername;
    private static String registeredPassword;
    
    public static void main(String[] args) {
         // Created a scanner object to take input from the user
             Scanner take_input = new Scanner(System.in) ;
   
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
        Register register = new Register(username, password);
        
        // Call the method to register the user and print the result
        String result = register.registerUser(username, password);
        System.out.println(result);
        
       
        // If registration is successful, store the registered username and password
       
 // Call the method and print the return value to verify login status
       System.out.println(returnLoginStatus(username, password));
      
    }
     public static boolean loginUser(String username, String password) {
        // Debugging: Print out the values being compared
      /*  System.out.println("Attempting login with:");
        System.out.println("Entered Username: " + username);
        System.out.println("Entered Password: " + password);
        System.out.println("Registered Username: " + registeredUsername);
        System.out.println("Registered Password: " + registeredPassword);*/

        // Check if the entered username and password match the registered ones
        return registeredUsername.equals(username) && registeredPassword.equals(password);
    }


    //  Returns a message indicating the login status based on the provided username and password.
   public static String returnLoginStatus(String username, String password) {
        // Check if the login details are correct and return appropriate message
        if (loginUser(username, password)) {
            return "Welcome " + username + ", it is great to see you again.";
        }
        else{
            return "Username or password incorrect, please try again.";
        }
   }

}