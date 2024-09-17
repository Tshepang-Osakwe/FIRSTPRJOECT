/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.login;

/**
 *
 * @author RC_Student_lab
 */
public class Login {

    public static void main(String[] args) {
        
    
    }
    public static boolean checkUserName(String UserName){
      String Username;
      boolean results;
        //Check if UserName has no more than 5 characters
        if (UserName.length()>5 && UserName.contains("_")){
            results = true;
        }
        else{
            results = false;
        }
    
    }
}
