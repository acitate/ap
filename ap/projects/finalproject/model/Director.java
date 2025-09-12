package ap.projects.finalproject.model;

import static ap.projects.finalproject.util.InputHandler.getString;

public class Director extends User {

    public Director(String name, String password) {
        super(name, password);
    }

    public Director authenticate(String password) {
        if (this.password.equals(password)) {
            System.out.println("Authentication successful.");
            return this;
        } else {
            System.out.println("Wrong password.");
            return null;
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}
