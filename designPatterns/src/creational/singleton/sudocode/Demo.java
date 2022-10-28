package creational.singleton.sudocode;

public class Demo {
    public static void main(String[] args) {
        LoggerEagerLoading instance = LoggerEagerLoading.getInstance();
        System.out.println(instance);

        LoggerEagerLoading instance2 = LoggerEagerLoading.getInstance();
        System.out.println(instance2);

        LoggerLazyLoading instance3 = LoggerLazyLoading.getInstance();
        System.out.println(instance3);

        LoggerLazyLoading instance4 = LoggerLazyLoading.getInstance();
        System.out.println(instance4);
    }
}
