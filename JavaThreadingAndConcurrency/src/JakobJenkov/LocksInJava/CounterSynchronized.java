package JakobJenkov.LocksInJava;

public class CounterSynchronized {
    private int count = 0;

    public synchronized void inc() {
        this.count ++;
    }

    public synchronized int getCount(){
        return this.count;
    }
}
