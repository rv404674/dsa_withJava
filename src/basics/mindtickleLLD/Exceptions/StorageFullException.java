package basics.mindtickleLLD.Exceptions;

public class StorageFullException extends RuntimeException{
    public StorageFullException(String msg){
        super(msg);
    }
}
