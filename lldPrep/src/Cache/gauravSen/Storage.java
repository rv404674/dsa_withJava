package Cache.gauravSen;

// TODO: you can also implement it using StorageInterface.
// then HashMapStorage can implement it.
// but to keep it simple, we are using HashMap based Storage

import Cache.gauravSen.exception.NotFoundException;
import Cache.gauravSen.exception.StorageFullException;

import java.security.KeyException;
import java.util.HashMap;

public class Storage {
    HashMap<String, String> storage;
    private final Integer capacity;

    public Storage(Integer capacity) {
        this.capacity = capacity;
    }

    public void add(String key, String value) throws StorageFullException {
        if(storage.size() == capacity){
            throw new StorageFullException("Cache is full");
        }
        storage.put(key,value);
    }

    // will use evictionPolicy
    public void remove(String key) throws NotFoundException {
        if(!storage.containsKey(key)){
            throw new NotFoundException("key doesnt exist");
        }
        storage.remove(key);
    }

    public String get(String key){
        return storage.get(key);
    }

    public boolean isFull(){
        return storage.size() == capacity;
    }
}
