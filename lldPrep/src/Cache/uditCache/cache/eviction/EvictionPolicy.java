package Cache.uditCache.cache.eviction;

public interface EvictionPolicy<Key> {
    public void accessKey(Key key);
    public Key evictKey();
}
