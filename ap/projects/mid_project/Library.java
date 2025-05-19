package ap.projects.mid_project;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import ap.projects.mid_project.Main;
import java.util.function.Predicate;

public class Library {
    private String name;
    private Manager manager;
    private HashMap<String, Operator> operators;
    private HashMap<String, Student> students;
    private HashMap<String, Book> books;
    private HashMap<String, BorrowedBook> borrowed;
    private HashMap<String, Request> requests;
    private ArrayList<BorrowedBook> offtime;

    public Library() {
        this.operators = new HashMap<>();
        this.students = new HashMap<>();
        this.books = new HashMap<>();
        this.borrowed = new HashMap<>();
        this.requests = new HashMap<>();
        this.offtime = new ArrayList<>();
    }

    public HashMap<String ,Book> getBooks() {
        return this.books;
    }

    public void setBooks(HashMap<String, Book> books) {
        this.books = books;
    }

    public void addBook(String id, Book book) {
        this.books.put(id ,book);
    }

    public HashMap<String, BorrowedBook> getBorrowed() {
        return this.borrowed;
    }

    public void setBorrowed(HashMap<String, BorrowedBook> borrowed) {
        this.borrowed = borrowed;
    }

    public HashMap<String, Student> getStudents() {
        return this.students;
    }

    public void setStudents(HashMap<String, Student> students) {
        this.students = students;
    }

    public HashMap<String, Operator> getOperators() {
        return this.operators;
    }

    public void setOperators(HashMap<String, Operator> operators) {
        this.operators = operators;
    }

    public void addOperator(String id, Operator op) {
        this.operators.put(id, op);
    }

    public Manager getManager() {
        return this.manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public void setName(String name) {
        this.name = name;
    }

    public <T> int Exists(List<T> list, Predicate<T> condition) {
        // if the item exists, it's index is returned, else -1 is returned
        for (T item : list) {
            if (condition.test(item)) {
                return list.indexOf(item);
            }
        }
        return -1;
    }

    public void addStudent(String id, Student student) {
        this.students.put(id, student);
    }

    public ArrayList<Book> searchBook(String query) {
        ArrayList<Book> results = new ArrayList<>();

        for (Book book : this.getBooks().values()) {
            if (book.getName().toLowerCase().contains(query.toLowerCase())) {
                results.add(book);
            }
        }

        return results;
    }

    public Student getStudent(String id) {
//        for (Student stu : this.getStudents()) {
//            if (stu.getStudentID().equals(id)) {
//                return stu;
//            }
//        }
//        return null;

        return this.getStudents().get(id);
    }

    public Operator getOperator(String id) {
//        for (Operator ope : this.getOperators()) {
//            if (ope.getEmployeeID().equals(id)) {
//                return ope;
//            }
//        }
//        return null;

        return this.getOperators().get(id);
    }

    public void changeOperator(String id, Operator new_ope) {
        this.operators.replace(id, new_ope);
    }

    public void addRequest(String id, Request request) {
        this.requests.put(id, request);
    }

    public HashMap<String, Request> getRequests() {
        return requests;
    }

    public void removeRequest(String id) {
        this.requests.remove(id);
    }

    public void addBorrowed(String id, BorrowedBook borrowedBook) {
        this.borrowed.put(id, borrowedBook);
    }

    public void removeBorrowed(String id) {
        this.borrowed.remove(id);
    }

    public void removeBook(Book book) {
        this.books.entrySet().removeIf(entry -> entry.getValue().equals(book));
    }

    public void returnBook(String id, Book book) {
        BorrowedBook temp = this.borrowed.get(id);
        temp.setRealReturnDate();
        if (temp.getRealReturnDate().isAfter(temp.getReturnDate())) {
            this.offtime.add(temp);
        }
        this.borrowed.remove(id);
        this.addBook(Main.idGen() ,book);
    }

    public void borrowBook(String id, Request req, Operator op) {
        BorrowedBook temp = new BorrowedBook(req.getBook(), req.getRequester(), op);
        this.removeRequest(id);
        this.addBorrowed(Main.idGen(), temp);
        this.removeBook(req.getBook());
    }

    public ArrayList<BorrowedBook> getOfftime() {
        return offtime;
    }
}


class Request {
    private RequestType type;
    private Book book;
    private Student requester;
    private LocalDate date;

    public Request(Book book, Student requester, RequestType type) {
        this.book = book;
        this.type = type;
        this.requester = requester;
        date = LocalDate.now();
    }

    @Override
    public String toString() {
        return "book=" + book + ", type=" + type + ", requester= " + requester;
    }

    public RequestType getType() {
        return type;
    }

    public Book getBook() {
        return book;
    }

    public Student getRequester() {
        return requester;
    }
}

enum RequestType {
    BORROW,
    RETURN;
}