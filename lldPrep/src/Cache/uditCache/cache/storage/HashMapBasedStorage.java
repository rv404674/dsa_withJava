package Cache.uditCache.cache.storage;

import Cache.uditCache.Exceptions.NotFoundException;
import Cache.uditCache.Exceptions.StorageFullException;

import java.util.HashMap;

public class HashMapBasedStorage<Key,Value> implements Storage<Key,Value> {
    HashMap<Key, Value> storage;
    private int capacity;

    public HashMapBasedStorage(int capacity) {
        this.storage = new HashMap<>();
        this.capacity = capacity;
    }

    @Override
    public void add(Key key, Value value) throws StorageFullException {
        if(isFull()) throw new StorageFullException("HashMap is FUll");
        storage.put(key,value);
    }

    @Override
    public void remove(Key key) throws NotFoundException {
        if(!storage.containsKey(key)) throw new NotFoundException("Key doesn't exist");
        storage.remove(key);
    }

    @Override
    public Value get(Key key) throws NotFoundException {
        if(!storage.containsKey(key)) throw new NotFoundException("Key doesn't exist");
        return storage.get(key);
    }

    public boolean isFull(){
        return this.capacity == storage.size();
    }
}
