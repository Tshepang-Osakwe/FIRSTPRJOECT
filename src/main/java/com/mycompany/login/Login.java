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
   
    checkUsername(username);
    checkPasswordComplexity(password);
    }
    
 public static void checkUsername(String username){
  if(username.contains("_" ) && username.length()< 5)
      System.out.println("Username successfully captured.");
      
 else {
    //error message
    System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.");
}
}
 
 public static void checkPasswordComplexity(String password){
     if (password.length()<8 && password.matches(".[A-Z].") && password.matches(".\\d.") && password.matches("^a-zA-Z0=9"))
         System.out.println("Password successfully captured.");
         
         else{
                 System.out.println("Password is not correctly formatted, please ensure that the password contains at least eight characters, a capital letter, a number and a special character. ");
                 
     }
 
 }
}
        