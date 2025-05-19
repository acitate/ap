package ap.projects.mid_project;

import java.time.LocalDate;

public class Student extends Person {
    private String major, student_id;
    private transient LocalDate membership_date;
    private String membership_date_str;

    public Student(String first_name, String last_name, String major, String student_id) {
        super(first_name, last_name);
        this.major = major;
        this.membership_date = LocalDate.now();
        this.membership_date_str = membership_date.toString();
        this.student_id = student_id;
    }

    public String getMajor() {
        return this.major;
    }

    public LocalDate getMembershipDate() {
        return this.membership_date;
    }

    public String getStudentID() {
        return this.student_id;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setStudentID(String student_id) {
        this.student_id = student_id;
    }

    @Override
    public String toString() {
        return this.first_name + " " +this.last_name + " ; " + this.student_id + " " + membership_date_str;

    }
}
