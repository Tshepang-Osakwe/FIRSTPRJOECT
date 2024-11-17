package com.mycompany.login;

import javax.swing.JOptionPane;
import java.util.ArrayList;

/**
 * Task class to manage tasks for the application.
 */
public class Task {
    private String taskName;
    private int taskNumber;
    private String taskDescription;
    private String developerDetails;
    private int taskDuration;
    private String taskID;
    private String taskStatus;

    private static ArrayList<Task> tasks = new ArrayList<>();
    private static int totalHours = 0;
    private static int taskCounter = 0;

    public static ArrayList<String> developerList = new ArrayList<>();
    public static ArrayList<String> taskNameList = new ArrayList<>();
    public static ArrayList<String> taskIDList = new ArrayList<>();
    public static ArrayList<Integer> taskDurationList = new ArrayList<>();
    public static ArrayList<String> taskStatusList = new ArrayList<>();

    // Constructor
    public Task(String taskName, String taskDescription, String developerDetails, int taskDuration, String taskStatus) {
        this.taskName = taskName;
        this.taskNumber = taskCounter++;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
        this.taskID = createTaskID();
        totalHours += taskDuration;
    }

    // Method to ensure task description is less than 50 characters
    public boolean checkTaskDescription() {
        return taskDescription.length() <= 50;
    }

    // Method to create task ID
    public String createTaskID() {
        String devLastName = developerDetails.split(" ")[1]; // Assume developer name is "First Last"
        return taskName.substring(0, 2).toUpperCase() + ":" + taskNumber + ":" + devLastName.substring(devLastName.length() - 3).toUpperCase();
    }

    // Method to print task details
    public String printTaskDetails() {
        return "Task Status: " + taskStatus + "\n" +
               "Developer: " + developerDetails + "\n" +
               "Task Number: " + taskNumber + "\n" +
               "Task Name: " + taskName + "\n" +
               "Task Description: " + taskDescription + "\n" +
               "Task ID: " + taskID + "\n" +
               "Task Duration: " + taskDuration + " hours";
    }

    // Method to return total hours of all tasks
    public static int returnTotalHours() {
        return totalHours;
    }

    /**
     * Prompts the user to add multiple tasks and stores them in the static tasks list.
     * Each task requires user input for name, description, developer name, duration, and status.
     */
    public static void addTasks() {
        int numTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks do you want to add?"));

        for (int i = 0; i < numTasks; i++) {
            // Input task details from user
            String taskName = JOptionPane.showInputDialog("Enter Task Name:");
            String taskDescription = JOptionPane.showInputDialog("Enter Task Description (max 50 characters):");

            if (taskDescription.length() > 50) {
                JOptionPane.showMessageDialog(null, "Task description too long! Please enter less than 50 characters.");
                i--; // Retry task input if description is invalid
                continue;
            }

            String developerDetails = JOptionPane.showInputDialog("Enter Developer First and Last Name:");
            String[] nameParts = developerDetails.split(" ");
            if (nameParts.length < 2) {
                JOptionPane.showMessageDialog(null, "Please provide both first and last name.");
                i--; // Retry task input if developer name format is invalid
                continue;
            }

            int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter Task Duration (in hours):"));
            String taskStatus = JOptionPane.showInputDialog("Select Task Status:\n1) To Do\n2) Doing\n3) Done");

            switch (taskStatus) {
                case "1":
                    taskStatus = "To Do";
                    break;
                case "2":
                    taskStatus = "Doing";
                    break;
                case "3":
                    taskStatus = "Done";
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid status! Defaulting to 'To Do'.");
                    taskStatus = "To Do";
            }

            // Create and store the task
            Task newTask = new Task(taskName, taskDescription, developerDetails, taskDuration, taskStatus);
            tasks.add(newTask);

            // Populate additional lists
            developerList.add(developerDetails);
            taskNameList.add(taskName);
            taskIDList.add(newTask.taskID);
            taskDurationList.add(taskDuration);
            taskStatusList.add(taskStatus);

            // Display task details
            JOptionPane.showMessageDialog(null, newTask.printTaskDetails());
        }

        JOptionPane.showMessageDialog(null, "All tasks added successfully! Total hours: " + returnTotalHours());
    }

    // Display tasks with 'Done' status
    public static void displayDoneTasks() {
        StringBuilder result = new StringBuilder("Tasks with status 'Done':\n");
        for (int i = 0; i < taskStatusList.size(); i++) {
            if ("Done".equalsIgnoreCase(taskStatusList.get(i))) {
                result.append("Developer: ").append(developerList.get(i))
                      .append(", Task Name: ").append(taskNameList.get(i))
                      .append(", Duration: ").append(taskDurationList.get(i)).append(" hours\n");
            }
        }
        JOptionPane.showMessageDialog(null, result.toString());
    }

    // Display the longest task
    public static void displayLongestTask() {
        int maxIndex = 0;
        for (int i = 1; i < taskDurationList.size(); i++) {
            if (taskDurationList.get(i) > taskDurationList.get(maxIndex)) {
                maxIndex = i;
            }
        }
        String result = "Longest Task:\nDeveloper: " + developerList.get(maxIndex) +
                        "\nTask Name: " + taskNameList.get(maxIndex) +
                        "\nDuration: " + taskDurationList.get(maxIndex) + " hours";
        JOptionPane.showMessageDialog(null, result);
    }

    // Search task by name
    public static void searchTaskByName(String taskName) {
        for (int i = 0; i < taskNameList.size(); i++) {
            if (taskNameList.get(i).equalsIgnoreCase(taskName)) {
                String result = "Task Found:\nDeveloper: " + developerList.get(i) +
                                "\nTask Name: " + taskNameList.get(i) +
                                "\nTask Status: " + taskStatusList.get(i);
                JOptionPane.showMessageDialog(null, result);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Task not found.");
    }

    // Other methods remain unchanged...
}
