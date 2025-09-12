package ap.projects.finalproject.model;



import java.time.LocalDate;

public class BorrowedBook {
    private Book book;
    private Student borrower;
    private Librarian librarian;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
//    LocalDate real_return_date;

    public BorrowedBook(Book book, Student borrower, Librarian librarian, LocalDate dueDate) {
        this.book = book;
        this.borrower = borrower;
        this.librarian = librarian;
        this.borrowDate = LocalDate.now();
        this.dueDate = borrowDate.plusWeeks(2);
    }

    public BorrowedBook(BorrowRequest borrowRequest) {
        this.book = borrowRequest.getBook();
        this.borrower = borrowRequest.getBorrower();
        this.borrowDate = borrowRequest.getBorrowDate();
        this.dueDate = borrowRequest.getToDate();
    }
}
