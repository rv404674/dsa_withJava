package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Rack {
    private Book[] rackStorage;
    private int freeSpace;

    public Rack(int rackSize) {
        this.rackStorage = new Book[rackSize];
        this.freeSpace = rackSize;
    }

    public List<Integer> addBooks(List<Book> books){
        List<Integer> slotsLeft = new ArrayList<>();
        int cnt = 0;

        for(int i=0; i< rackStorage.length; i++){
            if(rackStorage[i] == null && cnt < books.size()){
                slotsLeft.add(i);
                rackStorage[i] = books.get(cnt++);
            }
        }

        freeSpace -= books.size();

        return slotsLeft;
    }

    public int getFreeSpace() {
        return freeSpace;
    }
}
