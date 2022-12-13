package JakobJenkov.LocksInJava;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        // true will ensure fairness is guaranteed.
        Lock lock = new ReentrantLock(true);

        lock.lock();
        // do something - Critical section
        lock.unlock();
    }
}
