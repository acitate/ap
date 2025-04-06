package ap.exercises.ex3;

public class Main_EX3_LM_1_1 {
    public static void main(String[] args) {
        Book b1= new Book("1984", "George Orwell", "1949", 328);
        Book b2= new Book("Brave new world", "Aldous Huxley", "1931", 321);

        Student s1 = new Student("John", "Darksoul", "435482576", "Software Engineering");
        Student s2 = new Student("Ali", "Hamedani Asl", "435715989", "Medicine");
    }
}


class Book {
    private String name, author, year;
    private long pages;

    public Book(String name, String author, String year, long pages) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.pages = pages;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public long getPages() {
        return pages;
    }

    public String getYear() {
        return year;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setPages(long pages) {
        this.pages = pages;
    }
}


class Student {
    private String FirstName, LastName, StudentID, Major;

    public Student(String first_name, String last_name, String student_id, String major) {
        FirstName = first_name;
        LastName = last_name;
        StudentID = student_id;
        Major = major;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getStudentID() {
        return StudentID;
    }

    public String getMajor() {
        return Major;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public void setMajor(String major) {
        Major = major;
    }
}