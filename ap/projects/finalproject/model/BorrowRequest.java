package ap.projects.finalproject.model;

import ap.projects.finalproject.util.IdGen;

import java.time.LocalDate;

public class BorrowRequest {
    private Student borrower;
    private Book book;
    private LocalDate borrowDate;
    private LocalDate toDate;
    private RequestStatus status;

    public BorrowRequest(Student borrower, Book book) {
        this.borrower = borrower;
        this.book = book;
        this.borrowDate = LocalDate.now();
        this.toDate = borrowDate.plusWeeks(2);
        this.status = RequestStatus.PENDING;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    public void setStatus(int status) {
        switch (status) {
            case 0:
                this.status = RequestStatus.REJECTED;
                break;
            case 1:
                this.status = RequestStatus.APPROVED;
                break;
            case 2:
                this.status = RequestStatus.PENDING;
                break;
        }
    }

    public Student getBorrower() {
        return borrower;
    }

    public void setBorrower(Student borrower) {
        this.borrower = borrower;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    @Override
    public String toString() {
        return "BorrowRequest{" +
                "borrower=" + borrower +
                ", book=" + book +
                ", borrowDate=" + borrowDate +
                ", toDate=" + toDate +
                ", status=" + status + '\'' +
                '}';
    }
}

enum RequestStatus {
    PENDING, APPROVED, REJECTED
}