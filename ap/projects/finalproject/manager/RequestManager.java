package ap.projects.finalproject.manager;

import ap.projects.finalproject.model.Book;
import ap.projects.finalproject.model.BorrowRequest;
import ap.projects.finalproject.model.Student;

import java.util.HashMap;

public class RequestManager {
    private HashMap<String, BorrowRequest> requests;

    public RequestManager() {
        this.requests = new HashMap<>();
    }

    public void makeRequest(Book book, Student borrower, String ID) {
         BorrowRequest req = new BorrowRequest(borrower, book);
        requests.put(ID, req);
    }

    public HashMap<String, BorrowRequest> getRequests() {
        return requests;
    }

    public BorrowRequest getRequest(String ID) {
        return requests.get(ID);
    }

    public void setRequestStatus(String id, BorrowRequest req) {
        requests.replace(id, req);
    }
}
