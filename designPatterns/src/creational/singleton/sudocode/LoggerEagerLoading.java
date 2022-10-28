package creational.singleton.sudocode;

// NOTE: Two types of loading in java
// eazy loading - an instance is initialized as soon as app is up.
// Memory loss use it only if you have a single cla
public class LoggerEagerLoading {
    private static LoggerEagerLoading instance = new LoggerEagerLoading();

    // NOTE:
    // if you dont make the constructogr private, you can create new objects using new.
    // which is violation of singleton as once instance should be created and used across all.
    private LoggerEagerLoading(){
    }

    public static LoggerEagerLoading getInstance(){
        return instance;
    }
}
