package ap.projects.finalproject.menu;


// MenuHandler.java
import ap.projects.finalproject.LibrarySystem;
import ap.projects.finalproject.model.Student;

import java.util.Scanner;

import static ap.projects.finalproject.util.InputHandler.getInt;

public class MenuHandler {
    private Scanner scanner;
    private LibrarySystem librarySystem;
    private Student currentUser;

    public MenuHandler(LibrarySystem librarySystem) {
        this.scanner = new Scanner(System.in);
        this.librarySystem = librarySystem;
        this.currentUser = null;
    }

    public void displayMainMenu() {
        while (true) {
            System.out.println("\n=== University Library Management System ===");
            System.out.println("1. Quest User");
            System.out.println("2. Student");
            System.out.println("3. Operator");
            System.out.println("4. Manager");
            System.out.println("5. Exit");

            int choice = getInt("Please enter your choice: ", 1, 6);

            switch (choice) {
                case 1:
                    displayQuestMenu();
                    break;
                case 2:
                    displayStudentMenu();
                    break;
                case 3:
                    displayOperatorMenu();
                    break;
                case 4:
                    handleManagerLogin();
                    break;
                case 5:
                    System.out.println("Existing system, bye!!!");
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
            System.out.println("___________________________");
        }
    }

    private void displayStudentCount() {
        System.out.printf("Not implemented.");
    }

    private void handleStudentRegistration() {
        System.out.println("\n--- New Student Registration ---");

        System.out.print("Student name: ");
        String name = scanner.nextLine();

        System.out.print("Student ID: ");
        String studentId = scanner.nextLine();

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        librarySystem.registerStudent(name, studentId, username, password);
    }

    private void handleStudentLogin() {
        System.out.println("Not implemented.");
    }

    private void displayLoggedInStudentMenu() {
        System.out.println("Not implemented.");
    }

    private void displayQuestMenu() {
        System.out.println("Not implemented.");
    }

    private void displayStudentMenu() {
        System.out.println("\n=== Student ===");
        System.out.println("1. Register New Student");
        System.out.println("2. Login");
        System.out.println("3. Back");

        int choice = getInt("Please enter your choice: ", 1, 4);

        switch (choice) {
            case 1:
                handleStudentRegistration();
                break;
            case 2:
                System.out.printf("Not implemented.");
                break;
            case 3:
                return;
        }
    }

    private void displayOperatorMenu() {
        System.out.println("Not implemented.");
    }

    private void handleManagerLogin() {
        System.out.println("Not implemented");
    }
}