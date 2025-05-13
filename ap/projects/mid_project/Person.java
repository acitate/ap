package ap.projects.mid_project;

public class Person {
    protected String first_name, last_name;

    public Person(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public String getFirstName() {
        return this.first_name;
    }

    public String getLastName() {
        return this.last_name;
    }

    public void setFirstName(String firstName) {
        this.first_name = firstName;
    }

    public void setLastName(String lastName) {
        this.last_name = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                '}';
    }
}
