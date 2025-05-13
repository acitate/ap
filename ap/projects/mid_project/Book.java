package ap.projects.mid_project;

public class Book {
    private String name, author, publication_year;
    private long pages;

    public Book(String name, String author, String publication_year, long pages) {
        this.name = name;
        this.author = author;
        this.publication_year = publication_year;
        this.pages = pages;
    }

    public String getName() {
        return this.name;
    }

    public String getAuthor() {
        return this.author;
    }

    public long getPages() {
        return this.pages;
    }

    public String getPublication_year() {
        return this.publication_year;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublication_year(String publication_year) {
        this.publication_year = publication_year;
    }

    public void setPages(long pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", year='" + publication_year + '\'' +
                ", pages=" + pages +
                '}';
    }
}
