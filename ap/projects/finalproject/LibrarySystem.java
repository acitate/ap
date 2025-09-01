package ap.projects.finalproject;

import ap.projects.finalproject.manager.StudentManager;
import ap.projects.finalproject.menu.MenuHandler;
import ap.projects.finalproject.model.Student;
import ap.projects.finalproject.util.JsonFileHandler;
import java.io.File;

// LibrarySystem.java
public class LibrarySystem {
    private StudentManager studentManager;
    private MenuHandler menuHandler;
    private JsonFileHandler fileHandler = new JsonFileHandler();
    File Students = new File("Students.json");

    public LibrarySystem() {
        this.studentManager = (fileHandler.loadStudents(Students) == null)? new StudentManager() : fileHandler.loadStudents(Students);
        this.menuHandler = new MenuHandler(this);
    }

    public void registerStudent(String name, String studentId, String username, String password) {
        studentManager.registerStudent(name, studentId, username, password);
        fileHandler.saveStudents(studentManager, Students);
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

    public void start() {
        menuHandler.displayMainMenu();
    }

    public static void main(String[] args) {
        LibrarySystem system = new LibrarySystem();
        system.start();
    }
}
