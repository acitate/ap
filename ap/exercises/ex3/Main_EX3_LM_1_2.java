package ap.exercises.ex3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main_EX3_LM_1_2 {

    public static void main(String[] args) throws IOException {
        Book[] books = new Book[4];
        books[0] = new Book("1984", "George Orwell", "1949", 328);
        books[1] = new Book("Brave New World", "Aldous Huxley", "1931", 321);
        books[2] = new Book("Fahrenheit 451", "Ray Bradbury", "1953", 156);
        books[3] = new Book("We", "Yevgeny Zamyatin", "1921", 226);

        Student[] students = new Student[5];
        students[0] = new Student("Artorias", "Dinu ", "8925116", "Civil Engineering");
        students[1] = new Student("Gervasio", "Hadjieva", "6154556", "Dental Medicine");
        students[2] = new Student("Gyneth", "Maxentius", "2493848", "Roman History");

        File books_file = new File("books.csv");
        FileWriter writer = new FileWriter(books_file);
        writer.write("Name,Author,Year,Pages\n");
        for (Book book : books) {
            writer.write(book.getName() + ",");
            writer.write(book.getAuthor() + ",");
            writer.write(book.getYear() + ",");
            writer.write((int) book.getPages() + "\n");
        }
        writer.close();

        File students_file = new File("students.csv");
        writer = new FileWriter(students_file);
        writer.write("FirstName,LastName,StudentID,Major\n");

        for (Student student : students) {
            writer.write(student.getFirstName() + ",");
            writer.write(student.getLastName() + ",");
            writer.write(student.getStudentID() + ",");
            writer.write(student.getMajor() + "\n");
        }
        writer.close();


        Scanner reader = new Scanner(books_file);
        reader.nextLine();
        ArrayList<Book> loaded_books = new ArrayList<>();
        Book temp_book;

        while (reader.hasNextLine()) {
            String[] strings = reader.nextLine().split(",");
            temp_book = new Book(strings[0], strings[1], strings[2], Integer.parseInt(strings[3]));
            loaded_books.add(temp_book);
        }

        reader = new Scanner(students_file);
        reader.nextLine();
        ArrayList<Student> loaded_students = new ArrayList<>();
        Student temp_student;

        while (reader.hasNextLine()) {
            String[] strings = reader.nextLine().split(",");
            temp_student = new Student(strings[0], strings[1], strings[2], strings[3]);
            loaded_students.add(temp_student);
        }
    }
}
