package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Library {
    List<Rack> rackList;
    private int totalRacks;
    private int racksLeft;
    HashMap<String, User> userHashMap;


    public Library(int totalRacks, HashMap<String, User> userHashMap) {
        this.totalRacks = totalRacks;
        this.userHashMap = userHashMap;
        this.racksLeft = totalRacks;
        this.rackList = new ArrayList<>();

        for(int i=1; i<=totalRacks; i++)
            rackList.add(new Rack(i));
    }

    public void addBooks(List<Book> books){
        if(books.size() > this.racksLeft){
            System.out.println("No Rack available");
            return;
        }

        int curBookCnt = 0;

        List<Integer> slots = new ArrayList<>();
        for(int i=1; i<this.totalRacks; i++){
            if(rackList.get(i).getBook() == null){
                // got an unused rack
                rackList.get(i).setBook(books.get(curBookCnt));
                curBookCnt +=1;
                slots.add(i);
            }

            if(curBookCnt == books.size())
                break;
        }

        this.racksLeft -= books.size();
        System.out.println("Added Book to racks: " + slots.toString());
    }

    public void removeBook(String bookId){
        // Removed book copy: book_copy6 from rack: 6
        // Invalid Book Copy ID
        int slotNumber = doesBookExists(bookId);
        if(slotNumber != -1){
            System.out.println("Removed book copy: " + bookId + " from rack: " + slotNumber);
            // also delete it from the users booklist
            // FIXME: slotNumber is 1 based. where as arraylist is 0 based. Fix it.
            Book book = rackList.get(slotNumber - 1).getBook();
            if(book.getIssuedUser() != null)
                userHashMap.get(book.getIssuedUser().getUserId()).removeBook(book);

            rackList.get(slotNumber - 1).setBook(null);
            this.racksLeft += 1;
        } else {
            System.out.println("Invalid Book Copy ID");
        }
    }

    // check if the book exists and returns a slot number
    // -1 if it doesnt exist
    public int doesBookExists(String bookId){
        int slotNumber = -1;

        for (Rack rack : this.rackList) {
            if (rack.getBook() != null && rack.getBook().getBookdId().equals(bookId)) {
                // found the book
                slotNumber = rack.getRackId();
                break;
            }
        }

        return slotNumber;
    }

    public void borrowBook(String bookId, String userId, String duedate){
        int slot = doesBookExists(bookId);
        if(slot == -1){
            System.out.println("book doesnt exist");
            return;
        }

        Book book = rackList.get(slot - 1).getBook();
        User user = this.userHashMap.get(userId);
        if(user.getBooks().size() >= 5){
            System.out.println("Overlimit");
        } else {
            // you can book it
            user.getBooks().add(book);
            // NOTE: this will automatically reflect in HM as well
            // NOTE: java uses pass by ref for non primtive types
            // when you added user to the hashmap, you stored pointer to the user in HM (not the actual use)
            // so when you follow that pointer and make changes using it, it will reflect in original hm.
            rackList.get(slot - 1).getBook().setIssuedUser(user);
        }
    }

}
