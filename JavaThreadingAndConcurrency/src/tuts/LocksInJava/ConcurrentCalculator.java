package tuts.LocksInJava;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//
public class ConcurrentCalculator {

    public static class Calculation {
        public static final int UNSPECIFIED = -1;
        public static final int ADDITION = 0;
        public static final int SUBTRACTION = 1;
        int type = UNSPECIFIED;

        public double value;

        public Calculation(int type, double value) {
            this.type = type;
            this.value = value;
        }
    }

    private double result = 0.0;
    // NOTE: we are locking a lock 3 times.
    // this is not possible by other locking mechansims.
    Lock lock = new ReentrantLock();

    public void add(double value){
        try{
            lock.lock();
            this.result += value;
        } finally {
            lock.unlock();
        }
    }

    public void subtract(double value){
        try {
            lock.lock();
            this.result -= value;
        } finally {
            lock.unlock();
        }
    }

    public void calculate(Calculation ... calculations){
        try {
            lock.lock();
            for(Calculation calculation: calculations){
                switch (calculation.type){
                    case Calculation.ADDITION -> {
                        add(calculation.value);
                        break;
                    }
                    default -> {
                        subtract(calculation.value);
                        break;
                    }
                }
            }
        } finally {
            lock.unlock();
        }
    }

}
