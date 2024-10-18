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
 private String username;
 private String password;
 private String firstname;
 private String lastname;
  // Static variables to hold the registered username,password, first and lastname
    private static String registeredUsername;
    private static String registeredPassword;
        private static String registeredFirstname; 
            private static String registeredLastname; 
   // Constructor for initializing password and username
    public Register(String username, String password, String firstname,String lastname ) {
         this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
       
    }
  
    // Getter for registeredUsername
    public static String getRegisteredUsername() {
        return registeredUsername;
    }

    // Setter for registeredUsername
    public static void setRegisteredUsername(String username) {
        registeredUsername = username;
    }

    // Getter for registeredPassword
    public static String getRegisteredPassword() {
        return registeredPassword;
    }

    // Setter for registeredPassword
    public static void setRegisteredPassword(String password) {
        registeredPassword = password;
    }
    
      // Setter for registeredFirstname (newly added for firstname storage)
    public static void setRegisteredFirstname(String firstname) {
        registeredFirstname = firstname;
    }
      // Setter for registeredFirstname (newly added for firstname storage)
    public static void setRegisteredLastname(String lastname) {
        registeredLastname = lastname;
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
 
   // Register the user if the username and password meet the requirements
    public static String registerUser(String username, String password) {
        if (checkUsername(username) && checkPasswordComplexity(password)) {
            setRegisteredUsername(username);
            setRegisteredPassword(password);
            return "Username successfully captured.\nPassword successfully captured.";
        }
        return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length. \nPassword is not correctly formatted, please ensure that the password contains at least eight characters, a capital letter, a number and a special character.";
    }

    
     public static boolean loginUser(String username, String password) {
        return registeredUsername != null && registeredPassword != null 
                && registeredUsername.equals(username) 
                && registeredPassword.equals(password);
    }


    //  Returns a message indicating the login status based on the provided username and password.
   public  String returnLoginStatus(String username, String password) {
        // Check if the login details are correct and return appropriate message
        if (loginUser(username, password)) {
            return  "Welcome " + this.firstname + " " + this.lastname + ", it is great to see you again.";
        }
        else{
            return "Username or password incorrect, please try again.";
        }
   }
}
