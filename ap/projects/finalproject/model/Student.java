package ap.projects.finalproject.model;

public class Student extends Person {
    private String studentId;
    private String username;
    private String password;

    public Student(String name, String studentId, String username, String password) {
        super(name);
        this.studentId = studentId;
        this.username = username;
        this.password = password;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                " | Student ID: " + studentId +
                " | Username: " + username;
    }
}
