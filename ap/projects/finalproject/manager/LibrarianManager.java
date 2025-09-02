package ap.projects.finalproject.manager;

import ap.projects.finalproject.model.Librarian;

import java.util.ArrayList;
import java.util.List;

public class LibrarianManager {
    private List<Librarian> librarians;

    public LibrarianManager() {
        this.librarians = new ArrayList<>();
    }

    public void addLibrarian(String name, String username, String password) {
        if (isUsernameTaken(username)) {
            System.out.println("This username already exists. Please choose a different username.");
            return;
        } else {
            Librarian newLibrarain = new Librarian(name, username, password);
            librarians.add(newLibrarain);
            System.out.println("Successful!");
        }
    }

    private boolean isUsernameTaken(String username) {
        return librarians.stream().anyMatch(s -> s.getUsername().equals(username));
    }
}
