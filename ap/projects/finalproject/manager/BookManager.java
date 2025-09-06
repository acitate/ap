package ap.projects.finalproject.manager;

import ap.projects.finalproject.model.Book;
import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private List<Book> books;
//    private List<Borrowe>

    public BookManager() {
        this.books = new ArrayList<>();
    }

    public void addBook(String title, String author, String date, String isbn, long pages) {
        Book newBook = new Book(title, author, date, isbn, pages);
        books.add(newBook);
    }
}
