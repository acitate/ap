package ap.projects.finalproject.manager;

import ap.projects.finalproject.model.Librarian;
import ap.projects.finalproject.model.Student;
import ap.projects.finalproject.model.User;

import java.util.ArrayList;
import java.util.List;

public class StudentManager implements update{
    private List<Student> students;

    public StudentManager() {
        this.students = new ArrayList<>();
    }

    public void registerStudent(String name, String studentId, String username, String password) {
        // Logic for registering a new student. Checks the student list to see if the provided username is already in use.
        if (isUsernameTaken(username)) {
            System.out.println("This username already exists. Please choose a different username.");
            return;
        }

        Student newStudent = new Student(name, username, password, studentId);
        students.add(newStudent);
        System.out.println("Student registration completed successfully.");
    }

    public Student authenticateStudent(String username, String password) {
        // Logic for student login. Checks if the provided info match any student in the list.
        return students.stream()
                .filter(s -> s.getUsername().equals(username) && s.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }

    private boolean isUsernameTaken(String username) {
        return students.stream().anyMatch(s -> s.getUsername().equals(username));
    }

    public int getStudentCount() {
        return students.size();
    }

    public List<Student> getStudents() {
        return students;
    }

    public Student getStudent(String username) {
        for (Student student : this.students) {
            if (student.getUsername().equals(username)) {
                return student;
            }
        }

        return null;
    }

    @Override
    public void update(User Old, User New) {
        students.remove((Student) Old);
        students.add((Student) New);
    }

}