package basics.mindtickleLLD;

import basics.mindtickleLLD.evictionPolicy.EvictionPolicy;
import basics.mindtickleLLD.storage.Storage;

public class Cache {
    EvictionPolicy evictionPolicy;
    Storage storage;

    public Cache(EvictionPolicy evictionPolicy, Storage storage) {
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }

    public void put(String key, String value){
        try {
            System.out.println("Trying a put in the cache");
            this.storage.put(key, value);
            this.evictionPolicy.accessElement(key);
        } catch (Exception ex){
            System.out.println("Put for key:" + key + " failed");
            System.out.println("Eviction in process");

            String evictionKey = this.evictionPolicy.evictElement();
            this.storage.remove(evictionKey);
            put(key,value);
        }
    }

    public String get(String key){
        try {
            this.evictionPolicy.accessElement(key);
            return this.storage.get(key);
        } catch (Exception e){
            System.out.println("Key is not in the cache");
            return null;
        }
    }
}
