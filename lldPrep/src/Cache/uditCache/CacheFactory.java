package Cache.uditCache;

import Cache.uditCache.cache.eviction.LruEviction;
import Cache.uditCache.cache.storage.HashMapBasedStorage;

public class CacheFactory<Key,Value> {

    public Cache<Key,Value> getCache(int capacity){
        return new Cache<Key,Value>(
                new LruEviction<Key>(),
                new HashMapBasedStorage<Key,Value>(capacity)
        );
    }

}
