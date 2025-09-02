package ap.projects.finalproject.model;

import static ap.projects.finalproject.util.InputHandler.getString;

public class Director extends Person {
    String password;

    public Director(String name, String password) {
        super(name);
        this.password = password;
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

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
