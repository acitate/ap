package ap.projects.finalproject.menu;


// MenuHandler.java
import ap.projects.finalproject.LibrarySystem;
import ap.projects.finalproject.model.Person;
import ap.projects.finalproject.model.Student;

import java.util.Scanner;

import static ap.projects.finalproject.util.InputHandler.*;

public class MenuHandler {
//    private Scanner scanner;
    private LibrarySystem librarySystem;
    private Person currentUser;

    public MenuHandler(LibrarySystem librarySystem) {
//        this.scanner = new Scanner(System.in);
        this.librarySystem = librarySystem;
        this.currentUser = null;
    }

    public void displayMainMenu() {
        while (true) {
            System.out.println("\n=== University Library Management System ===");
            System.out.println("1. Quest User");
            System.out.println("2. Student");
            System.out.println("3. Librarian");
            System.out.println("4. Director");
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
                    displayLibrarianMenu();
                    break;
                case 4:
                    handleDirectorLogin();
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

        String name = getString("Student name: ");
        String studentId = getNumericString("Student ID: ");
        String username = getString("Username: ");
        String password = getString("Password: ");

        librarySystem.registerStudent(name, studentId, username, password);
    }

    private void handleStudentLogin() {
        System.out.println("\n--- Student Login ---");

        String username = getString("Username: ");
        String password = getString("Password: ");

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
                    librarySystem.editStudentInformation((Student) currentUser);
                    break;
                case 3:
                    librarySystem.borrowBook((Student) currentUser);
                    break;
                case 4:
                    librarySystem.returnBook((Student) currentUser);
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
        while (true) {
            System.out.println("\n=== Guest ===");
            System.out.println("1. No. registered students");
            System.out.println("2. Search book by name");
            System.out.println("3. Simple statistics");
            System.out.println("4. Back");

            int choice = getInt("Please enter your choice: ", 1, 6);

            switch (choice) {
                case 1:
                    System.out.println("\n" + librarySystem.getStudentCount() + " students have registered thus far.");
                    break;
                case 2:
                    System.out.println("Placeholder");
                    break;
                case 3:
                    System.out.println("Placeholder");
                    break;
                case 4:
                    return;
            }
        }
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

    private void displayLibrarianMenu() {
        System.out.println("Not implemented.");
    }

    private void displayDirectorMenu() {
        while (currentUser != null) {
            System.out.println("\n=== Director ===");
            System.out.println("1. Add Librarian");
            System.out.println("2. Librarian Performance");
            System.out.println("3. Books statistics");
            System.out.println("4. Students Statistics");
            System.out.println("5. Logout");

            int choice = getInt("Please enter your choice: ");

            switch (choice) {
                case 1:
                    handleLibrarianAddition();
                    break;
                case 2:
                    System.out.println("Placeholder");
                    break;
                case 3:
                    System.out.println("Placeholder");
                    break;
                case 4:
                    System.out.println("Placeholder");
                    break;
                case 5:
                    currentUser = null;
                    return;
                default:
                    System.out.println("Invalid input!");
            }
        }
    }

    private void handleLibrarianAddition() {
        System.out.println("\n---- New Librarian ---");
        String name = getString("Enter new librarian's name: ");
        new Scanner(System.in).next();
        String username = getString("Enter new librarian's username: ");
        String password = getString("Enter new linrarian's password: ");

        librarySystem.addLibrarian(name, username, password);
    }

    private void handleDirectorLogin() {
        System.out.println("\n--- Director Login ---");
        System.out.println(LibrarySystem.getDirector());

        String password = getString("Enter password: ");

        currentUser = librarySystem.authenticateDirector(password);

        if (currentUser != null) {
            displayDirectorMenu();
        }
    }
}