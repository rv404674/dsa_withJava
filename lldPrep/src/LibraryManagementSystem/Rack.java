package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Rack {
    private int rackId;
    private Book book;

    public Rack(int rackId) {
        this.rackId = rackId;
        this.book = null;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getRackId() {
        return rackId;
    }
}
