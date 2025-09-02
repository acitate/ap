package ap.projects.finalproject.manager;

import ap.projects.finalproject.model.Librarian;
import ap.projects.finalproject.model.Student;

import java.util.ArrayList;
import java.util.List;

public class LibrarianManager {
    private List<Librarian> librarians;

    public LibrarianManager() {
        this.librarians = new ArrayList<>();
    }

    public void addLibrarian(String name, String username, String password) {
        // Logic for adding a new librarian. Checks if the provided username already exists.
        if (isUsernameTaken(username)) {
            System.out.println("This username already exists. Please choose a different username.");
            return;
        } else {
            Librarian newLibrarain = new Librarian(name, username, password);
            librarians.add(newLibrarain);
            System.out.println("Successful!");
        }
    }

    public Librarian authenticateLibrarian(String username, String password) {
        // Logic for librarian login. Checks if the provided info match any librarian in the list.
        return librarians.stream()
                .filter(s -> s.getUsername().equals(username) && s.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }

    public void update(Librarian old_librarian, Librarian new_librarian) {
//        librarians.indexOf(old_librarian);
        librarians.remove(old_librarian);
        librarians.add(new_librarian);
    }

    private boolean isUsernameTaken(String username) {
        return librarians.stream().anyMatch(s -> s.getUsername().equals(username));
    }


}
