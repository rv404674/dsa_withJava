package creational.singleton.sudocode;

public class ThreadSafeLogger {
    private static ThreadSafeLogger instance = null;
    private ThreadSafeLogger(){
    }

    // NOTE: thread safe implementation of Singleton
    public static ThreadSafeLogger getInstance() {
        if(instance == null){
            synchronized (ThreadSafeLogger.class){
                // ThreadSage Block
                if(instance == null){
                    instance = new ThreadSafeLogger();
                }
            }
        }
        return instance;
    }
}
