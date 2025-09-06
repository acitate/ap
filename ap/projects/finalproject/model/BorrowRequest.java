package ap.projects.finalproject.model;

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
}

enum RequestStatus {
    PENDING, APPROVED, REJECTED
}