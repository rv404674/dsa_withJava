package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        HashMap<String, Book> bookHashMap = new HashMap<>();
        HashMap<String, List<String>> copyBooksHashmap = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter(System.getProperty("line.separator"));

        LibraryService libraryService = new LibraryService(bookHashMap, copyBooksHashmap);

        while(scanner.hasNext()){
            String input = scanner.next();
            String[] tags = input.split(" ");

            if(tags[0].contains("create")){
                int rackSize = Integer.parseInt(tags[1]);
                Library library = Library.getInstance(rackSize);
                Rack rack = new Rack(rackSize);
                libraryService.setRack(rack);
                libraryService.setLibrary(library);
            } else if(tags[0].contains("add")){
                // add book
                libraryService.addBook(tags);
            }

        }

    }
}
