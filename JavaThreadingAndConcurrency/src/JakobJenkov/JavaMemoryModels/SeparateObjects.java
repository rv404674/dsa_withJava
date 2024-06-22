package JakobJenkov.JavaMemoryModels;

public class SeparateObjects {
    public static void main(String[] args) {
        Object object = new Object();
        Runnable runnable1 = new MyRunnable(object);
        Runnable runnable2 = new MyRunnable(object);

        // here each thread has its own runnable thread on the heap.
        // each thread has its own count field as well.
        Thread thread1 = new Thread(runnable1, "Thread 1");
        Thread thread2 = new Thread(runnable2, "Thread 2");

        thread1.start();
        thread2.start();
    }
}
