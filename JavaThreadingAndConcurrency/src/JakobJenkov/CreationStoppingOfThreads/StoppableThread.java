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

        // NOTE: even if the main thread dies, the program will keep on running, if there is a thread
        // that is running
        InfiniteThread infiniteThread = new InfiniteThread();
        Thread thread = new Thread(infiniteThread);
        thread.start();

        Thread.sleep(2000);
        System.out.println("Main thread finished");

    }
}
