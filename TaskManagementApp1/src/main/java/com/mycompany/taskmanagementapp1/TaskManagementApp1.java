/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.taskmanagementapp1;

/**
 *
 * @author lukel
 */
import java.util.Scanner;

public class TaskManagementApp1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addTask(scanner, taskManager);
                    break;
                case 2:
                    viewTasks(taskManager);
                    break;
                case 3:
                    markTaskAsCompleted(scanner, taskManager);
                    break;
                case 4:
                    System.out.println("Exiting the application.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void displayMenu() {
        System.out.println("Task Management System Menu:");
        System.out.println("1. Add a task");
        System.out.println("2. View tasks");
        System.out.println("3. Mark task as completed");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addTask(Scanner scanner, TaskManager taskManager) {
        System.out.print("Enter task title: ");
        String title = scanner.nextLine();

        System.out.print("Enter task description: ");
        String description = scanner.nextLine();

        System.out.print("Enter task priority (1-5): ");
        int priority = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Task task = new Task(title, description, priority);
        taskManager.addTask(task);
        System.out.println("Task added successfully.");
    }

    private static void viewTasks(TaskManager taskManager) {
        System.out.println("Task List:");
        for (Task task : taskManager.getAllTasks()) {
            System.out.println("Title: " + task.getTitle());
            System.out.println("Description: " + task.getDescription());
            System.out.println("Priority: " + task.getPriority());
            System.out.println("Status: " + (task.isCompleted() ? "Completed" : "Incomplete"));
            System.out.println();
        }
    }

    private static void markTaskAsCompleted(Scanner scanner, TaskManager taskManager) {
        System.out.print("Enter task title to mark as completed: ");
        String title = scanner.nextLine();

        List<Task> tasks = taskManager.getAllTasks();
        boolean taskFound = false;

        for (Task task : tasks) {
            if (task.getTitle().equalsIgnoreCase(title)) {
                taskManager.markTaskAsCompleted(task);
                System.out.println("Task marked as completed.");
                taskFound = true;
                break;
            }
        }

        if (!taskFound) {
            System.out.println("Task not found.");
        }
    }
}

