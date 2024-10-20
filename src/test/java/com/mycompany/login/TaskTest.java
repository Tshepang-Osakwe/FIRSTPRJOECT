/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.login;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */
public class TaskTest {
    
    public TaskTest() {
    }
    
   

    /**
     * Test of checkTaskDescription method, of class Task.
     */
    @Test
    public void testCheckTaskDescription() {
         // Create a task with a valid description (under 50 characters)
        Task validTask = new Task("Login Feature", "Create login to authenticate users", "Robyn Harrison", 8, "To Do");
        assertTrue(validTask.checkTaskDescription(), "Expected description to be valid and under 50 characters.");
        
        // Create a task with an invalid description (more than 50 characters)
        Task invalidTask = new Task("Add Task Feature", "This is a very long task description that exceeds fifty characters.", "Mike Smith", 10, "Doing");
        assertFalse(invalidTask.checkTaskDescription(), "Expected description to be invalid and exceed 50 characters.");
        // TODO review the generated test code and remove the default call to fail.
     
    }

    /**
     * Test of createTaskID method, of class Task.
     */
    @Test
    public void testCreateTaskID() {
       // Task 1: "Login Feature" by "Robyn Harrison"
        Task task1 = new Task("Login Feature", "Create login to authenticate users", "Robyn Harrison", 8, "To Do");
        String expectedTaskID1 = "LO:0:SON";  // "LO" from Login Feature, task 0, "SON" from Harrison
        assertEquals(expectedTaskID1, task1.createTaskID(), "Task ID should match the expected format.");

        // Task 2: "Add Task Feature" by "Mike Smith"
        Task task2 = new Task("Add Task Feature", "Create Add Task feature to add users", "Mike Smith", 10, "Doing");
        String expectedTaskID2 = "AD:1:ITH";  // "AD" from Add Task Feature, task 1, "ITH" from Smith
        assertEquals(expectedTaskID2, task2.createTaskID(), "Task ID should match the expected format.");
    
     
    }

    /**
     * Test of printTaskDetails method, of class Task.
     */
   

    /**
     * Test of returnTotalHours method, of class Task.
     */
    @Test
    public void testReturnTotalHours() {
           // Reset static variables for testing
        Task.totalHours = 0;
        Task.taskCounter = 0;

        // Task 1: "Login Feature" - 8 hours
        Task task1 = new Task("Login Feature", "Create login to authenticate users", "Robyn Harrison", 8, "To Do");
        
        // Task 2: "Add Task Feature" - 10 hours
        Task task2 = new Task("Add Task Feature", "Create Add Task feature to add users", "Mike Smith", 10, "Doing");

        // Verify the total hours
        int expectedTotalHours = 18;  // 8 + 10
        assertEquals(expectedTotalHours, Task.returnTotalHours(), "Total task hours should be the sum of all task durations.");
    }

    /**
     * Test of addTasks method, of class Task.
     */
      @Test
    public void testPrintTaskDetails() {
        // Task 1: "Login Feature" by "Robyn Harrison"
       // Task 1: "Login Feature" by "Robyn Harrison"
    Task task = new Task("Login Feature", "Create login to authenticate users", "Robyn Harrison", 8, "To Do");
    
    // Print actual output for debugging
    System.out.println("Actual Task Details:\n" + task.printTaskDetails());

    // Expected output
    String expectedDetails = "Task Status: To Do\n" +
                             "Developer: Robyn Harrison\n" +
                             "Task Number: 4\n" +
                             "Task Name: Login Feature\n" +
                             "Task Description: Create login to authenticate users\n" +
                             "Task ID: LO:0:SON\n" +
                             "Task Duration: 8 hours";

    // Assert that the expected and actual values match
    assertEquals(expectedDetails, task.printTaskDetails());
}
    
}
