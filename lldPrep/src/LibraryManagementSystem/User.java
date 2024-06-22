package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userId;
    private String name;
    private List<Book> books;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
        books = new ArrayList<>();
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void removeBook(Book book){
        if(books.contains(book)) {
            books.remove(book);
        }
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }
}
