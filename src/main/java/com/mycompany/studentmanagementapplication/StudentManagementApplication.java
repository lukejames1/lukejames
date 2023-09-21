/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.studentmanagementapplication;

/**
 *
 * @author lukel
 */
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementApplication {
    private static ArrayList<Student> students = new ArrayList<>();
    private static int studentIdCounter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    saveStudent(scanner);
                    break;
                case 2:
                    searchStudent(scanner);
                    break;
                case 3:
                    deleteStudent(scanner);
                    break;
                case 4:
                    studentReport();
                    break;
                case 5:
                    exitStudentApplication();
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void displayMenu() {
        System.out.println("Student Management System Menu:");
        System.out.println("1. Capture a new student");
        System.out.println("2. Search for a student");
        System.out.println("3. Delete a student");
        System.out.println("4. View student report");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void saveStudent(Scanner scanner) {
        System.out.print("Enter student name: ");
        String name = scanner.next();

        System.out.print("Enter student age: ");
        int age;
        while (true) {
            if (scanner.hasNextInt()) {
                age = scanner.nextInt();
                if (age >= 16) {
                    break;
                } else {
                    System.out.print("Invalid age. Please enter a valid age (>= 16): ");
                }
            } else {
                System.out.print("Invalid input. Please enter a valid age (>= 16): ");
                scanner.next(); // Consume invalid input
            }
        }

        Student student = new Student(studentIdCounter++, name, age);
        students.add(student);
        System.out.println("Student details saved successfully.");
    }

    private static void searchStudent(Scanner scanner) {
        System.out.print("Enter student ID: ");
        int studentId = scanner.nextInt();

        for (Student student : students) {
            if (student.getId() == studentId) {
                System.out.println("Student found:");
                System.out.println(student);
                return;
            }
        }

        System.out.println("Student not found.");
    }

    private static void deleteStudent(Scanner scanner) {
        System.out.print("Enter student ID to delete: ");
        int studentId = scanner.nextInt();

        for (Student student : students) {
            if (student.getId() == studentId) {
                students.remove(student);
                System.out.println("Student deleted successfully.");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    private static void studentReport() {
        System.out.println("Student Report:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static void exitStudentApplication() {
        System.out.println("Exiting the application.");
    }
}

class Student {
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Student ID: " + id + ", Name: " + name + ", Age: " + age;
    }
    
}
