package tuts;


// NOTE: Resources
// GFg implementation - https://www.geeksforgeeks.org/how-to-use-counting-semaphore-in-concurrent-java-application/
// https://medium.com/@waqas.memon/java-threads-semaphores-44b4597453ee
// https://stackoverflow.com/questions/17683575/binary-semaphore-vs-a-reentrantlock
// Semaphores actual use - https://medium.com/@kiitvishal89/semaphores-break-the-ice-with-concurrency-fc1cee0f4e2f


import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BinarySemaphore {
    public static void main(String[] args) throws InterruptedException {
        ThreadImplementation runnable = new ThreadImplementation();
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);
        Thread t4 = new Thread(runnable);


        t1.start();
        t2.start();
        t3.start();
        t4.start();

        Thread.sleep(6000);
        System.out.println(runnable.getCount());
    }
}

class ThreadImplementation implements Runnable {
    Semaphore binarySemaphore = new Semaphore(1);
    int count = 0;

    @Override
    public void run() {
        try {
            binarySemaphore.acquire();
//            lock.lock();

            // mutual exclusive region
            this.count +=1;
            System.out.println(Thread.currentThread().getName() + " inside mutual exclusie");
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            binarySemaphore.release();
//            lock.unlock();
        }
    }

    public int getCount() {
        System.out.println("getting count value");
        return count;
    }
}
