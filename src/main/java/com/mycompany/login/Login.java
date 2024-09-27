/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.login;
import java.util.*;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author RC_Student_lab
 */
public class Login {
      // Static map to store usernames and passwords for registered users
private static Map<String, String> userDatabase = new HashMap<>();
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
        
          // Test login
        System.out.println(returnLoginStatus(username, password));

      
    }
    // Check if the login details are correct and return appropriate message
public static boolean loginUser(String username, String password) {
     // Check if the username exists in the user database and if the password matches
        return userDatabase.containsKey(username) && userDatabase.get(username).equals(password);
    }
    //  Returns a message indicating the login status based on the provided username and password.
    public static String returnLoginStatus(String username, String password) {
         // Check if the login details are correct and return appropriate message
        if (loginUser(username, password)) {
            return "Welcome" + username + "it is great to see you again."  ;
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
   
   
 }
        