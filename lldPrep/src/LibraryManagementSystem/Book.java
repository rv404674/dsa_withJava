package LibraryManagementSystem;

import java.util.List;

public class Book {
    private String bookdId;
    private String title;
    private List<String> authors;
    private List<String> publishers;

    public Book(String bookdId, String title, List<String> authors, List<String> publishers) {
        this.bookdId = bookdId;
        this.title = title;
        this.authors = authors;
        this.publishers = publishers;
    }

    public String getBookdId() {
        return bookdId;
    }

    public void setBookdId(String bookdId) {
        this.bookdId = bookdId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public List<String> getPublishers() {
        return publishers;
    }

    public void setPublishers(List<String> publishers) {
        this.publishers = publishers;
    }
}
