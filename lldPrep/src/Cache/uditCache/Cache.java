package Cache.uditCache;

import Cache.uditCache.Exceptions.NotFoundException;
import Cache.uditCache.Exceptions.StorageFullException;
import Cache.uditCache.cache.eviction.EvictionPolicy;
import Cache.uditCache.cache.storage.Storage;

public class Cache<Key,Value> {
    // has a eviction policy + underlying storage.
    EvictionPolicy<Key> evictionPolicy;
    Storage<Key,Value> storage;

    public Cache(EvictionPolicy<Key> evictionPolicy, Storage<Key, Value> storage) {
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }

    public void put(Key key, Value value){
        // FIXME: write againl
        try {
            this.storage.add(key, value);
            this.evictionPolicy.accessKey(key);
        } catch (StorageFullException ex){
            // storage is full
            System.out.println("Storage is full: Evicting a key");
            Key keyToRemove = this.evictionPolicy.evictKey();
            if(keyToRemove == null){
                throw new RuntimeException("Storage full and no key to evict");
            }

            this.storage.remove(keyToRemove);
            System.out.println("Creating space by evicting item:" + keyToRemove);
            // then again call put
            put(key,value);
        }
    }

    public Value get(Key key){
        try {
            Value val = this.storage.get(key);
            this.evictionPolicy.accessKey(key);
            return val;
        } catch (NotFoundException ex){
            System.out.println(key + "not found in cache");
            return null;
        }
    }
}
