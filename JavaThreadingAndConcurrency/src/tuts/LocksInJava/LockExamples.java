package tuts.LocksInJava;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExamples {
    public static void main(String[] args) {
        Runnable runnable = new ThreadImplementation();

        Thread t1 = new Thread(runnable, "t1");
        Thread t2 = new Thread(runnable, "t2");
        Thread t3 = new Thread(runnable, "t3");
        Thread t4 = new Thread(runnable, "t4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class ThreadImplementation implements Runnable {
    // NOTE: even if fairness mode is on
    //  it is not guaranteed that the order (will be t1, t2, t3, t4)
    //  because the thread scheduler might decide to stop t2 even before it reaches lock.lock()
    //   and schedule t4.
    Lock lock = new ReentrantLock(true);

    @Override
    public void run() {
        try {
            lockSleepUnlock(lock, 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void lockSleepUnlock(Lock lock , long millis) throws InterruptedException {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " hold the thread");
            Thread.sleep(millis);
        } finally {
            lock.unlock();
        }
    }


}
