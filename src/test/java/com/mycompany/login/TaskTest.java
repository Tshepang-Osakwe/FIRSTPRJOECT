package com.mycompany.login;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class TaskTest {

    @BeforeEach
    public void setUp() {
        Task.taskCounter = 0; 
        Task.totalHours = 0;
        Task.tasks.clear();  // Clear static task list before each test
    }

    @Test
    public void testCheckTaskDescription() {
        Task validTask = new Task("Login Feature", "Create login to authenticate users", "Robyn Harrison", 8, "To Do");
        assertEquals(true, validTask.checkTaskDescription(), "Expected description to be valid.");

        Task invalidTask = new Task("Add Task Feature", "This is a very long task description that exceeds fifty characters.", "Mike Smith", 10, "Doing");
        assertEquals(false, invalidTask.checkTaskDescription(), "Expected description to be invalid.");
    }

    @Test
    public void testCreateTaskID() {
        Task task1 = new Task("Login Feature", "Create login to authenticate users", "Robyn Harrison", 8, "To Do");
        assertEquals("LO:0:SON", task1.createTaskID(), "Task ID should match the expected format.");

        Task task2 = new Task("Add Task Feature", "Create Add Task feature to add users", "Mike Smith", 10, "Doing");
        assertEquals("AD:1:ITH", task2.createTaskID(), "Task ID should match the expected format.");
    }

    @Test
    public void testReturnTotalHours() {
        Task.totalHours = 0;
        Task.taskCounter = 0;

        new Task("Login Feature", "Create login to authenticate users", "Robyn Harrison", 8, "To Do");
        new Task("Add Task Feature", "Create Add Task feature to add users", "Mike Smith", 10, "Doing");

        assertEquals(18, Task.returnTotalHours(), "Total task hours should be the sum of all task durations.");
    }

    @Test
    public void testPrintTaskDetails() {
        Task task1 = new Task("Login Feature", "Create login to authenticate users", "Robyn Harrison", 8, "To Do");

        String expectedDetails = "Task Status: To Do\n" +
                                 "Developer: Robyn Harrison\n" +
                                 "Task Number: 0\n" +
                                 "Task Name: Login Feature\n" +
                                 "Task Description: Create login to authenticate users\n" +
                                 "Task ID: LO:0:SON\n" +
                                 "Task Duration: 8 hours";

        assertEquals(expectedDetails, task1.printTaskDetails(), "Task details should match the expected output.");
    }

    @Test
    public void testArrayPopulation() {
         Task task1 = new Task("Create Login", "Create login functionality", "Mike Smith", 5, "To Do");
        Task task2 = new Task("Create Add Features", "Add new features to the system", "Edward Harrison", 8, "Doing");
        Task task3 = new Task("Create Reports", "Generate reports", "Samantha Paulson", 2, "Done");
        Task task4 = new Task("Add Arrays", "Work with array data structures", "Glenda Oberholzer", 11, "To Do");

        Task.tasks.add(task1);
        Task.tasks.add(task2);
        Task.tasks.add(task3);
        Task.tasks.add(task4);

        assertEquals(4, Task.tasks.size(), "The task list size should be 4.");
        assertEquals(26, Task.tasks.stream().mapToInt(t -> t.taskDuration).sum(), "Total task duration should be 26.");
    }

    @Test
    public void testDisplayDoneTasks() {
         Task.tasks.add(new Task("Create Reports", "Generate reports", "Samantha Paulson", 2, "Done"));
        Task.tasks.add(new Task("Add Arrays", "Work with array data structures", "Glenda Oberholzer", 11, "To Do"));

        long doneTasksCount = Task.tasks.stream()
                .filter(task -> "Done".equalsIgnoreCase(task.taskStatus))
                .count();

        assertEquals(1, doneTasksCount, "There should be 1 task with status 'Done'.");
    }

    @Test
    public void testLongestTask() {
         Task.tasks.add(new Task("Create Login", "Create login functionality", "Mike Smith", 5, "To Do"));
        Task.tasks.add(new Task("Add Arrays", "Work with array data structures", "Glenda Oberholzer", 11, "To Do"));

        Task longestTask = Task.tasks.stream()
                .max((t1, t2) -> Integer.compare(t1.taskDuration, t2.taskDuration))
                .orElse(null);

        assertEquals("Add Arrays", longestTask.taskName, "The longest task should be 'Add Arrays'.");
    }

    @Test
    public void testSearchTaskByName() {
         // Clear the static task list before testing
    Task.tasks.clear();

    // Populate the task list with test data
    Task.tasks.add(new Task("Create Login", "Create login functionality", "Mike Smith", 5, "To Do"));
    Task.tasks.add(new Task("Create Add Features", "Add new features to the system", "Edward Harrison", 8, "Doing"));

    // Expected and actual results
    boolean expectedResult = true; // We expect "Create Login" to exist
    boolean actualResult = Task.tasks.stream()
            .anyMatch(task -> task.taskName.equalsIgnoreCase("Create Login"));

    // Validate using assertEquals
    assertEquals(expectedResult, actualResult, "The task 'Create Login' should exist.");
    }

    @Test
    public void testSearchTasksByDeveloper() {
       Task.tasks.add(new Task("Create Reports", "Generate reports", "Samantha Paulson", 2, "Done"));
        Task.tasks.add(new Task("Create Login", "Create login functionality", "Mike Smith", 5, "To Do"));

        long developerTasks = Task.tasks.stream()
                .filter(task -> "Mike Smith".equalsIgnoreCase(task.developerDetails))
                .count();

        assertEquals(1, developerTasks, "Mike Smith should have 1 task assigned.");
    }

    @Test
    public void testDeleteTask() {
        Task task1 = new Task("Task Delete", "Task to delete", "Peter Parker", 8, "To Do");
        Task.tasks.add(task1);

        Task.deleteTask("Task Delete");

        boolean exists = Task.tasks.stream()
                .anyMatch(task -> "Task Delete".equalsIgnoreCase(task.taskName));

        assertEquals(false, exists, "Task should be deleted successfully.");
    }

    @Test
    public void testDisplayTaskReport() {
        Task task1 = new Task("Task R1", "First task", "Developer X", 4, "To Do");
        Task task2 = new Task("Task R2", "Second task", "Developer Y", 6, "Done");

        Task.tasks.add(task1);
        Task.tasks.add(task2);

        StringBuilder report = new StringBuilder();
        for (Task task : Task.tasks) {
            report.append(task.printTaskDetails()).append("\n");
        }

        assertEquals(true, report.toString().contains("Developer X"), "Developer X should be in the report.");
        assertEquals(true, report.toString().contains("Developer Y"), "Developer Y should be in the report.");
    }
   
    }



