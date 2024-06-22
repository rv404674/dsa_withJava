package basics.mindtickleLLD;

public class Main {
    // LLD of a cache management system
    // like redis cache
    // get(String value)
    // put(String key, String value)

    // eviction policy - inject at runtime.
    // can change the eviction policy at any time I want
    // storage consider as in memory storage
    // LRU cache - write the algorithm.

    //  NOTE: use TTL. -> 2hrs, key should autoexpire.
    //   write the autoExpire endpoint


    public static void main(String[] args) {
        CacheFactory cacheFactory = new CacheFactory();
        Cache cache = cacheFactory.getInstance();

        cache.put("1", "1");
        cache.put("2", "2");
        System.out.println(cache.get("1"));
        cache.put("3", "3");

        // 1
        // 2,1
        // 1,2
        // 3,1,2

        // put
        // 3,1,2
        // 2 is the oldest
        cache.put("4", "4");


    }


}