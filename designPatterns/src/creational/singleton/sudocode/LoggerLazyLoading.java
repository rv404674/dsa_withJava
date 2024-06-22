package creational.singleton.sudocode;

// NOTE: Lazy loading create objects only when someone needs it.
// USE it always as no memory wastage.
public class LoggerLazyLoading {
    private static LoggerLazyLoading instance = null;
    private LoggerLazyLoading(){
    }

    public static LoggerLazyLoading getInstance(){
        if(instance == null){
            instance = new LoggerLazyLoading();
        }
        return instance;
    }
}
