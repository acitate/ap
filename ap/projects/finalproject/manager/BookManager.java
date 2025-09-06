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
        if (!isbnExists(isbn)) {
            Book newBook = new Book(title, author, date, isbn, pages);
            books.add(newBook);
        } else {
            System.out.println("Book already exists!");
        }
    }

    public ArrayList<Book> searchBooks(String title, String author, String date) {
        ArrayList<Book> results = new ArrayList<>();

        for (Book book : this.books) {
            boolean containsTitle = !title.isEmpty() && book.getTitle().toLowerCase().contains(title.toLowerCase());
            boolean containsAuthor = !author.isEmpty() && book.getAuthor().toLowerCase().contains(author.toLowerCase());
            boolean containsDate = !date.isEmpty() && book.getPublicationDate().contains(date);

            if (containsAuthor || containsDate || containsTitle) {
                results.add(book);
            }
        }

        return results;
    }

    public Book getBook(String isbn) {
        for (Book book : this.books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }

        return null;
    }

    private boolean isbnExists(String isbn) {
        for (Book book : this.books) {
            if (book.getIsbn().equals(isbn)) {
                return true;
            }
        }

        return false;
    }
}
