package LibraryManagementSystem;

import javax.xml.stream.events.StartDocument;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LibraryService {
    HashMap<String, Book> bookHashMap;
    HashMap<String, List<String>> copyBooksHashmap;
    Rack rack;
    Library library;

    public LibraryService(HashMap<String, Book> bookHashMap, HashMap<String, List<String>> copyBooksHashmap) {
        this.bookHashMap = bookHashMap;
        this.copyBooksHashmap = copyBooksHashmap;
    }

    // Return
    // Added Book to racks: 1,2,3
    public void addBook(String[] tags){
        List<Book> books = parseAddBookTags(tags);
        // validate rack size
        if(rack.getFreeSpace() < books.size()){
            System.out.println("Rack not available");
            return;
        }

        List<Integer> slots = rack.addBooks(books);
        // add it in the storage
        for(Book book: books)
            bookHashMap.put(book.getBookdId(), book);

        // add it in relationship storage
        for(int i=0; i< books.size(); i++){
            String curBookId = books.get(i).getBookdId();
            List<String> ids = new ArrayList<>();
            for(int x=0; x<books.size(); x++)
                if(i!=x)
                    ids.add(books.get(x).getBookdId());
            copyBooksHashmap.put(curBookId, ids);
        }

        System.out.println("Added Books to rack: " + slots.toString());
    }

    public void setRack(Rack rack) {
        this.rack = rack;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    // add_book book1 author1,author2 publisher1 book_copy1,book_copy2,book_copy3
    public List<Book> parseAddBookTags(String[] tags){
        String title = tags[1];
        List<String> authors = Arrays.asList(tags[2].split(","));
        List<String> publishers = Arrays.asList(tags[3].split(","));
        List<String> bookIds = Arrays.asList(tags[4].split(","));

        List<Book> ans = new ArrayList<>();
        for(int i=0; i<bookIds.size(); i++){
            Book book = new Book(bookIds.get(i), title, authors, publishers);
            ans.add(book);
        }

        return ans;
    }
}
