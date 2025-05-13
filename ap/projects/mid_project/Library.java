package ap.projects.mid_project;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Library {
    private String name;
    private Manager manager;
    private ArrayList<Operator> operators;
    private ArrayList<Student> students;
    private ArrayList<Book> books;
    private ArrayList<BorrowedBook> borrowed;

    public Library() {
        this.operators = new ArrayList<>();
        this.students = new ArrayList<>();
        this.books = new ArrayList<>();
        this.borrowed = new ArrayList<>();
    }

    public ArrayList<Book> getBooks() {
        return this.books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public ArrayList<BorrowedBook> getBorrowed() {
        return this.borrowed;
    }

    public void setBorrowed(ArrayList<BorrowedBook> borrowed) {
        this.borrowed = borrowed;
    }

    public ArrayList<Student> getStudents() {
        return this.students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Operator> getOperators() {
        return this.operators;
    }

    public void setOperators(ArrayList<Operator> operators) {
        this.operators = operators;
    }

    public void addOperator(Operator op) {
        this.operators.add(op);
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

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public ArrayList<Book> searchBook(String query) {
        ArrayList<Book> results = new ArrayList<>();

        for (Book book : this.getBooks()) {
            if (book.getName().toLowerCase().contains(query.toLowerCase())) {
                results.add(book);
            }
        }

        return results;
    }

    public Student getStudent(String id) {
        for (Student stu : this.getStudents()) {
            if (stu.getStudentID().equals(id)) {
                return stu;
            }
        }
        return null;
    }

    public Operator getOperator(String id) {
        for (Operator ope : this.getOperators()) {
            if (ope.getEmployeeID().equals(id)) {
                return ope;
            }
        }
        return null;
    }

    public void changeOperator(int index, Operator new_ope) {
        this.operators.set(index, new_ope);
    }
}
