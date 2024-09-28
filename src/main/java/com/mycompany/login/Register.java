/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login;

/**
 *
 * @author RC_Student_lab
 */
public class Register {
 
// Instance variables for username and password
 private String username = "kyl_1";
 private String password = "Ch&&sec@ke99!";
   // Constructor for initializing password and username
    public Register(String username, String password) {
        this.username = username;
        this.password = password;
    }
 
    //Checks if the provided username meets the format requirements.
    public static boolean checkUsername(String username){
     int maxLength = 5;
     return username.contains("_") && username.length() <= maxLength;

}
 //Checks if the provided password meets the complexity requirements.
 public static boolean checkPasswordComplexity(String password){
   // Check for length, uppercase letter, digit, and special character
 return password.length() >= 8 && password.chars().anyMatch(Character::isUpperCase)
         &&  password.chars().anyMatch(Character::isDigit) 
         && password.chars().anyMatch(ch -> ! Character.isLetterOrDigit(ch));
    }
    // Check if both the username and password meet the formatting requirements
   public  static String registerUser (String username, String password){
   
        if (checkUsername(username) && checkPasswordComplexity(password)){
            return  "Username successfully captured.\nPassword successfully captured.";
        }
      return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length. \nPassword is not correctly formatted, please ensure that the password contains at least eight characters, a capital letter, a number and a special character.";
   }
}
