package ap.projects.mid_project;

public class Operator extends Person {
    private String employee_id;

    public Operator(String first_name, String last_name, String employee_id) {
        super(first_name, last_name);
        this.employee_id = employee_id;
    }

    public String getEmployeeID() {
        return this.employee_id;
    }

    public void setEmployeeID(String employee_id) {
        this.employee_id = employee_id;
    }

    @Override
    public String toString() {
        return this.first_name + " " + this.last_name + " ; " + this.employee_id;
    }
}
