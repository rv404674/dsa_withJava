package LibraryManagementSystem;

public class Library {
    private int rackSize;
    private static Library instance = null;

    private Library(int rackSize){
        this.rackSize = rackSize;
    }

    public static Library getInstance(int rackSize){
        if(instance == null){
            instance = new Library(rackSize);
        }
        return instance;
    }

}
