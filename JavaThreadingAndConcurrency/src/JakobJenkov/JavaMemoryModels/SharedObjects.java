package JakobJenkov.JavaMemoryModels;

public class SharedObjects {
    public static void main(String[] args) {
        Object object = new Object();
        Runnable runnable = new MyRunnable(object);

        // java.lang.Object@243d9e08
        //java.lang.Object@6cc912f
        //Thread 2:1034930
        //Thread 1:1034930

        // both thread will have the same count field.
        Thread thread1 = new Thread(runnable, "Thread 1");
        Thread thread2 = new Thread(runnable, "Thread 2");

        thread1.start();
        thread2.start();
    }
}
