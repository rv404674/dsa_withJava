package tuts.LocksInJava;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CounterUsingLock {
    private int count = 0;
    Lock lock = new ReentrantLock();

    // NOTE: finally will be executed regardless, whether this.count fails or not.
    public void inc(){
        try{
            lock.lock();
            this.count ++;
        } finally {
            lock.unlock();
        }
    }

    // NOTE: finally block will always be excecuted even if there is a return statement.
    public int getCount(){
        try {
            lock.lock();
            return this.count;
        } finally {
            // will be exceuted just before returning.
            lock.unlock();
        }
    }

}
