package ap.projects.finalproject;

import ap.projects.finalproject.manager.BookManager;
import ap.projects.finalproject.manager.LibrarianManager;
import ap.projects.finalproject.manager.StudentManager;
import ap.projects.finalproject.manager.RequestManager;
import ap.projects.finalproject.menu.MenuHandler;
import ap.projects.finalproject.model.*;
import ap.projects.finalproject.util.IdGen;
import ap.projects.finalproject.util.JsonFileHandler;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// LibrarySystem.java
public class LibrarySystem {
    private IdGen gen = new IdGen();

    private static Director director;

    private StudentManager studentManager;
    private LibrarianManager librarianManager;
    private BookManager bookManager;
    private RequestManager requestManager;

    private MenuHandler menuHandler;
    private JsonFileHandler fileHandler = new JsonFileHandler();

    File students_file = new File("Students.json");
    File librarians_file = new File("Librarians.json");
    File books_file = new File("Books.json");
    File requests_file = new File("Requests.json");

    public LibrarySystem() {
        this.director = new Director("Amir Sultani", "1234");

        this.studentManager = (StudentManager) fileHandler.loadFromFile(students_file, StudentManager.class);
        this.studentManager = (studentManager == null)? new StudentManager() : studentManager;

        this.librarianManager = (LibrarianManager) fileHandler.loadFromFile(librarians_file, LibrarianManager.class);
        this.librarianManager = (librarianManager == null)? new LibrarianManager() : librarianManager;

        this.bookManager = (BookManager) fileHandler.loadFromFile(books_file, BookManager.class);
        this.bookManager = (bookManager == null)? new BookManager() : bookManager;

        this.requestManager = (RequestManager) fileHandler.loadFromFile(requests_file, RequestManager.class);
        this.requestManager = (requestManager == null)? new RequestManager() : requestManager;

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

    public ArrayList<Book> searchBooks(String title, String author, String date) {
        return bookManager.searchBooks(title, author, date);
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
        fileHandler.saveToFile(bookManager, books_file);
        fileHandler.saveToFile(requestManager, requests_file);
    }

    public void updateLibrarian(User old_librarian, User new_librarian) {
        librarianManager.update((Librarian) old_librarian, (Librarian) new_librarian);
        save();
    }

    public void addBook(String title, String author, String date, long pages) {
        String isbn = gen.generateID().toString();
        bookManager.addBook(title, author, date, isbn, pages);
        save();
    }

    public Book getBook(String isbn) {
        return bookManager.getBook(isbn);
    }

    public void makeRequest(Book book, User currentUser) {
        String ID = gen.generateID().toString();
        requestManager.makeRequest(book, (Student) currentUser, ID);
        save();
    }

    public HashMap<String, BorrowRequest> getRequests() {
        return requestManager.getRequests();
    }

    public BorrowRequest getRequest(String ID) {
        return requestManager.getRequest(ID);
    }

    public void changeRequestStatus(int input, String id, BorrowRequest req) {
        requestManager.setRequestStatus(id, req);
        if (input == 1) {

            Book book = req.getBook();
            updateBook(req.getBook(), book, false);

            BorrowedBook borrowedBook = new BorrowedBook(req);
            bookManager.addBorrowed(borrowedBook);
        }
    }

    public void updateBook(Book oldBook, Book newBook, boolean isAvailable) {
        bookManager.updateBook(oldBook, newBook, isAvailable);
        save();
    }

    public List<Book> getBooks() {
        return bookManager.getBooks();
    }

    public List<Student> getStudents() {
        return studentManager.getStudents();
    }

    public void studentActivation(String username, boolean state) {
        Student student = studentManager.getStudent(username);
        student.setActive(state);

        studentManager.update(studentManager.getStudent(username), student);
        save();
    }
}
