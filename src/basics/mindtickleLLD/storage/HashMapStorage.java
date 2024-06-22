package basics.mindtickleLLD.storage;

import basics.mindtickleLLD.Cache;
import basics.mindtickleLLD.Exceptions.ElementNotFoundException;
import basics.mindtickleLLD.Exceptions.StorageFullException;

import java.util.HashMap;

public class HashMapStorage implements Storage {
    private HashMap<String, String> hashMap;
    private int capacity;

    public HashMapStorage(int capacity) {
        this.hashMap = new HashMap<>();
        this.capacity = capacity;
    }

    @Override
    public void put(String key, String value) throws StorageFullException{
        if(hashMap.size() >= capacity)
            throw new StorageFullException("Underlying storage is full");
        hashMap.put(key, value);
    }

    @Override
    public String get(String key) {
        if(!hashMap.containsKey(key))
            throw new ElementNotFoundException("They given key: " + key + " doesn't exists");
        return hashMap.get(key);
    }

    @Override
    public void remove(String key) {
        if(!hashMap.containsKey(key))
            throw new ElementNotFoundException("They given key: " + key + " doesn't exists");
        hashMap.remove(key);
    }
}
