package creational.singleton.sudocode;

public class Demo {
    public static void main(String[] args) {
        LoggerEagerLoading instance = LoggerEagerLoading.getInstance();
        System.out.println(instance);

        LoggerEagerLoading instance2 = LoggerEagerLoading.getInstance();
        System.out.println(instance2);

        // NOTE: if you dont make the constructor private, you can create a new instance using new.
        // and this is the violation as one instance should be created only and shared across all.
        // by default the constructor is public, hence you can do new.
//        LoggerEagerLoading instanceX = new LoggerEagerLoading();

        LoggerLazyLoading instance3 = LoggerLazyLoading.getInstance();
        System.out.println(instance3);

        LoggerLazyLoading instance4 = LoggerLazyLoading.getInstance();
        System.out.println(instance4);
    }
}
