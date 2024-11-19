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
        Task task1 = new Task("Login Feature", "Create login to authenticate users", "Robyn Harrison", 8, "To Do");
        Task task2 = new Task("Add Task Feature", "Create Add Task feature to add users", "Mike Smith", 10, "Doing");

        int expectedTotalHours = 18; // 8 + 10
        assertEquals(expectedTotalHours, Task.returnTotalHours(), "Total task hours should be correct.");
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
        Task task1 = new Task("Task 1", "Description 1", "Developer A", 5, "To Do");
        Task task2 = new Task("Task 2", "Description 2", "Developer B", 8, "Doing");
        Task task3 = new Task("Task 3", "Description 3", "Developer C", 2, "Done");

        Task.tasks.add(task1);
        Task.tasks.add(task2);
        Task.tasks.add(task3);

        assertEquals(3, Task.tasks.size(), "Task list size is incorrect.");
        assertEquals(15, Task.tasks.stream().mapToInt(t -> t.taskDuration).sum(), "Total task durations should be correct.");
    }

    @Test
    public void testDisplayDoneTasks() {
        Task task1 = new Task("Task A", "Short task", "Alice Bobson", 5, "Done");
        Task task2 = new Task("Task B", "Another task", "Charlie Dan", 7, "To Do");

        Task.tasks.add(task1);
        Task.tasks.add(task2);

        long doneTasksCount = Task.tasks.stream()
                .filter(task -> "Done".equalsIgnoreCase(task.taskStatus))
                .count();

        assertEquals(1, doneTasksCount, "Count of 'Done' tasks is incorrect.");
    }

    @Test
    public void testLongestTask() {
        Task task1 = new Task("Task X", "Short task", "John Doe", 3, "To Do");
        Task task2 = new Task("Task Y", "Longer task", "Jane Smith", 10, "Doing");

        Task.tasks.add(task1);
        Task.tasks.add(task2);

        Task longestTask = Task.tasks.stream()
                .max((t1, t2) -> Integer.compare(t1.taskDuration, t2.taskDuration))
                .orElse(null);

        assertEquals("Task Y", longestTask.taskName, "Longest task name should match.");
    }

    @Test
    public void testSearchTaskByName() {
        Task task1 = new Task("Login Feature", "Create Login", "Alice Bobson", 8, "To Do");
        Task task2 = new Task("Add Feature", "Create Add Task feature", "Mike Smith", 10, "Doing");

        Task.tasks.add(task1);
        Task.tasks.add(task2);

        boolean found = Task.tasks.stream()
                .anyMatch(task -> task.taskName.equalsIgnoreCase("Login Feature"));

        assertEquals(true, found, "Task search should find an existing task by name.");
    }

    @Test
    public void testSearchTasksByDeveloper() {
        Task task1 = new Task("Task 1", "First task", "Nancy Drew", 4, "To Do");
        Task task2 = new Task("Task 2", "Second task", "Nancy Drew", 6, "Done");

        Task.tasks.add(task1);
        Task.tasks.add(task2);

        long developerTasks = Task.tasks.stream()
                .filter(task -> "Nancy Drew".equalsIgnoreCase(task.developerDetails))
                .count();

        assertEquals(2, developerTasks, "Tasks by the developer should be correctly counted.");
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
