package ap.projects.finalproject.manager;

import ap.projects.finalproject.model.Book;
import ap.projects.finalproject.model.BorrowRequest;
import ap.projects.finalproject.model.Student;

import java.util.ArrayList;
import java.util.List;

public class RequestManager {
    private List<BorrowRequest> requests;

    public RequestManager() {
        this.requests = new ArrayList<>();
    }

    public void makeRequest(Book book, Student borrower) {
        requests.add(new BorrowRequest(borrower, book));
    }
}
