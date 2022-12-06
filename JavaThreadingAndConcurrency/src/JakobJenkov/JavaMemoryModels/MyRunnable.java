package JakobJenkov.JavaMemoryModels;

public class MyRunnable implements Runnable{
    private int count = 0;
    private Object myObject;

    MyRunnable(Object myObject){
        this.myObject = myObject;
    }

    @Override
    public void run() {

        // NOTE: each thread in case of same runnable as well
        //  will have different object, because we are doing new eveytime.
        // Object object = new Object();

        // NOTE: oncee you make it a field. Now it is shared.
        System.out.println(this.myObject);
        for(int i=0; i<1_000_000; i++) {
            this.count ++;
        }

        System.out.println(Thread.currentThread().getName() + ":" + this.count);
    }
}
