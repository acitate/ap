package ap.projects.finalproject.menu;


// MenuHandler.java
import ap.projects.finalproject.LibrarySystem;
import ap.projects.finalproject.model.Book;
import ap.projects.finalproject.model.User;
import ap.projects.finalproject.model.Student;

import java.util.ArrayList;
import java.util.Scanner;

import static ap.projects.finalproject.util.InputHandler.*;

public class MenuHandler {
    private LibrarySystem librarySystem;
    private User currentUser;

    public MenuHandler(LibrarySystem librarySystem) {
        this.librarySystem = librarySystem;
        this.currentUser = null;
    }

    public void displayMainMenu() {
        // The very first menu that is displayed when the app is started.
        while (true) {
            System.out.println("\n=== University Library Management System ===");
            System.out.println("1. Quest User");
            System.out.println("2. Student");
            System.out.println("3. Librarian");
            System.out.println("4. Director");
            System.out.println("5. Exit");

            int choice = getInt("Please enter your choice: ", 1, 5);

            switch (choice) {
                case 1:
                    displayQuestMenu();
                    break;
                case 2:
                    displayStudentMenu();
                    break;
                case 3:
                    handleLibrarianLogin();
                    break;
                case 4:
                    handleDirectorLogin();
                    break;
                case 5:
                    librarySystem.save();
                    System.out.println("Existing system, bye!!!");
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
            System.out.println("___________________________");
        }
    }

    private void handleLibrarianLogin() {
        // Log into the app as a Librarian, Requires the username and password of an existing librarian.
        System.out.println("\n--- Librarian Login ---");

        String username = getString("Enter librarian's username: ");
        String password = getString("Enter password: ");

        currentUser = librarySystem.authenticateLibrarian(username, password);

        if (currentUser != null) {
            System.out.println("Login successful! Welcome, " + currentUser.getName());
            displayLibrarianMenu();
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }

    private void displayStudentCount() {
        System.out.printf("Not implemented.");
    }

    private void handleStudentRegistration() {
        // Register and log in as a new student.
        System.out.println("\n--- New Student Registration ---");

        String name = getString("Student name: ");
        String studentId = getNumericString("Student ID: ");
        String username = getString("Username: ");
        String password = getString("Password: ");

        librarySystem.registerStudent(name, studentId, username, password);
    }

    private void handleStudentLogin() {
        // Log into the app as a student, requires username and password of an existing student.
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
        // The menu of actions available for a student.
        while (currentUser != null) {
            System.out.println("\n=== Student Dashboard ===");
            System.out.println("1. View My Information");
            System.out.println("2. Search books");
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
                    handleBookSearch();
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

    private void handleBookSearch() {
        System.out.println("\n--- Book search ---");
        String title = getString("Enter book's title: ");
        String author = getString("Enter book's author: ");
        String date = ((Integer) getInt("Enter book's year of publication: ", 1000, 9999)).toString();


        ArrayList<Book> results = librarySystem.searchBooks(title, author, date);

        for (Book book : results) {
            System.out.println(book);
        }
    }

    private void handleBookSearch(String quest) {
        System.out.println("\n--- Book search ---");
        String title = getString("Enter book's title: ");
        String author = "";
        String date = "";


        ArrayList<Book> results = librarySystem.searchBooks(title, author, date);

        for (Book book : results) {
            System.out.println(book);
        }
    }

    private void displayQuestMenu() {
        while (true) {
            System.out.println("\n=== Guest ===");
            System.out.println("1. No. registered students");
            System.out.println("2. Search book by name");
            System.out.println("3. Simple statistics");
            System.out.println("4. Back");

            int choice = getInt("Please enter your choice: ", 1, 4);

            switch (choice) {
                case 1:
                    System.out.println("\n" + librarySystem.getStudentCount() + " students have registered thus far.");
                    break;
                case 2:
                    handleBookSearch("quest");
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
        // Decide to login as an existing student or register a new student.
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
        // Actions available to a Librarian.
        while (currentUser != null) {
            System.out.println("\n=== Librarian Dashboard ===");
            System.out.println("1. Change password");
            System.out.println("2. Add book");
            System.out.println("3. Edit book");
            System.out.println("4. Requests");
            System.out.println("5. Student history");
            System.out.println("6. Ban student");
            System.out.println("7. Logout");

            int choice = getInt("Please enter your choice: ", 1, 7);

            switch (choice) {
                case 1:
                    handleLibrarianPassChange();
                    break;
                case 2:
                    handleBookAddition();
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                    System.out.println("Placeholder");
                    break;
                case 7:
                    currentUser = null;
                    return;
                default:
                    System.out.println("Invalid input!");
            }
        }
    }

    private void handleBookAddition() {
        // Handles the addition of a new book by a librarian.
        System.out.println("\n--- New Book ---");
        String title = getString("Enter the book's title: ");
        String author = getString("Enter the name of the book's author: ");
        String date = getString("Enter the book's publication year: ");
        String isbn = getString("Enter the book's ISBN: ");
        long pages = getInt("Enter the No. pages: ");

        librarySystem.addBook(title, author, date, isbn, pages);
    }

    private void handleLibrarianPassChange() {
        String old_pass = getString("Enter your current password: ");
        User oldUser = currentUser;

        if (currentUser.getPassword().equals(old_pass)) {
            String new_pass = getString("Enter new password: ");

            if (currentUser.getPassword().equals(new_pass)) {
                System.out.println("This is already your password!");
                return;
            } else {
                currentUser.setPassword(new_pass);
                librarySystem.updateLibrarian(oldUser, currentUser);
                return;
            }
        } else {
            System.out.println("Wrong password!");
            return;
        }
    }

    private void displayDirectorMenu() {
        // The manager of the library's menu.
        while (currentUser != null) {
            System.out.println("\n=== Director ===");
            System.out.println("1. Add Librarian");
            System.out.println("2. Librarian Performance");
            System.out.println("3. Books statistics");
            System.out.println("4. Students Statistics");
            System.out.println("5. Logout");

            int choice = getInt("Please enter your choice: ", 1, 5);

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
        // Handles the addition of a new librarian by the manager.
        System.out.println("\n---- New Librarian ---");
        String name = getString("Enter new librarian's name: ");
//        new Scanner(System.in).next();
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