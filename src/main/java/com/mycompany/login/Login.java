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
    
 public static boolean checkUsername(String username){
     
     int maxLength = 5;
     return username.contains("_") && username.length() <= maxLength;

}
 
 public static boolean checkPasswordComplexity(String password){
 return password.length() >= 8 && password.chars().anyMatch(Character::isUpperCase) &&  password.chars().anyMatch(Character::isDigit) && password.chars().anyMatch(ch -> ! Character.isLetterOrDigit(ch));
    }
   public  static String registerUser (String username, String password){
        if (!checkUsername(username)){
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length";
        }
        else{
            return "Username successfully captured.";
        }
   
        if(checkPasswordComplexity(password)){
            return "Password successfully captured.";
        }
        else{
            return "Password is not correctly formatted, please ensure that the password contains at least eight characters, a capital letter, a number and a special character. ";
        }
   }
   
   
 }
        