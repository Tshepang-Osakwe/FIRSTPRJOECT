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
    }
    
   
}
