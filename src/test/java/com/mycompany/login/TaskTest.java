/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.login;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

/**
 *
 * @author RC_Student_lab
 */
public class TaskTest {
    
      @BeforeEach
       // Reset taskCounter anf totalHours before each test
    public void setUp() {
        Task.taskCounter = 0; 
        Task.totalHours = 0;
    }
   
    /**
     * Test of checkTaskDescription method, of class Task.
     */
    @Test
  
public void testCheckTaskDescription() {
    // Create a task with a valid description (under 50 characters)
    Task validTask = new Task("Login Feature", "Create login to authenticate users", "Robyn Harrison", 8, "To Do");
    // Assert that the description is valid (true)
    boolean expectedValidResult = true;
    boolean actualValidResult = validTask.checkTaskDescription();
    assertEquals(expectedValidResult, actualValidResult, "Expected description to be valid and under 50 characters.");

    // Create a task with an invalid description (more than 50 characters)
    Task invalidTask = new Task("Add Task Feature", "This is a very long task description that exceeds fifty characters.", "Mike Smith", 10, "Doing");
    // Assert that the description is invalid (false)
    boolean expectedInvalidResult = false;
    boolean actualInvalidResult = invalidTask.checkTaskDescription();
    assertEquals(expectedInvalidResult, actualInvalidResult, "Expected description to be invalid and exceed 50 characters.");
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

    

    @Test
    public void testPrintTaskDetails() {
        // Create an instance of Task
        Task task1 = new Task("Login Feature", "Create login to authenticate users", "Robyn Harrison", 8, "To Do");

        // Generate the expected output based on current logic
        String expectedDetails = "Task Status: To Do\n" +
                                 "Developer: Robyn Harrison\n" +
                                 "Task Number: 0\n" +
                                 "Task Name: Login Feature\n" +
                                 "Task Description: Create login to authenticate users\n" +
                                 "Task ID: LO:0:SON\n" +  // Verify if this matches the actual ID format
                                 "Task Duration: 8 hours";

        // Capture actual output from printTaskDetails
        String actualDetails = task1.printTaskDetails();

        // Debug output
        System.out.println("Expected Output:\n" + expectedDetails);
        System.out.println("Actual Output:\n" + actualDetails);

        // Use assertEquals to check if actual output matches expected output
        assertEquals(expectedDetails, actualDetails, "Task details for task1 should match the expected output.");
    }
  




    @Test
    void testArrayPopulation() {
        // Clear static task list
        Task.tasks.clear();
        Task.totalHours = 0;

        Task task1 = new Task("Task 1", "Description 1", "Developer A", 5, "To Do");
        Task task2 = new Task("Task 2", "Description 2", "Developer B", 8, "Doing");
        Task task3 = new Task("Task 3", "Description 3", "Developer C", 2, "Done");

        Task.tasks.add(task1);
        Task.tasks.add(task2);
        Task.tasks.add(task3);

        ArrayList<String> developers = new ArrayList<>();
        ArrayList<String> taskNames = new ArrayList<>();
        ArrayList<String> taskStatuses = new ArrayList<>();
        ArrayList<Integer> taskDurations = new ArrayList<>();

        for (Task task : Task.tasks) {
            developers.add(task.developerDetails);
            taskNames.add(task.taskName);
            taskStatuses.add(task.taskStatus);
            taskDurations.add(task.taskDuration);
        }

        assertEquals(3, developers.size(), "Developer array size is incorrect");
        assertTrue(developers.contains("Developer A"), "Developer A is missing");
        assertTrue(taskNames.contains("Task 1"), "Task 1 is missing");
        assertTrue(taskStatuses.contains("Done"), "'Done' status is missing");
        assertEquals(15, taskDurations.stream().mapToInt(Integer::intValue).sum(), "Total duration is incorrect");
    }

    @Test
    void testDisplayDoneTasks() {
        // Clear static task list
        Task.tasks.clear();

        Task task1 = new Task("Task A", "Short task", "Alice Bobson", 5, "Done");
        Task task2 = new Task("Task B", "Another task", "Charlie Dan", 7, "To Do");

        Task.tasks.add(task1);
        Task.tasks.add(task2);

        long doneTasksCount = Task.tasks.stream()
                .filter(task -> "Done".equalsIgnoreCase(task.taskStatus))
                .count();

        assertEquals(1, doneTasksCount, "Count of 'Done' tasks is incorrect");
    }

    @Test
    void testLongestTask() {
        Task.tasks.clear();
        Task task1 = new Task("Task X", "Short task", "John Doe", 3, "To Do");
        Task task2 = new Task("Task Y", "Longer task", "Jane Smith", 10, "Doing");

        Task.tasks.add(task1);
        Task.tasks.add(task2);

        Task longestTask = Task.tasks.stream()
                .max((t1, t2) -> Integer.compare(t1.taskDuration, t2.taskDuration))
                .orElse(null);

        assertNotNull(longestTask, "Longest task should not be null");
        assertEquals("Task Y", longestTask.taskName, "Longest task is incorrect");
    }

    @Test
    void testSearchTaskByName() {
        Task.tasks.clear();
        Task task1 = new Task("Login Feature", "Create Login", "Alice Bobson", 8, "To Do");
        Task task2 = new Task("Add Feature", "Create Add Task feature", "Mike Smith", 10, "Doing");

        Task.tasks.add(task1);
        Task.tasks.add(task2);

        boolean found = Task.tasks.stream()
                .anyMatch(task -> task.taskName.equalsIgnoreCase("Login Feature"));

        assertTrue(found, "Task search by name failed for an existing task");

        found = Task.tasks.stream()
                .anyMatch(task -> task.taskName.equalsIgnoreCase("Nonexistent Task"));

        assertFalse(found, "Task search by name incorrectly found a non-existent task");
    }

    @Test
    void testSearchTasksByDeveloper() {
        Task.tasks.clear();
        Task task1 = new Task("Task 1", "First task", "Nancy Drew", 4, "To Do");
        Task task2 = new Task("Task 2", "Second task", "Nancy Drew", 6, "Done");

        Task.tasks.add(task1);
        Task.tasks.add(task2);

        long developerTasks = Task.tasks.stream()
                .filter(task -> "Nancy Drew".equalsIgnoreCase(task.developerDetails))
                .count();

        assertEquals(2, developerTasks, "Search by developer failed");
    }

    @Test
    void testDeleteTask() {
        Task.tasks.clear();
        Task task1 = new Task("Task Delete", "Task to delete", "Peter Parker", 8, "To Do");
        Task.tasks.add(task1);

        Task.deleteTask("Task Delete");

        boolean exists = Task.tasks.stream()
                .anyMatch(task -> "Task Delete".equalsIgnoreCase(task.taskName));

        assertFalse(exists, "Task deletion failed");
    }

    @Test
    void testDisplayTaskReport() {
        Task.tasks.clear();
        Task task1 = new Task("Task R1", "First task", "Developer X", 4, "To Do");
        Task task2 = new Task("Task R2", "Second task", "Developer Y", 6, "Done");

        Task.tasks.add(task1);
        Task.tasks.add(task2);

        StringBuilder report = new StringBuilder();
        for (Task task : Task.tasks) {
            report.append(task.printTaskDetails()).append("\n");
        }

        assertTrue(report.toString().contains("Developer X"), "Developer X details are missing in the report");
        assertTrue(report.toString().contains("Developer Y"), "Developer Y details are missing in the report");
    }
}

