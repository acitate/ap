package ap.projects.finalproject.model;

public class Librarian extends Person {
    private String username;
    private String password;

    public Librarian(String name, String username, String password) {
        super(name);
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
}
