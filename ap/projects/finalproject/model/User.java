package ap.projects.finalproject.model;

import static ap.projects.finalproject.util.InputHandler.getString;

public class User {
    protected String name, username, password;

    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void changePassword() {
//        String current_pass = getString("Enter your current password: ");
//
//        if (this.password.equals(current_pass)) {
//            String new_pass = getString("Enter new password: ");
//
//            if (this.password.equals(new_pass)) {
//                System.out.println("This is already your password!");
//                return;
//            } else {
//                setPassword(new_pass);
//                return;
//            }
//        } else {
//            System.out.println("Wrong password!");
//            return;
//        }
    }
}

