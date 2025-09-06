package ap.projects.finalproject.model;

public class Book {
    private String title, author, publicationDate, isbn;
    private boolean isAvailable;
    private long pages;

    public Book(String title, String author, String publicationDate, String isbn, long pages) {
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
        this.isbn = isbn;
        this.pages = pages;
        this.isAvailable = true;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public long getPages() {
        return this.pages;
    }

    public String getPublicationDate() {
        return this.publicationDate;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void setPages(long pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year='" + publicationDate + '\'' +
                ", pages=" + pages +
                '}';
    }
}
