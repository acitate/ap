package ap.projects.mid_project;

public class Manager extends Person {
    private String certificate;

    public Manager(String first_name, String last_name, String certificate) {
        super(first_name, last_name);
        this.certificate = certificate;
    }

    public String getCertificate() {
        return this.certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    @Override
    public String toString() {
        return this.first_name + ' ' + this.getLastName();
    }
}
