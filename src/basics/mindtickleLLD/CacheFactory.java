package basics.mindtickleLLD;

import basics.mindtickleLLD.evictionPolicy.LRUEviction;
import basics.mindtickleLLD.storage.HashMapStorage;

public class CacheFactory {

    public Cache getInstance(){
        return new Cache(
                new LRUEviction(),
                new HashMapStorage(3)
        );
    }
}
