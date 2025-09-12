package ap.projects.finalproject.model;

public class Student extends User {
    private String studentId;

    public Student(String name, String username, String password, String studentId) {
        super(name, username, password);
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                " | Student ID: " + studentId +
                " | Username: " + username;
    }
}
