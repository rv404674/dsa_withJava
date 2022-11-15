package Cache.uditCache;

public class Main {
    public static void main(String[] args) {
        // In Memory store like redis
        // PS - https://workat.tech/machine-coding/practice/design-key-value-store-6gz6cq124k65
        // Video Explanation - https://www.youtube.com/watch?v=B7iCXl_KSoM&list=PL564gOx0bCLqTolRIHIsR2JPv11w8LESW&index=3&t=955s
        // Code - https://github.dev/anomaly2104/cache-low-level-system-design

        // NOTE: Underlying DS - DLL + Hashmap
        // Just write it in a OOPS way.
        // using generics here as well.

        CacheFactory<String, Integer> cacheFactory = new CacheFactory<>();
        Cache cache = cacheFactory.getCache(10);



    }
}
