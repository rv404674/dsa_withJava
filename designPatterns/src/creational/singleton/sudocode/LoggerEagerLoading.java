package creational.singleton.sudocode;

// NOTE: Two types of loading in java
// eazy loading - an instance is initialized as soon as app is up.
// Memory loss use it only if you have a single cla
public class LoggerEagerLoading {
    private static LoggerEagerLoading instance = new LoggerEagerLoading();

    private LoggerEagerLoading(){
    }

    public static LoggerEagerLoading getInstance(){
        return instance;
    }
}
