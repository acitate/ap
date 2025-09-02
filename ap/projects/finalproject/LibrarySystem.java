package ap.projects.finalproject;

import ap.projects.finalproject.manager.LibrarianManager;
import ap.projects.finalproject.manager.StudentManager;
import ap.projects.finalproject.menu.MenuHandler;
import ap.projects.finalproject.model.Director;
import ap.projects.finalproject.model.Librarian;
import ap.projects.finalproject.model.Student;
import ap.projects.finalproject.model.User;
import ap.projects.finalproject.util.JsonFileHandler;
import java.io.File;

// LibrarySystem.java
public class LibrarySystem {
    private static Director director;
    private StudentManager studentManager;
    private LibrarianManager librarianManager;
    private MenuHandler menuHandler;
    private JsonFileHandler fileHandler = new JsonFileHandler();
    File students_file = new File("Students.json");
    File librarians_file = new File("Librarians.json");

    public LibrarySystem() {
        this.director = new Director("Amir Sultani", "1234");

        this.studentManager = (StudentManager) fileHandler.loadFromFile(students_file, StudentManager.class);
        this.studentManager = (studentManager == null)? new StudentManager() : studentManager;

        this.librarianManager = (LibrarianManager) fileHandler.loadFromFile(librarians_file, LibrarianManager.class);
        this.librarianManager = (librarianManager == null)? new LibrarianManager() : librarianManager;

        this.menuHandler = new MenuHandler(this);
    }

    public static Director getDirector() {
        return director;
    }

    public void registerStudent(String name, String studentId, String username, String password) {
        studentManager.registerStudent(name, studentId, username, password);
        save();
    }

    public Student authenticateStudent(String username, String password) {
        return studentManager.authenticateStudent(username, password);
    }

    public void editStudentInformation(Student student) {
        System.out.println("Not implemented.");
    }

    public void borrowBook(Student student) {
        System.out.println("Not implemented.");
    }

    public void returnBook(Student student) {
        System.out.println("Not implemented.");
    }

    public void displayAvailableBooks() {
        System.out.println("Not implemented.");
    }

    public int getStudentCount() {
        return this.studentManager.getStudentCount();
    }

    public Director authenticateDirector(String password) {
        return director.authenticate(password);
    }

    public void addLibrarian(String name, String username, String password) {
        librarianManager.addLibrarian(name, username, password);
        save();
    }

    public static void main(String[] args) {
        LibrarySystem system = new LibrarySystem();
        system.start();
    }

    public User authenticateLibrarian(String username, String password) {
        return librarianManager.authenticateLibrarian(username, password);
    }

    public void start() {
        menuHandler.displayMainMenu();
    }

    public void save() {
        fileHandler.saveToFile(studentManager, students_file);
        fileHandler.saveToFile(librarianManager, librarians_file);
    }

    public void updateLibrarian(User old_librarian, User new_librarian) {
        librarianManager.update((Librarian) old_librarian, (Librarian) new_librarian);
    }
}
