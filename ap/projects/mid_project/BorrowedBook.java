package ap.projects.mid_project;

import java.time.LocalDate;
import java.util.Date;

public class BorrowedBook {
    Book book;
    Student borrower;
    Operator operator;
    LocalDate borrow_date;
    LocalDate return_date;
    LocalDate real_return_date;

    public BorrowedBook(Book book, Student borrower, Operator operator) {
        this.book = book;
        this.borrower = borrower;
        this.operator = operator;
        this.borrow_date = LocalDate.now();
        this.return_date = borrow_date.plusWeeks(2);
    }

    public Book getBook() {
        return book;
    }

    public Student getBorrower() {
        return borrower;
    }

    public void setRealReturnDate() {
        this.real_return_date = LocalDate.now();
    }

    public LocalDate getRealReturnDate() {
        return real_return_date;
    }

    public LocalDate getReturnDate() {
        return return_date;
    }
}
