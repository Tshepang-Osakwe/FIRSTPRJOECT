/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author RC_Student_lab
 */
public class Register {
private static Map<String, String> userDatabase = new HashMap<>();
    
    
    
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
   
        if (checkPasswordComplexity(password)){
           return "Password is not correctly formatted, please ensure that the password contains at least eight characters, a capital letter, a number and a special character.";
        }
     
       userDatabase.put(username, password);
       return  "Username successfully captured."
               + "Password successfully captured.";
   }
}
