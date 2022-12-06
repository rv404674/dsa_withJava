package JakobJenkov.CreationStoppingOfThreads;

public class SleepingAndGettingReference {
    public static void main(String[] args) throws InterruptedException {
        // NOTE: the order in which the threads will be executed will not be guaranted.
        // here thread2 can run before thread1

        Runnable runnable1 = new Thread1();
        Thread thread1 = new Thread(runnable1, "Thread 1");
        thread1.start();

        // NOTE: main thread will be blocked until thread1 finished its execution
        // join will make sure, thread1 runs before thread2
        // thread1.join();

        Thread thread2 = new Thread(runnable1, "Thread 2");
        thread2.start();
    }
}

class Thread1 implements Runnable {

    @Override
    public void run() {
        // get reference to the current Thread
        String name = Thread.currentThread().getName();
        System.out.println(name + " is running");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex){
            ex.printStackTrace();
        }

        System.out.println(name + "is finished");
    }
}
