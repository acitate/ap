package ap.projects.finalproject.model;

import static ap.projects.finalproject.util.InputHandler.getString;

public class Librarian extends User {
    private int booksAdded;

    public void setBooksAdded(int booksAdded) {
        this.booksAdded = booksAdded;
    }

    public int getBooksAdded() {
        return booksAdded;
    }

    public Librarian(String name, String username, String password) {
        super(name, username, password);
    }

    public void changePassword() {
        String current_pass = getString("Enter your current password: ");

        if (this.password.equals(current_pass)) {
            String new_pass = getString("Enter new password: ");

            if (this.password.equals(new_pass)) {
                System.out.println("This is already your password!");
                return;
            } else {
                setPassword(new_pass);
                return;
            }
        } else {
            System.out.println("Wrong password!");
            return;
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}
