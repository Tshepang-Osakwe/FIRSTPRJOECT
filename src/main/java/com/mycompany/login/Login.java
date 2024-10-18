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
        Register register = new Register(username, password, firstname, lastname);
        
        // Call the method to register the user and print the result
        String registrationResult = Register.registerUser(username, password);
        System.out.println(registrationResult);
        
     
        // Prompt the user for login credentials
        System.out.println("Please log in:");
        System.out.println("Enter your username:");
        String loginUsername = take_input.nextLine();
        
        System.out.println("Enter your password:");
        String loginPassword = take_input.nextLine();
        
        // Verify the login credentials and print the login status
       
       String loginStatus = register.returnLoginStatus(loginUsername, loginPassword);
        System.out.println(loginStatus);
    }
   

}
