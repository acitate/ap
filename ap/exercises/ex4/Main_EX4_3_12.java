package ap.exercises.ex4;

public class Main_EX4_LM_3_12 {
    public static void main(String[] args) {
        Employee harry = new Employee("Hacker, harry", 50000);
        EmployeeTester tester = new EmployeeTester();

        tester.printResults(harry, "Hacker harry", 5000, 10, 55000);

    }

}

class Employee {
    private String name;
    private double salary;

    public Employee(String employeeName, double currentSalary) {
        this.name = employeeName;
        this.salary = currentSalary;
    }

    public String getName() {
        return this.name;
    }

    public double getSalary() {
        return this.salary;
    }

    public void raiseSalary(double byPercent) {
        this.salary += (this.salary * (byPercent / 100));
    }
}

class EmployeeTester {
    public void printResults(Employee employee, String expectedName, double expectedSalary,double raise, double postRaiseSalary) {
        String actualName = employee.getName();
        double actualSalary = employee.getSalary();
        employee.raiseSalary(raise);
        double actualPostRaise = employee.getSalary();

        System.out.println("Expected name: " + expectedName + "  ;  " + "Actual name: " + actualName);
        System.out.println("Expected salary: " + expectedSalary + "  ;  " + "Actual salary: " + actualSalary);
        System.out.println("Expected post raise salary: " + postRaiseSalary + "  ;  " + "Actual post raise salary: " + actualPostRaise);


    }
}
