package creational.singleton.sudocode;

public class ThreadSafeLoggerOptimized {
    // NOTE: volatile https://www.geeksforgeeks.org/volatile-keyword-in-java/
    // will make sure changes in this instance are immediately reflected in other thread.
    private static volatile ThreadSafeLoggerOptimized instance = null;
    private ThreadSafeLoggerOptimized(){
    }

    // NOTE: Most Optimized
    // Uses Double Checked locking
    // https://en.wikipedia.org/wiki/Double-checked_locking#Usage_in_Java
    // STEPS:
    // 1. check if the variable has been initizliaed, if yes return immediately.
    // 2. if no obtain the lock (as you need object creation)
    // 3. double check the initializtion, if other thread has acquired the lock first, just return the object created.
    // 4. otherwise initialize and return the variable.
    public static ThreadSafeLoggerOptimized getInstance() {
        if(instance == null){
            synchronized (ThreadSafeLoggerOptimized.class){
                // ThreadSage Block
                if(instance == null){
                    instance = new ThreadSafeLoggerOptimized();
                }
            }
        }
        return instance;
    }
}
