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
        System.out.println("\n--- Student Login ---");

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        currentUser = librarySystem.authenticateStudent(username, password);

        if (currentUser != null) {
            System.out.println("Login successful! Welcome, " + currentUser.getName());
            displayLoggedInStudentMenu();
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }

    private void displayLoggedInStudentMenu() {
        while (currentUser != null) {
            System.out.println("\n=== Student Dashboard ===");
            System.out.println("1. View My Information");
            System.out.println("2. Edit My Information");
            System.out.println("3. Borrow a Book");
            System.out.println("4. Return a Book");
            System.out.println("5. View Available Books");
            System.out.println("6. Logout");

            int choice = getInt("Please enter your choice: ",1, 6);

            switch (choice) {
                case 1:
                    System.out.println("\n--- My Information ---");
                    System.out.println(currentUser);
                    break;
                case 2:
                    librarySystem.editStudentInformation(currentUser);
                    break;
                case 3:
                    librarySystem.borrowBook(currentUser);
                    break;
                case 4:
                    librarySystem.returnBook(currentUser);
                    break;
                case 5:
                    librarySystem.displayAvailableBooks();
                    break;
                case 6:
                    currentUser = null;
                    System.out.println("Logged out successfully.");
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
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
                handleStudentLogin();
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