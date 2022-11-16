package Cache.gauravSen;

import Cache.gauravSen.exception.NotFoundException;
import Cache.gauravSen.exception.StorageFullException;

public class Cache {
    private final EvictionPolicy evictionPolicy;
    private final Storage storage;

    public Cache(EvictionPolicy evictionPolicy, Storage storage) {
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }

    public void put(String key, String value){
        try{
            this.storage.add(key,value);
            this.evictionPolicy.accessKey(key);
        } catch (StorageFullException ex){
            System.out.println("storage is full: Evicting a key");
            String evictedKey = evictionPolicy.evictKey();
            this.storage.remove(evictedKey);

            put(key,value);
        }
    }

    public String get(String key){
        try{
            String value = this.storage.get(key);
            this.evictionPolicy.accessKey(key);
            return value;
        } catch (NotFoundException ex){
            System.out.println("Key doesn't exist add it first.");
            return null;
        }
    }

}
