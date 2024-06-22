package JakobJenkov.CreationStoppingOfThreads;

class StoppableRunnable implements Runnable {

    private boolean stopRequested = false;

    public synchronized void requestStop(){
        this.stopRequested = true;
    }

    public synchronized boolean getStopRequest(){
        return this.stopRequested;
    }

    private void sleep(long millis){
        try{
            Thread.sleep(millis);
        } catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }


    @Override
    public void run() {
        System.out.println("Stoppable Thread running");
        while(!getStopRequest()){
            // till it is false run
            sleep(1000);
            System.out.println("...");
        }
        System.out.println("Stoppable Thread stopped");
    }
}

class InfiniteThread implements Runnable {

    @Override
    public void run() {
        while (true){
            String name = Thread.currentThread().getName();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + "is running");
        }
    }
}

public class StoppableThread {
    public static void main(String[] args) throws InterruptedException {
        // create a thread that can stop.
        // NOTE: How to create a thread that can stop
//        StoppableRunnable stoppableRunnable = new StoppableRunnable();
//        Thread thread = new Thread(stoppableRunnable);
//        thread.start();
//
//        Thread.sleep(5000);
//
//        // set is to false
//        System.out.println("Requesting stop");
//        stoppableRunnable.requestStop();

        // NOTE: JVM will stay alive, as long as there are any threads running.
        //  so basically, even if main thread dies and there is a thread running, JVM will still run.
        InfiniteThread infiniteThread = new InfiniteThread();
        Thread thread = new Thread(infiniteThread);

        // if you dont want a thread to keep JVM alive, then mark it daemon.
        // NOTE: daemon threads are stopped in an undefined state, so make sure that you dont put any imp code in it.
        // thread.setDaemon(true);
        thread.start();

        Thread.sleep(2000);
        System.out.println("Main thread finished");

    }
}
