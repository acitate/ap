package ap.projects.mid_project;

public class Operator extends Person {
    private String employee_id;
    public int return_requests;
    public int borrow_requests;

    public Operator(String first_name, String last_name, String employee_id) {
        super(first_name, last_name);
        this.employee_id = employee_id;
        this.borrow_requests = 0;
        this.return_requests = 0;
    }

    public String getEmployeeID() {
        return this.employee_id;
    }

    public void setEmployeeID(String employee_id) {
        this.employee_id = employee_id;
    }

    @Override
    public String toString() {
        return this.first_name + " " + this.last_name + " ; " + this.employee_id + " ; return: " + this.return_requests + " borrow: " + this.borrow_requests;
    }
}
