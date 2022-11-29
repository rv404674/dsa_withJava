package LibraryManagementSystem;

import java.util.*;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter(System.getProperty("line.separator"));

        Library library = null;
        HashMap<String, User> hashMap = new HashMap<>();
        hashMap.put("user1", new User("user1", "Rahul Verma"));
        hashMap.put("user2", new User("user2", "Ruby Verma"));
        hashMap.put("user3", new User("user3", "Sachin Verma"));

        while(scanner.hasNext()){
            String input = scanner.next();
            String[] tags = input.split(" ");

            if(tags[0].equals("create_library")){
                // create_library 10
                library = new Library(Integer.parseInt(tags[1]), hashMap);
            } else if(tags[0].equals("add_book")){
                // add_book book1 author1,author2 publisher1 book_copy1,book_copy2,book_copy3
                List<Book> books = parseAddBookTags(tags);
                library.addBooks(books);
            } else if(tags[0].equals("remove_book_copy")){
                // remove_book_copy book_copy13
                library.removeBook(tags[1]);
            } else if(tags[0].contains("search")){
                // search book_id 1
                // just traverse through racks and search the bookId
            } else if(tags[0].contains("borrow_book")){
                // borrow_book 4 user1 2020-12-31
                // borrow_book <book_id> <user_id> <due_date>
                library.borrowBook(tags[1], tags[2], tags[3]);
            }
        }

        // FIXME: for later
        // 1. Can have a bookStatus ENum - Reserved, Issued
        // 2. For searc, a Search Service
        // getBooksByTitle(String title)
        // getBooksByAuthro(String author)

        // class Author {
        // list<Book> publishedBooks}

        // FIXME: add TestCases as well.
        // FIXME: think about the usecase
        // if a book has been issued, can it be issued to another user.
        // if a book is removed, it shouldnt be in users issue book.
        // check for vlaid book.

    }

    public static List<Book> parseAddBookTags(String[] tags){
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
