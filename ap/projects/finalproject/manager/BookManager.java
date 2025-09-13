package ap.projects.finalproject.manager;

import ap.projects.finalproject.model.Book;
import ap.projects.finalproject.model.BorrowRequest;
import ap.projects.finalproject.model.BorrowedBook;
import ap.projects.finalproject.util.IdGen;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookManager {
    private List<Book> books;
    private List<BorrowedBook>  borrowedBooks;

    public BookManager() {
        this.books = new ArrayList<>();
        this.borrowedBooks = new ArrayList<>();
    }

    public void addBook(String title, String author, String date, String isbn, long pages) {
        Book newBook = new Book(title, author, date, isbn, pages);
        books.add(newBook);

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

    public void updateBook(Book old, Book newBook, boolean isAvailable) {
        Book oldtemp = this.books.stream()
                .filter(b -> b.equals(old))
                .findFirst().orElse(null);
        int index = books.indexOf(oldtemp);
//        System.out.println(old);
        books.remove(index);
        newBook.setAvailable(isAvailable);
        books.add(newBook);
    }

    private boolean isbnExists(String isbn) {
        for (Book book : this.books) {
            if (book.getIsbn().equals(isbn)) {
                return true;
            }
        }

        return false;
    }

    public void addBorrowed(BorrowedBook borrowedBook) {
        this.borrowedBooks.add(borrowedBook);
    }

    public List<BorrowedBook> getBorrowedBooks() {
        return borrowedBooks;
    }

    public List<Book> getBooks() {
        return this.books;
    }

    public void returnBook(BorrowedBook borrowedBook) {
        int index = borrowedBooks.indexOf(borrowedBook);

        borrowedBook.setReturnDate(LocalDate.now());

        if (borrowedBook.getReturnDate().isAfter(borrowedBook.getDueDate())) {
            borrowedBook.setLate(true);
        }

        borrowedBooks.remove(index);
        borrowedBooks.add(borrowedBook);

        Book newBook = borrowedBook.getBook();

        updateBook(borrowedBook.getBook(), newBook, true);
    }
}
