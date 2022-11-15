package Cache.uditCache.cache.storage;

import Cache.uditCache.Exceptions.NotFoundException;
import Cache.uditCache.Exceptions.StorageFullException;

public interface Storage<Key,Value> {
    public void add(Key key, Value value) throws StorageFullException;
    void remove(Key key) throws NotFoundException;
    Value get(Key key) throws NotFoundException;
}
