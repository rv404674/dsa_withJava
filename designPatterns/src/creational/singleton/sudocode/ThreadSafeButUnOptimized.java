package creational.singleton.sudocode;

public class ThreadSafeButUnOptimized {
    private static ThreadSafeButUnOptimized instance = null;
    private ThreadSafeButUnOptimized(){}

    // NOTE: synchronized may decrease the perf of the program by 100x.
    // However if performance of getInstance() doesnt matter, it is perfectly fine.
    // NOTE: Improvements: Once the instance has been create, aquiring and releasing the lock everytime makes no sense.
    public static synchronized ThreadSafeButUnOptimized getInstance(){
        if (instance == null) {
            instance = new ThreadSafeButUnOptimized();
        }
        return instance;
    }
}
